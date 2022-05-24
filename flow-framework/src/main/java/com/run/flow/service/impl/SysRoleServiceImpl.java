package com.run.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.mapper.SysRoleMapper;
import com.run.flow.pojo.SysRole;
import com.run.flow.service.ISysRoleService;
import com.run.flow.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public Collection<String> selectRolePermissionByUserId(Long userId) {
		List<SysRole> perms = sysRoleMapper.selectRolePermissionByUserId(userId);
		Set<String> permsSet = new HashSet<>();
		for (SysRole perm : perms) {
			if (StringUtils.isNotNull(perm)) {
				permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
			}
		}
		return permsSet;
	}
}
