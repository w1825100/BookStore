package dao;

import java.util.List;

public interface OrderItem {
    int saveOrderItem(domain.OrderItem orderItem);

    List<domain.OrderItem> findOrderItemByOrderID(String orderId);
    int  deleteItemByOrderId(String orderId);

}
