package com.liuge.ssm.service;

import com.liuge.ssm.domain.Product;

import java.util.List;

/**
 * @ClassName: IProdcutService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  19:00
 */
public interface IProductService {
    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

    /**
     * 保存商品信息
     * @param product
     * @throws Exception
     */
    void save(Product product) throws  Exception;
}
