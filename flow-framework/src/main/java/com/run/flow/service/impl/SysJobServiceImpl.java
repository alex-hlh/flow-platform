package com.run.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.mapper.SysJobMapper;
import com.run.flow.pojo.SysJob;
import com.run.flow.service.ISysJobService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

}
