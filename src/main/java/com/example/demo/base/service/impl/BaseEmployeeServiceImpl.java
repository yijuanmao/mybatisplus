package com.example.demo.base.service.impl;

import com.example.demo.base.entity.BaseEmployee;
import com.example.demo.base.mapper.BaseEmployeeMapper;
import com.example.demo.base.service.IBaseEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zengyi
 * @since 2019-08-29
 */
@Service
public class BaseEmployeeServiceImpl extends ServiceImpl<BaseEmployeeMapper, BaseEmployee> implements IBaseEmployeeService {

}
