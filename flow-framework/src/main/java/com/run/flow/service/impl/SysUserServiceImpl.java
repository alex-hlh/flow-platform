package com.run.flow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.mapper.SysUserMapper;
import com.run.flow.pojo.SysUser;
import com.run.flow.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser selectUserByUserName(String username) {
		QueryWrapper wrapper = new QueryWrapper();
		wrapper.eq("user_name", username);
		return sysUserMapper.selectOne(wrapper);
	}

	@Override
	public int updateUserProfile(SysUser sysUser) {
		return sysUserMapper.updateUser(sysUser);
	}
}
