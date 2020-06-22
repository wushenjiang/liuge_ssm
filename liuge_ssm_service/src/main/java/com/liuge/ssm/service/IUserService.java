package com.liuge.ssm.service;

import com.liuge.ssm.domain.Role;
import com.liuge.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @ClassName: IUserService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/21  14:09
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存用户
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 查询其他角色信息
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds);
}
