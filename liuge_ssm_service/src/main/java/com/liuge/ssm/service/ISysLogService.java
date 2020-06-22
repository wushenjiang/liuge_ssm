package com.liuge.ssm.service;

import com.liuge.ssm.domain.SysLog;

import java.util.List;

/**
 * @ClassName: ISysLogServcie
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/22  20:52
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll();
}
