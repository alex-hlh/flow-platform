package com.run.flow.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.run.flow.model.RouterVo;
import com.run.flow.pojo.SysMenu;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface ISysMenuService extends IService<SysMenu> {

	Collection<String> selectMenuPermsByUserId(Long userId);

	List<SysMenu> selectMenuTreeByUserId(Long userId);

	List<RouterVo> buildMenus(List<SysMenu> menus);
}
