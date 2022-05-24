package com.run.flow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.run.flow.pojo.SysOperLog;

import java.util.List;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
	/**
	 * 新增操作日志
	 *
	 * @param operLog 操作日志对象
	 */
	public void insertOperlog(SysOperLog operLog);

	/**
	 * 查询系统操作日志集合
	 *
	 * @param operLog 操作日志对象
	 * @return 操作日志集合
	 */
	public List<SysOperLog> selectOperLogList(SysOperLog operLog);

	/**
	 * 批量删除系统操作日志
	 *
	 * @param operIds 需要删除的操作日志ID
	 * @return 结果
	 */
	public int deleteOperLogByIds(Long[] operIds);

	/**
	 * 查询操作日志详细
	 *
	 * @param operId 操作ID
	 * @return 操作日志对象
	 */
	public SysOperLog selectOperLogById(Long operId);

	/**
	 * 清空操作日志
	 */
	public void cleanOperLog();
}
