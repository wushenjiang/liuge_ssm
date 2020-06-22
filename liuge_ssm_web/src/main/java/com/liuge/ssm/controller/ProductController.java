package com.liuge.ssm.controller;

import com.liuge.ssm.domain.Product;
import com.liuge.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @ClassName: ProductController
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  19:12
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> ps = productService.findAll();
        modelAndView.addObject("productList",ps);
        modelAndView.setViewName("product-list1");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll";
    }
}
