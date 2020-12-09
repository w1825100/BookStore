package dao.impl;

import dao.BaseDao;
import dao.OrderDao;
import dao.OrderItem;
import domain.Order;


import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreatTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> findOrderByUserID(Integer id) {

        String sql="select `order_id` orderId,`create_time` creatTime,`price` ,`status`,`user_id` from t_order where user_id=?";
        return queryForList(Order.class,sql,id);
    }

    @Override
    public Order findOrderByOrderId(String orderId) {
        String sql="SELECT   order_id orderId ,`create_time` creatTime,`price`,`status` ,user_id userId FROM t_order WHERE order_id =?";
        return queryForOne(Order.class,sql,orderId);
    }

    @Override
    public int changeOrderStatus(String orderId, int status) {
        String sql="update t_order set status =?  WHERE order_id =?";

        return update(sql,status,orderId);
    }


    @Override
    public int deleteOrder(String orderId) {
        String usql="update t_order set user_id =null  WHERE order_id =?";
        update(usql,orderId);
        OrderItem orderItem =new OrderItemDaoImpl();
        orderItem.deleteItemByOrderId(orderId);
        String sql="delete from t_order where user_id is null";
        return update(sql);
    }
    @Override
    public int deleteOrderForclient(String orderId){
        String usql="update t_order set user_id =null  WHERE order_id =?";
      return  update(usql,orderId);
    }

    @Override
    public List<Order> findAllOrders() {
        String sql="select order_id orderId,create_time creatTime,price,status,user_id userId from t_order ";
        return queryForList(Order.class,sql);
    }

}
