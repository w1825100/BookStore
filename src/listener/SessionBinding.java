package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class SessionBinding implements HttpSessionBindingListener {
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("我binding被添加到session中啦....");
    }
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("我binding被从session中删除啦....");
    }
}
