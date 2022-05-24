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
 * 参数配置表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_config")
@ApiModel(value = "SysConfig对象", description = "参数配置表")
public class SysConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数主键")
	@TableId(value = "config_id", type = IdType.AUTO)
	private Long configId;

	@ApiModelProperty(value = "参数名称")
	@TableField("config_name")
	private String configName;

	@ApiModelProperty(value = "参数键名")
	@TableField("config_key")
	private String configKey;

	@ApiModelProperty(value = "参数键值")
	@TableField("config_value")
	private String configValue;

	@ApiModelProperty(value = "系统内置（Y是 N否）")
	@TableField("config_type")
	private String configType;

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

	@ApiModelProperty(value = "备注")
	private String remark;


}
