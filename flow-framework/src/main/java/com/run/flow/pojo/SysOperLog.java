package com.run.flow.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_oper_log")
@ApiModel(value = "SysOperLog对象", description = "操作日志记录")
public class SysOperLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "日志主键")
	@TableId(value = "oper_id", type = IdType.AUTO)
	private Long operId;

	@ApiModelProperty(value = "模块标题")
	private String title;

	@ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除）")
	@TableField("business_type")
	private Integer businessType;

	@ApiModelProperty(value = "方法名称")
	private String method;

	@ApiModelProperty(value = "请求方式")
	@TableField("request_method")
	private String requestMethod;

	@ApiModelProperty(value = "操作类别（0其它 1后台用户 2手机端用户）")
	@TableField("operator_type")
	private Integer operatorType;

	@ApiModelProperty(value = "操作人员")
	@TableField("oper_name")
	private String operName;

	@ApiModelProperty(value = "部门名称")
	@TableField("dept_name")
	private String deptName;

	@ApiModelProperty(value = "请求URL")
	@TableField("oper_url")
	private String operUrl;

	@ApiModelProperty(value = "主机地址")
	@TableField("oper_ip")
	private String operIp;

	@ApiModelProperty(value = "操作地点")
	@TableField("oper_location")
	private String operLocation;

	@ApiModelProperty(value = "请求参数")
	@TableField("oper_param")
	private String operParam;

	@ApiModelProperty(value = "返回参数")
	@TableField("json_result")
	private String jsonResult;

	@ApiModelProperty(value = "操作状态（0正常 1异常）")
	private Integer status;

	@ApiModelProperty(value = "错误消息")
	@TableField("error_msg")
	private String errorMsg;

	@ApiModelProperty(value = "操作时间")
	@TableField("oper_time")
	private LocalDateTime operTime;


}
