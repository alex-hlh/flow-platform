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
 * 岗位信息表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_post")
@ApiModel(value = "SysPost对象", description = "岗位信息表")
public class SysPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位ID")
	@TableId(value = "post_id", type = IdType.AUTO)
	private Long postId;

	@ApiModelProperty(value = "岗位编码")
	@TableField("post_code")
	private String postCode;

	@ApiModelProperty(value = "岗位名称")
	@TableField("post_name")
	private String postName;

	@ApiModelProperty(value = "显示顺序")
	@TableField("post_sort")
	private Integer postSort;

	@ApiModelProperty(value = "状态（0正常 1停用）")
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

	@ApiModelProperty(value = "备注")
	private String remark;


}
