package servlet.book;

import domain.Book;
import domain.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import servlet.BaseServlet;
import utils.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/bookServlet")
public class ClientBookServlet  extends BaseServlet {
    private BookService bookService =new BookServiceImpl();
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        if(servletContext.getAttribute("num")==null){
            servletContext.setAttribute("num",0);
        }else {
            servletContext.setAttribute("num",(Integer)servletContext.getAttribute("num")+1);
        }
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 4);
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
    public void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1)  ;
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"),4);
        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);
       Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
       StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
       if(request.getParameter("min")!=null){
           sb.append("&min=").append(request.getParameter("min"));
       }if(request.getParameter("max")!=null){
           sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
       request.setAttribute("page",page);
       request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
