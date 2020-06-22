package com.liuge.ssm.dao;

import com.liuge.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: ISysLogDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/22  20:53
 */
public interface ISysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;
    @Select("select * from syslog")
    List<SysLog> findAll();
}
