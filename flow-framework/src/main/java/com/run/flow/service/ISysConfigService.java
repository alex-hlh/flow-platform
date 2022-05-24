package com.run.flow.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.run.flow.pojo.SysConfig;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface ISysConfigService extends IService<SysConfig> {

	boolean selectCaptchaOnOff();
}
