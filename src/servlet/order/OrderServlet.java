package servlet.order;

import domain.Order;
import domain.OrderItem;
import service.OrderService;
import service.impl.OrderServiceImpl;
import servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/orderServlet")
public class OrderServlet extends BaseServlet {
            OrderService orderService =new OrderServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
          List<Order> orderList =orderService.findAllOrders();
             request.setAttribute("orderList",orderList);
            request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    public void findOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItemList = orderService.findOrderItemByOrderID(orderId);
        request.setAttribute("orderItemList",orderItemList);
        request.getRequestDispatcher("/pages/order/orderdetails.jsp").forward(request,response);
    }
    public void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String orderId = request.getParameter("orderId");
        orderService.changeOrderStatus(orderId,1);
        response.sendRedirect(request.getHeader("referer"));

    }
    public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

            String orderId = request.getParameter("orderId");


            if(orderService.findOrderByOrderID(orderId).getStatus()!=2){
                request.getSession().setAttribute("Msg",1);
                response.sendRedirect(request.getHeader("referer"));
            }else{
                request.getSession().removeAttribute("Msg");
                orderService.deleteOrder(orderId);
                response.sendRedirect(request.getHeader("referer"));
            }


    }

}
