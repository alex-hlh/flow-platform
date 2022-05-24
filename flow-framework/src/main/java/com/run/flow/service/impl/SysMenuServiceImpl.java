package com.run.flow.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.constant.Constants;
import com.run.flow.constant.UserConstants;
import com.run.flow.mapper.SysMenuMapper;
import com.run.flow.model.MetaVo;
import com.run.flow.model.RouterVo;
import com.run.flow.pojo.SysMenu;
import com.run.flow.service.ISysMenuService;
import com.run.flow.utils.SecurityUtils;
import com.run.flow.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

	@Autowired
	private SysMenuMapper menuMapper;

	@Override
	public Collection<String> selectMenuPermsByUserId(Long userId) {
		List<String> perms = menuMapper.selectMenuPermsByUserId(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotEmpty(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<SysMenu> selectMenuTreeByUserId(Long userId) {
		List<SysMenu> menus = null;
		if (SecurityUtils.isAdmin(userId)) {
			menus = menuMapper.selectMenuTreeAll();
		} else {
			menus = menuMapper.selectMenuTreeByUserId(userId);
		}
		return getChildPerms(menus, 0);
	}

	@Override
	public List<RouterVo> buildMenus(List<SysMenu> menus) {
		List<RouterVo> routers = new LinkedList<RouterVo>();
		for (SysMenu menu : menus) {
			RouterVo router = new RouterVo();
			router.setHidden("1".equals(menu.getVisible()));
			router.setName(getRouteName(menu));
			router.setPath(getRouterPath(menu));
			router.setComponent(getComponent(menu));
			router.setQuery(menu.getQuery());
			router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache()), menu.getPath()));
			List<SysMenu> cMenus = menu.getChildren();
			if (CollUtil.isNotEmpty(cMenus) && UserConstants.TYPE_DIR.equals(menu.getMenuType())) {
				router.setAlwaysShow(true);
				router.setRedirect("noRedirect");
				router.setChildren(buildMenus(cMenus));
			} else if (isMenuFrame(menu)) {
				router.setMeta(null);
				List<RouterVo> childrenList = new ArrayList<RouterVo>();
				RouterVo children = new RouterVo();
				children.setPath(menu.getPath());
				children.setComponent(menu.getComponent());
				children.setName(StringUtils.capitalize(menu.getPath()));
				children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache()), menu.getPath()));
				children.setQuery(menu.getQuery());
				childrenList.add(children);
				router.setChildren(childrenList);
			} else if (menu.getParentId().intValue() == 0 && isInnerLink(menu)) {
				router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon()));
				router.setPath("/inner");
				List<RouterVo> childrenList = new ArrayList<RouterVo>();
				RouterVo children = new RouterVo();
				String routerPath = innerLinkReplaceEach(menu.getPath());
				children.setPath(routerPath);
				children.setComponent(UserConstants.INNER_LINK);
				children.setName(StringUtils.capitalize(routerPath));
				children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), menu.getPath()));
				childrenList.add(children);
				router.setChildren(childrenList);
			}
			routers.add(router);
		}
		return routers;
	}

	/**
	 * 获取组件信息
	 *
	 * @param menu 菜单信息
	 * @return 组件信息
	 */
	public String getComponent(SysMenu menu) {
		String component = UserConstants.LAYOUT;
		if (StringUtils.isNotEmpty(menu.getComponent()) && !isMenuFrame(menu)) {
			component = menu.getComponent();
		} else if (StringUtils.isEmpty(menu.getComponent()) && menu.getParentId().intValue() != 0 && isInnerLink(menu)) {
			component = UserConstants.INNER_LINK;
		} else if (StringUtils.isEmpty(menu.getComponent()) && isParentView(menu)) {
			component = UserConstants.PARENT_VIEW;
		}
		return component;
	}

	/**
	 * 是否为parent_view组件
	 *
	 * @param menu 菜单信息
	 * @return 结果
	 */
	public boolean isParentView(SysMenu menu) {
		return menu.getParentId().intValue() != 0 && UserConstants.TYPE_DIR.equals(menu.getMenuType());
	}

	/**
	 * 获取路由地址
	 *
	 * @param menu 菜单信息
	 * @return 路由地址
	 */
	public String getRouterPath(SysMenu menu) {
		String routerPath = menu.getPath();
		// 内链打开外网方式
		if (menu.getParentId().intValue() != 0 && isInnerLink(menu)) {
			routerPath = innerLinkReplaceEach(routerPath);
		}
		// 非外链并且是一级目录（类型为目录）
		if (0 == menu.getParentId().intValue() && UserConstants.TYPE_DIR.equals(menu.getMenuType())
				&& UserConstants.NO_FRAME.equals(menu.getIsFrame())) {
			routerPath = "/" + menu.getPath();
		}
		// 非外链并且是一级目录（类型为菜单）
		else if (isMenuFrame(menu)) {
			routerPath = "/";
		}
		return routerPath;
	}

	/**
	 * 内链域名特殊字符替换
	 *
	 * @return
	 */
	public String innerLinkReplaceEach(String path) {
		return StringUtils.replaceEach(path, new String[]{Constants.HTTP, Constants.HTTPS},
				new String[]{"", ""});
	}

	/**
	 * 是否为内链组件
	 *
	 * @param menu 菜单信息
	 * @return 结果
	 */
	public boolean isInnerLink(SysMenu menu) {
		return menu.getIsFrame().equals(UserConstants.NO_FRAME) && StringUtils.ishttp(menu.getPath());
	}

	/**
	 * 获取路由名称
	 *
	 * @param menu 菜单信息
	 * @return 路由名称
	 */
	public String getRouteName(SysMenu menu) {
		String routerName = StringUtils.capitalize(menu.getPath());
		// 非外链并且是一级目录（类型为目录）
		if (isMenuFrame(menu)) {
			routerName = StringUtils.EMPTY;
		}
		return routerName;
	}

	/**
	 * 是否为菜单内部跳转
	 *
	 * @param menu 菜单信息
	 * @return 结果
	 */
	public boolean isMenuFrame(SysMenu menu) {
		return menu.getParentId().intValue() == 0 && UserConstants.TYPE_MENU.equals(menu.getMenuType())
				&& menu.getIsFrame().equals(UserConstants.NO_FRAME);
	}

	public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId) {
		List<SysMenu> returnList = new ArrayList<SysMenu>();
		for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext(); ) {
			SysMenu t = (SysMenu) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (t.getParentId() == parentId) {
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}

	/**
	 * 递归列表
	 *
	 * @param list
	 * @param t
	 */
	private void recursionFn(List<SysMenu> list, SysMenu t) {
		// 得到子节点列表
		List<SysMenu> childList = getChildList(list, t);
		t.setChildren(childList);
		for (SysMenu tChild : childList) {
			if (hasChild(list, tChild)) {
				recursionFn(list, tChild);
			}
		}
	}

	/**
	 * 得到子节点列表
	 */
	private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t) {
		List<SysMenu> tlist = new ArrayList<SysMenu>();
		Iterator<SysMenu> it = list.iterator();
		while (it.hasNext()) {
			SysMenu n = (SysMenu) it.next();
			if (n.getParentId().longValue() == t.getMenuId().longValue()) {
				tlist.add(n);
			}
		}
		return tlist;
	}

	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<SysMenu> list, SysMenu t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
}
