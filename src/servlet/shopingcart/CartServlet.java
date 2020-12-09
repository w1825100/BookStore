package servlet.shopingcart;

import com.google.gson.Gson;
import domain.Book;
import domain.CartItem;
import domain.ShopingCart;
import service.BookService;
import service.impl.BookServiceImpl;
import servlet.BaseServlet;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cartServlet")
public class CartServlet  extends BaseServlet {
    BookService bookService=new BookServiceImpl();
    public void  addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       int id= WebUtils.parseInt(request.getParameter("id"),0);
       Book book=bookService.queryBookById(id);
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        HttpSession session = request.getSession();
        if(session.getAttribute("shopingCart")==null){
            ShopingCart shopingCart=new ShopingCart();
            request.getSession().setAttribute("shopingCart",shopingCart);
        }
      ShopingCart shopingCart = (ShopingCart) session.getAttribute("shopingCart");
        shopingCart.addItem(cartItem);
        session.setAttribute("lastItem",cartItem.getName());
        String referer=request.getHeader("referer");
        response.sendRedirect(referer);
    }
    public void deleteItem(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        HttpSession session = request.getSession();
        ShopingCart shopingCart = (ShopingCart) session.getAttribute("shopingCart");
        shopingCart.deleteItem(id);
        String referer =request.getHeader("referer");
        response.sendRedirect(referer);
    } public void clear(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShopingCart shopingCart = (ShopingCart) session.getAttribute("shopingCart");
        if(shopingCart!=null){
            session.removeAttribute("shopingCart");
        }
        session.removeAttribute("lastItem");
        response.sendRedirect(request.getHeader("referer"));

    }
    public void updateCount(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int id =WebUtils.parseInt(request.getParameter("id"),0);
        int count=WebUtils.parseInt(request.getParameter("count"),0);
       ShopingCart shopingCart = (ShopingCart) request.getSession().getAttribute("shopingCart");
           if(!shopingCart.updateCount(id,count)){
               Book book = bookService.queryBookById(id);
               request.getSession().setAttribute("bookName",book.getName());
               request.getSession().setAttribute("bookStock",book.getStock());
           }
        response.sendRedirect(request.getHeader("referer"));

    }
    public void  ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= WebUtils.parseInt(request.getParameter("id"),0);
        Book book=bookService.queryBookById(id);
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        HttpSession session = request.getSession();
        if(session.getAttribute("shopingCart")==null){
            ShopingCart shopingCart=new ShopingCart();
            request.getSession().setAttribute("shopingCart",shopingCart);
        }
        ShopingCart shopingCart = (ShopingCart) session.getAttribute("shopingCart");
        shopingCart.addItem(cartItem);
        session.setAttribute("lastItem",cartItem.getName());
//        String referer=request.getHeader("referer");
//        response.sendRedirect(referer);
        Map<String,Object> map=new HashMap();
        map.put("lastItem",cartItem.getName());
        Gson gson=new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);


    }


}
