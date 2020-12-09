package service;

import domain.Order;
import domain.OrderItem;
import domain.ShopingCart;

import java.util.List;

public interface OrderService {
    String createOrder(ShopingCart sp,Integer userId);
   List<Order> findOrderByUserID(Integer id);
    Order findOrderByOrderID(String orderId);
    List<OrderItem> findOrderItemByOrderID(String orderId);
    void changeOrderStatus(String orderId, int status);
    void deleteOrder(String orderId);
    void deleteOrderForClient(String orderId);
    List<Order> findAllOrders();
}
