package com.liuge.ssm.dao;

import com.liuge.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: ITravllerDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/20  21:39
 */
public interface ITravellerDao {
    /**
     * 根据id查询旅客信息
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
