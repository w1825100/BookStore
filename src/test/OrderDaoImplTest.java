package test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void deleteOrder() {
        OrderDao od=new OrderDaoImpl();
        od.deleteOrder("16033628887871");
    }

    @Test
    public void testDeleteOrder() {
        OrderDao od=new OrderDaoImpl();
        od.deleteOrder("16033692993381");
    }

    @Test
    public void findAllOrders() {
        OrderDao od=new OrderDaoImpl();
        System.out.println(od.findAllOrders());
    }
    @Test
    public void fis() {
        OrderDao od=new OrderDaoImpl();
        System.out.println(od.findOrderByOrderId("16033754490571"));
    }
}