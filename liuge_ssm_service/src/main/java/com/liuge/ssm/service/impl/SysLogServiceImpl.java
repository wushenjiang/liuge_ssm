package com.liuge.ssm.service.impl;

import com.liuge.ssm.dao.ISysLogDao;
import com.liuge.ssm.domain.SysLog;
import com.liuge.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SysLogService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/22  20:52
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
