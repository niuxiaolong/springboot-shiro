package com.study.mapper;

import com.study.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}