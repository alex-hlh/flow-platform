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
 * 通知公告表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_notice")
@ApiModel(value = "SysNotice对象", description = "通知公告表")
public class SysNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "公告ID")
	@TableId(value = "notice_id", type = IdType.AUTO)
	private Integer noticeId;

	@ApiModelProperty(value = "公告标题")
	@TableField("notice_title")
	private String noticeTitle;

	@ApiModelProperty(value = "公告类型（1通知 2公告）")
	@TableField("notice_type")
	private String noticeType;

	@ApiModelProperty(value = "公告内容")
	@TableField("notice_content")
	private String noticeContent;

	@ApiModelProperty(value = "公告状态（0正常 1关闭）")
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
