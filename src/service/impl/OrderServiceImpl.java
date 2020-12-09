package service.impl;

import dao.BookDao;
import dao.OrderDao;
import dao.OrderItem;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import domain.Book;
import domain.CartItem;
import domain.Order;
import domain.ShopingCart;
import service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {
    OrderDao od=new OrderDaoImpl();
    OrderItem odi=new OrderItemDaoImpl();
    BookDao bookDao=new BookDaoImpl();

    @Override
    public String createOrder(ShopingCart sp, Integer userId) {
        String orderId=System.currentTimeMillis()+""+userId;

        Order order =new  Order(orderId,new Date(),sp.getTotalPrice(),0,userId);
        od.saveOrder(order);
        Set<Map.Entry<Integer, CartItem>> entries = sp.getItems().entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            CartItem cartItem = entry.getValue();
            domain.OrderItem orderItem=new domain.OrderItem();
            orderItem.setName(cartItem.getName());
            orderItem.setCount(cartItem.getCount());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setTotalPrice(cartItem.getTotalPrice());
            orderItem.setOrderId(orderId);
            odi.saveOrderItem(orderItem);
//            更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        sp.clear();
        return  orderId;
    }

    @Override
    public List<Order> findOrderByUserID(Integer id) {
        return  od.findOrderByUserID(id);
    }

    @Override
    public Order findOrderByOrderID(String orderId) {

        return od.findOrderByOrderId(orderId);
    }

    @Override
    public List<domain.OrderItem> findOrderItemByOrderID(String orderId) {
        return odi.findOrderItemByOrderID(orderId);
    }

    @Override
    public void changeOrderStatus(String orderId, int status) {
        od.changeOrderStatus(orderId,status);
    }

    @Override
    public void deleteOrder(String orderId) {

        od.deleteOrder(orderId);
    }

    @Override
    public void deleteOrderForClient(String orderId) {
        od.deleteOrderForclient(orderId);
    }

    @Override
    public List<Order> findAllOrders() {

        return od.findAllOrders();
    }

}
