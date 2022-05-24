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
 * 部门表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dept")
@ApiModel(value = "SysDept对象", description = "部门表")
public class SysDept implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "部门id")
	@TableId(value = "dept_id", type = IdType.AUTO)
	private Long deptId;

	@ApiModelProperty(value = "父部门id")
	@TableField("parent_id")
	private Long parentId;

	@ApiModelProperty(value = "祖级列表")
	private String ancestors;

	@ApiModelProperty(value = "部门名称")
	@TableField("dept_name")
	private String deptName;

	@ApiModelProperty(value = "显示顺序")
	@TableField("order_num")
	private Integer orderNum;

	@ApiModelProperty(value = "负责人")
	private String leader;

	@ApiModelProperty(value = "联系电话")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "部门状态（0正常 1停用）")
	private String status;

	@ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
	@TableField("del_flag")
	private String delFlag;

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


}
