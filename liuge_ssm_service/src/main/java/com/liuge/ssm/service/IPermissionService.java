package com.liuge.ssm.service;

import com.liuge.ssm.domain.Permission;

import java.util.List;

/**
 * @ClassName: IPermissionService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/21  22:24
 */
public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission) throws Exception;
}
