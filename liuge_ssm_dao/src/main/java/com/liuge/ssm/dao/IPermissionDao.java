package com.liuge.ssm.dao;

import com.liuge.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: IPermissionDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/21  21:15
 */
public interface IPermissionDao {
    /**
     * 根据id查询角色权限
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 查询所有资源
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll();

    /**
     * 新增
     * @param permission
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
