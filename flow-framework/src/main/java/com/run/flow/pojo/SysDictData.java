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
 * 字典数据表
 * </p>
 *
 * @author hlh
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict_data")
@ApiModel(value = "SysDictData对象", description = "字典数据表")
public class SysDictData implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典编码")
	@TableId(value = "dict_code", type = IdType.AUTO)
	private Long dictCode;

	@ApiModelProperty(value = "字典排序")
	@TableField("dict_sort")
	private Integer dictSort;

	@ApiModelProperty(value = "字典标签")
	@TableField("dict_label")
	private String dictLabel;

	@ApiModelProperty(value = "字典键值")
	@TableField("dict_value")
	private String dictValue;

	@ApiModelProperty(value = "字典类型")
	@TableField("dict_type")
	private String dictType;

	@ApiModelProperty(value = "样式属性（其他样式扩展）")
	@TableField("css_class")
	private String cssClass;

	@ApiModelProperty(value = "表格回显样式")
	@TableField("list_class")
	private String listClass;

	@ApiModelProperty(value = "是否默认（Y是 N否）")
	@TableField("is_default")
	private String isDefault;

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
