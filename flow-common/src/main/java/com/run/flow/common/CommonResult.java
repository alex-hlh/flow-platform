package com.run.flow.common;


import com.run.flow.constant.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 操作消息提醒
 *
 * @author ruoyi
 */
@ApiModel(value = "AjaxResult", description = "通用响应信息")
public class CommonResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 状态码
	 */
	@ApiModelProperty(value = "状态码", required = true)
	private Integer code;
	/**
	 * 返回内容
	 */
	@ApiModelProperty(value = "返回内容", required = false)
	private String msg;
	/**
	 * 数据对象
	 */
	@ApiModelProperty(value = "数据对象", required = false)
	private T data;

	/**
	 * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
	 */
	public CommonResult() {
	}

	/**
	 * 初始化一个新创建的 AjaxResult 对象
	 *
	 * @param code 状态码
	 * @param msg  返回内容
	 */
	public CommonResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 初始化一个新创建的 AjaxResult 对象
	 *
	 * @param code 状态码
	 * @param msg  返回内容
	 * @param data 数据对象
	 */
	public CommonResult(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> CommonResult<T> success() {
		return CommonResult.success("操作成功");
	}

	public static <T> CommonResult<T> success(Object data) {
		return CommonResult.success("操作成功", data);
	}

	public static <T> CommonResult<T> success(String msg) {
		return CommonResult.success(msg, null);
	}

	public static <T> CommonResult<T> success(String msg, Object data) {
		return new CommonResult(HttpStatus.SUCCESS, msg, data);
	}

	public static <T> CommonResult<T> error() {
		return CommonResult.error("操作失败");
	}

	public static <T> CommonResult<T> error(String msg) {
		return CommonResult.error(msg, null);
	}

	public static <T> CommonResult<T> error(String msg, Object data) {
		return new CommonResult(HttpStatus.ERROR, msg, data);
	}

	public static <T> CommonResult<T> error(int code, String msg) {
		return new CommonResult(code, msg);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
