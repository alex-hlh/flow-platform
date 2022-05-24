package com.run.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.mapper.SysLogininforMapper;
import com.run.flow.pojo.SysLogininfor;
import com.run.flow.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforMapper, SysLogininfor> implements ISysLogininforService {

	@Autowired
	private SysLogininforMapper sysLogininforMapper;

	@Override
	public void insertLogininfor(SysLogininfor logininfor) {
		sysLogininforMapper.insert(logininfor);
	}
}
