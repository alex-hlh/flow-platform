package com.run.flow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.run.flow.pojo.SysUser;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface ISysUserService extends IService<SysUser> {

	SysUser selectUserByUserName(String username);

	int updateUserProfile(SysUser sysUser);
}
