package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ErrorFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try{
            chain.doFilter(req, resp);
        }catch(Exception e){
            throw new RuntimeException();
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
