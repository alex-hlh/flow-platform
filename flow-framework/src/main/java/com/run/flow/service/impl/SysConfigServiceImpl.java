package com.run.flow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.common.Convert;
import com.run.flow.mapper.SysConfigMapper;
import com.run.flow.pojo.SysConfig;
import com.run.flow.service.ISysConfigService;
import com.run.flow.utils.RedisUtil;
import com.run.flow.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

	@Autowired
	private SysConfigMapper mapper;

	@Autowired
	private RedisUtil redisUtil;

	@Override
	public boolean selectCaptchaOnOff() {
		QueryWrapper<SysConfig> wrapper = new QueryWrapper();
		wrapper.eq("config_key", "sys.account.captchaOnOff");
		SysConfig retConfig = mapper.selectOne(wrapper);
		if (StringUtils.isNotNull(retConfig)) {
			redisUtil.setCacheObject("sys.account.captchaOnOff", retConfig.getConfigValue());
			return Convert.toBool(retConfig.getConfigValue());
		}
		return Convert.toBool(StringUtils.EMPTY);
	}
}
