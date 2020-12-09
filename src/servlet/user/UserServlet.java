package servlet.user;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;
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

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet { UserService userService =new UserServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = new User();
        WebUtils.parseBean(user,request);
        User loginUser = userService.login(user);
        if (loginUser==null){
            request.setAttribute("Msg","用户名或密码错误!");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else{
            System.out.println(user.getUsername()+"登录了");
            HttpSession session = request.getSession();
            session.setAttribute("user",loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }

    }
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        String token=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        String code = request.getParameter("code");
        if (token.equalsIgnoreCase(code)){
            if(!userService.existUsername(username)){
                request.setAttribute("Msg","用户名已被注册!");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                request.setAttribute("code",code);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }else{
                User user =new User();
                WebUtils.parseBean(user,request);
                userService.registUser(user);
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("Msg","验证码不正确!");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.setAttribute("code",code);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect(request.getContextPath());
    }
    public void ajaxExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         String username = request.getParameter("username");
         boolean exits= userService.existUsername(username);
            Map<String,Object> map=new HashMap();
            map.put("exits",exits);
        Gson gson=new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);

    }
}
