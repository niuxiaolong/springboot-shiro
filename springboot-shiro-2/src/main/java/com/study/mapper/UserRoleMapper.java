package com.study.mapper;

import com.study.model.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}