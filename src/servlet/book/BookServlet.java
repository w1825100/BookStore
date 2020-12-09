package servlet.book;

import domain.Book;
import domain.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import servlet.BaseServlet;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/bookServlet")
public class BookServlet extends BaseServlet {
    private BookService bookService =new BookServiceImpl();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Book book= new Book();
            WebUtils.parseBean(book,request);
            bookService.addBook(book);
        String pageNo = request.getParameter("pageNo");
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=WebUtils.parseInt( request.getParameter("id"),0);
        bookService.deleteBook(id);
        String pageNo = request.getParameter("pageNo");
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }
    public  void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book =new Book();
       WebUtils.parseBean(book,request);
       bookService.updateBook(book);
        String pageNo = request.getParameter("pageNo");
       response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        request.setAttribute("books",books);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
    public void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=WebUtils.parseInt( request.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);

    }
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 4);

       Page<Book> page=bookService.page(pageNo,pageSize);
       page.setUrl("manager/bookServlet?action=page");
       request.setAttribute("page",page);
       request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }

}
