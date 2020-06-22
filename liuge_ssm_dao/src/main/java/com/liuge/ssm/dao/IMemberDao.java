package com.liuge.ssm.dao;

import com.liuge.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: IMemberDao
 * @Description: memebr接口
 * @author: LiuGe
 * @date: 2020/6/20  21:37
 */
public interface IMemberDao {
    /**
     * 通过id查询member数据
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

}
