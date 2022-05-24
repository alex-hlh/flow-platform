package com.run.flow.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.UUID;
import com.google.code.kaptcha.Producer;
import com.run.flow.common.CommonResult;
import com.run.flow.constant.Constants;
import com.run.flow.model.LoginBody;
import com.run.flow.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @Author: hlh
 * @Date: 2022-05-24 20:24
 */
@RestController
@Api(tags = "获取验证码")
public class CaptchaController {

	@Resource(name = "captchaProducer")
	private Producer captchaProducer;

	@Resource(name = "captchaProducerMath")
	private Producer captchaProducerMath;

	@Autowired
	private RedisUtil redisUtil;

	@Value("${system.captchaType}")
	private String captchaType;

	/**
	 * @Description: TODO
	 * @Author: hlh
	 * @Date: 2022-05-24 20:24
	 * @Param: [javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse]
	 * @Return: CommonResult
	 */
	@ApiOperation(value = "验证码")
	@ApiImplicitParams({

	})
	@GetMapping(value = "/captchaImage")
	public CommonResult captcha(HttpServletRequest request, HttpServletResponse response) {
		CommonResult result = CommonResult.success("success");
		// 保存验证码信息
		String uuid = UUID.fastUUID().toString();
		String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
		String capStr = null, code = null;
		BufferedImage image = null;

		// 生成验证码
		if ("math".equals(captchaType)) {
			String capText = captchaProducerMath.createText();
			System.out.println(capText);
			capStr = capText.substring(0, capText.lastIndexOf("@"));
			code = capText.substring(capText.lastIndexOf("@") + 1);
			image = captchaProducerMath.createImage(capStr);
		} else if ("char".equals(captchaType)) {
			capStr = code = captchaProducer.createText();
			System.out.println(capStr);
			image = captchaProducer.createImage(capStr);
		}

		redisUtil.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
		// 转换流信息写出
		FastByteArrayOutputStream os = new FastByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpg", os);
		} catch (IOException e) {
			return CommonResult.error(e.getMessage());
		}
		HashMap<String, String> data = new HashMap<>();
		data.put("uuid", uuid);
		data.put("img", Base64.encode(os.toByteArray()));
		result.setData(data);
		return result;
	}
}
