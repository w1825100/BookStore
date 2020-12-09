package servlet.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public  class ForwardServlet{
public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {







    response.sendRedirect(request.getContextPath()+"/pages/client/index.jsp");

}
}