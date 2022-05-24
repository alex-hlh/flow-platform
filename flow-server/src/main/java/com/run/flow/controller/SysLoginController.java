package com.run.flow.controller;

import com.run.flow.common.CommonResult;
import com.run.flow.constant.Constants;
import com.run.flow.model.LoginBody;
import com.run.flow.pojo.SysMenu;
import com.run.flow.pojo.SysUser;
import com.run.flow.service.ISysMenuService;
import com.run.flow.utils.SecurityUtils;
import com.run.flow.web.SysLoginService;
import com.run.flow.web.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
@Api(tags = "用户登录")
public class SysLoginController {
	@Autowired
	private SysLoginService loginService;

	@Autowired
	private ISysMenuService menuService;

	@Autowired
	private SysPermissionService permissionService;

	@PostMapping("/login")
	@ApiOperation("用户登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "loginBody", value = "登录用户信息", required = true, dataType = "LoginBody", dataTypeClass = LoginBody.class),
	})
	@ResponseBody
	public CommonResult login(@RequestBody LoginBody loginBody) {
		// 生成令牌
		String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
				loginBody.getUuid());
		Map<String, Object> tokenMap = new HashMap<>();
		tokenMap.put(Constants.TOKEN, token);
		return CommonResult.success(tokenMap);
	}

	/**
	 * 获取用户信息
	 *
	 * @return 用户信息
	 */
	@GetMapping("getInfo")
	public CommonResult getInfo() {
		SysUser user = SecurityUtils.getLoginUser().getUser();
		// 角色集合
		Set<String> roles = permissionService.getRolePermission(user);
		// 权限集合
		Set<String> permissions = permissionService.getMenuPermission(user);
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("user", user);
		userMap.put("roles", roles);
		userMap.put("permissions", permissions);
		return CommonResult.success(userMap);
	}

	/**
	 * 获取路由信息
	 *
	 * @return 路由信息
	 */
	@GetMapping("getRouters")
	public CommonResult getRouters() {
		Long userId = SecurityUtils.getUserId();
		List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
		return CommonResult.success(menuService.buildMenus(menus));
	}
}
