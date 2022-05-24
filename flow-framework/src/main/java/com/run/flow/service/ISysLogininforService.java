package com.run.flow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.run.flow.pojo.SysLogininfor;

/**
 * <p>
 * 系统访问记录 服务类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface ISysLogininforService extends IService<SysLogininfor> {

	void insertLogininfor(SysLogininfor logininfor);
}
