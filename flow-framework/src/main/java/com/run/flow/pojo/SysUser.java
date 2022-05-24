package com.run.flow.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "用户信息表")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID")
	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;

	@ApiModelProperty(value = "部门ID")
	@TableField("dept_id")
	private Long deptId;

	@ApiModelProperty(value = "用户账号")
	@TableField("user_name")
	private String userName;

	@ApiModelProperty(value = "用户昵称")
	@TableField("nick_name")
	private String nickName;

	@ApiModelProperty(value = "用户类型（00系统用户）")
	@TableField("user_type")
	private String userType;

	@ApiModelProperty(value = "用户邮箱")
	private String email;

	@ApiModelProperty(value = "手机号码")
	private String phonenumber;

	@ApiModelProperty(value = "用户性别（0男 1女 2未知）")
	private String sex;

	@ApiModelProperty(value = "头像地址")
	private String avatar;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "帐号状态（0正常 1停用）")
	private String status;

	@ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
	@TableField("del_flag")
	private String delFlag;

	@ApiModelProperty(value = "最后登录IP")
	@TableField("login_ip")
	private String loginIp;

	@ApiModelProperty(value = "最后登录时间")
	@TableField("login_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime loginDate;

	@ApiModelProperty(value = "创建者")
	@TableField("create_by")
	private String createBy;

	@ApiModelProperty(value = "创建时间")
	@TableField("create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "更新者")
	@TableField("update_by")
	private String updateBy;

	@ApiModelProperty(value = "更新时间")
	@TableField("update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateTime;

	@ApiModelProperty(value = "备注")
	private String remark;

}
