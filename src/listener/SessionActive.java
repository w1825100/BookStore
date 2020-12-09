package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;


public class SessionActive implements HttpSessionActivationListener {
//    javabean 活化与钝化操作
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("将要钝化...");
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("将要活化...");
    }

}
