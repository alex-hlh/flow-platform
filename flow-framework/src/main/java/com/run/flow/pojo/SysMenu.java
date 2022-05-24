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
import java.util.List;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单权限表")
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "菜单ID")
	@TableId(value = "menu_id", type = IdType.AUTO)
	private Long menuId;

	@ApiModelProperty(value = "菜单名称")
	@TableField("menu_name")
	private String menuName;

	@ApiModelProperty(value = "父菜单ID")
	@TableField("parent_id")
	private Long parentId;

	@ApiModelProperty(value = "显示顺序")
	@TableField("order_num")
	private Integer orderNum;

	@ApiModelProperty(value = "路由地址")
	private String path;

	@ApiModelProperty(value = "组件路径")
	private String component;

	@ApiModelProperty(value = "路由参数")
	private String query;

	@ApiModelProperty(value = "是否为外链（0是 1否）")
	@TableField("is_frame")
	private String isFrame;

	@ApiModelProperty(value = "是否缓存（0缓存 1不缓存）")
	@TableField("is_cache")
	private String isCache;

	@ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
	@TableField("menu_type")
	private String menuType;

	@ApiModelProperty(value = "菜单状态（0显示 1隐藏）")
	private String visible;

	@ApiModelProperty(value = "菜单状态（0正常 1停用）")
	private String status;

	@ApiModelProperty(value = "权限标识")
	private String perms;

	@ApiModelProperty(value = "菜单图标")
	private String icon;

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

	@ApiModelProperty(value = "子菜单")
	@TableField(exist = false)
	private List<SysMenu> children;

}
