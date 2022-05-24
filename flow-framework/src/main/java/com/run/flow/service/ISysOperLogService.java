package com.run.flow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.run.flow.pojo.SysOperLog;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface ISysOperLogService extends IService<SysOperLog> {

	void insertOperlog(SysOperLog operLog);
}
