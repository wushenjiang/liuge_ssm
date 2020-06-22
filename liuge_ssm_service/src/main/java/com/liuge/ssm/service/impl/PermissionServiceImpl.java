package com.liuge.ssm.service.impl;

import com.liuge.ssm.dao.IPermissionDao;
import com.liuge.ssm.domain.Permission;
import com.liuge.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PermissionServiceImpl
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/21  22:25
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
