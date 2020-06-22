package com.liuge.ssm.dao;

import com.liuge.ssm.domain.Permission;
import com.liuge.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: IRoleDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/21  14:57
 */
public interface IRoleDao {
    /**
     *
     * 根据用户id查询对应角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.liuge.ssm.dao.IPermissionDao.findPermissionByRoleId")),
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有
     * @return
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId);
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId);
    @Insert("insert into role_permission (roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
