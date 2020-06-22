package com.liuge.ssm.service;

import com.liuge.ssm.domain.Permission;
import com.liuge.ssm.domain.Role;

import java.util.List;

/**
 * @ClassName: IRoleService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/21  22:08
 */
public interface IRoleService {
    /**
     * 找到全部的角色信息
     * @return
     */
    List<Role> findAll() throws Exception;

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);

}
