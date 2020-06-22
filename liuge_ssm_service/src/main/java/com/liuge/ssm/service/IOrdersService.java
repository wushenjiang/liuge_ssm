package com.liuge.ssm.service;

import com.liuge.ssm.domain.Orders;

import java.util.List;

/**
 * @ClassName: IOrdersService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  20:35
 */
public interface IOrdersService {
    /**
     * 分页查询所有订单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page,int size) throws Exception;

    /**
     * 根据id查找订单详情
     * @param ordersId
     * @return
     * @throws Exception
     */
    Orders findById(String ordersId) throws Exception;
}
