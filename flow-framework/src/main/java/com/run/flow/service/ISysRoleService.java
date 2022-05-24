package com.run.flow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.run.flow.pojo.SysRole;

import java.util.Collection;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface ISysRoleService extends IService<SysRole> {

	Collection<String> selectRolePermissionByUserId(Long userId);
}
