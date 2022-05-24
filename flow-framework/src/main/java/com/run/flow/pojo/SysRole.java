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
 * 角色信息表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "角色信息表")
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID")
	@TableId(value = "role_id", type = IdType.AUTO)
	private Long roleId;

	@ApiModelProperty(value = "角色名称")
	@TableField("role_name")
	private String roleName;

	@ApiModelProperty(value = "角色权限字符串")
	@TableField("role_key")
	private String roleKey;

	@ApiModelProperty(value = "显示顺序")
	@TableField("role_sort")
	private Integer roleSort;

	@ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
	@TableField("data_scope")
	private String dataScope;

	@ApiModelProperty(value = "菜单树选择项是否关联显示")
	@TableField("menu_check_strictly")
	private Boolean menuCheckStrictly;

	@ApiModelProperty(value = "部门树选择项是否关联显示")
	@TableField("dept_check_strictly")
	private Boolean deptCheckStrictly;

	@ApiModelProperty(value = "角色状态（0正常 1停用）")
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

	@ApiModelProperty(value = "备注")
	private String remark;


}
