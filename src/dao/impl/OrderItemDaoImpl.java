package dao.impl;

import dao.BaseDao;
import dao.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItem {



    @Override
    public int saveOrderItem(domain.OrderItem orderItem) {
        String sql="insert into t_order_item(`name`,count,price,total_price,`order_id`) values(?,?,?,?,?)";
        return  update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<domain.OrderItem> findOrderItemByOrderID(String orderId) {
        String sql="SELECT order_id orderId,`name`,`count`,price,`total_price` totalPrice FROM t_order_item WHERE order_id =?";
        return queryForList(domain.OrderItem.class,sql,orderId);
    }

    public List<domain.OrderItem> findOrderByOrderId(String orderId) {
        String sql="SELECT order_id orderId,`name`,`count`,price,`total_price` totalPrice FROM t_order_item WHERE order_id =?";
        return queryForList(domain.OrderItem.class,sql,orderId);
    }
    @Override
    public  int  deleteItemByOrderId(String orderId){
        String sql ="update t_order_item set order_id =null where order_id =?";
         update(sql,orderId);
        String sql1 ="delete from t_order_item where order_id is null";
        return update(sql1);
    }
}
