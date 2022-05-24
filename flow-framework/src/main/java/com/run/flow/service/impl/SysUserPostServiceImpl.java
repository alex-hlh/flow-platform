package com.run.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.run.flow.mapper.SysUserPostMapper;
import com.run.flow.pojo.SysUserPost;
import com.run.flow.service.ISysUserPostService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author stx
 * @since 2022-05-21
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements ISysUserPostService {

}
