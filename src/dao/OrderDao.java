package dao;

import domain.Order;
import domain.OrderItem;
import domain.User;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);

   List<Order> findOrderByUserID(Integer id);

    Order findOrderByOrderId(String orderId);
   int  changeOrderStatus(String orderId,int status);

    int deleteOrder(String orderId);
    int deleteOrderForclient(String orderId);

    List<Order> findAllOrders();
}
