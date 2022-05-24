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
 * 定时任务调度表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_job")
@ApiModel(value = "SysJob对象", description = "定时任务调度表")
public class SysJob implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "任务ID")
	@TableId(value = "job_id", type = IdType.AUTO)
	private Long jobId;

	@ApiModelProperty(value = "任务名称")
	@TableField("job_name")
	private String jobName;

	@ApiModelProperty(value = "任务组名")
	@TableField("job_group")
	private String jobGroup;

	@ApiModelProperty(value = "调用目标字符串")
	@TableField("invoke_target")
	private String invokeTarget;

	@ApiModelProperty(value = "cron执行表达式")
	@TableField("cron_expression")
	private String cronExpression;

	@ApiModelProperty(value = "计划执行错误策略（1立即执行 2执行一次 3放弃执行）")
	@TableField("misfire_policy")
	private String misfirePolicy;

	@ApiModelProperty(value = "是否并发执行（0允许 1禁止）")
	private String concurrent;

	@ApiModelProperty(value = "状态（0正常 1暂停）")
	private String status;

	@ApiModelProperty(value = "创建者")
	@TableField("create_by")
	private String createBy;

	@ApiModelProperty(value = "创建时间")
	@TableField("create_time")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "更新者")
	@TableField("update_by")
	private String updateBy;

	@ApiModelProperty(value = "更新时间")
	@TableField("update_time")
	private LocalDateTime updateTime;

	@ApiModelProperty(value = "备注信息")
	private String remark;


}
