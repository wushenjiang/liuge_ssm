package com.liuge.ssm.service.impl;

import com.liuge.ssm.dao.IProductDao;
import com.liuge.ssm.domain.Product;
import com.liuge.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ProductServiceImpl
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  19:01
 */
@Service
@Transactional(rollbackFor = {})
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
