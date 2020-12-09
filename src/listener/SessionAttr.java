package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class SessionAttr implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session添加新数据啦!键是:"+se.getName()+"值是:"+se.getValue());
    }

    public  void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session中移除数据啦!键是:"+se.getName()+"值是:"+se.getValue());
    }

    public  void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session替换数据啦!键是:"+se.getName()+"值是:"+se.getValue());
    }
}
