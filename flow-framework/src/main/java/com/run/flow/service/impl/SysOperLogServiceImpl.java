package com.run.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.mapper.SysOperLogMapper;
import com.run.flow.pojo.SysOperLog;
import com.run.flow.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {

	@Autowired
	private SysOperLogMapper sysOperLogMapper;

	@Override
	public void insertOperlog(SysOperLog operLog) {
		sysOperLogMapper.insert(operLog);
	}
}
