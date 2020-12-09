package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {
   public void sessionCreated(HttpSessionEvent se) {
       System.out.println(se.getSession());
       System.out.println("session域被创建啦...");
   }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession());
        System.out.println("session域被销毁啦...");
    }
}
