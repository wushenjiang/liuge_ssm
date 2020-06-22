package com.liuge.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.liuge.ssm.dao.IOrdersDao;
import com.liuge.ssm.domain.Orders;
import com.liuge.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: OrdersServiceImpl
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  20:36
 */
@Service
@Transactional(rollbackFor = {})
public class OrdersServiceImpl  implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        // 参数PageNum是页码值,pageSize代表每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
