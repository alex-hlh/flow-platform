package com.run.flow.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色和部门关联表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_dept")
@ApiModel(value = "SysRoleDept对象", description = "角色和部门关联表")
public class SysRoleDept implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID")
	@TableId("role_id")
	private Long roleId;

	@ApiModelProperty(value = "部门ID")
	@TableField("dept_id")
	private Long deptId;


}
