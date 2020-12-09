package servlet.order;

import domain.Order;
import domain.OrderItem;
import domain.ShopingCart;
import domain.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/client/orderServlet")
public class ClientOrderServlet extends BaseServlet {
    OrderService orderService=new OrderServiceImpl();
    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             ShopingCart shopingCart = (ShopingCart)request.getSession().getAttribute("shopingCart");
             User user = (User)request.getSession().getAttribute("user");
             if(user==null){
                 request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
                 return ;
             }else{
                 if(shopingCart!=null){
                     String orderId= orderService.createOrder(shopingCart,user.getId());
                     request.getSession().setAttribute("orderId",orderId);
                 }
//            request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
                 response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
             }


        }
    public void showMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
       User user = (User)session.getAttribute("user");
       if(user==null){
           request.setAttribute("Msg","您尚未登录,请先登录!");
           request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
       }
        List<Order> orderList = orderService.findOrderByUserID(user.getId());
            request.setAttribute("orderList",orderList);
            request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);

    }
    public void showOrderByOrderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<OrderItem> orderItemList=orderService.findOrderItemByOrderID(request.getParameter("orderId"));
        request.setAttribute("orderItemList",orderItemList);
        System.out.println(orderItemList);
        request.getRequestDispatcher("/pages/order/orderdetails.jsp").forward(request,response);
    }
    public void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            orderService.changeOrderStatus(request.getParameter("orderId"),2);
                response.sendRedirect(request.getContextPath()+"/client/orderServlet?action=showMyOrder");

    }
    public  void  deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String orderId = request.getParameter("orderId");
        orderService.deleteOrderForClient(orderId);
        response.sendRedirect(request.getContextPath()+"/client/orderServlet?action=showMyOrder");
    }











}
