package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


public class ContextAttr implements ServletContextAttributeListener {
   public void attributeAdded(ServletContextAttributeEvent se) {
       System.out.println("context域中添加数据啦!键是:"+se.getName()+"值是:"+se.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent se) {
        System.out.println("context域中移除数据啦!键是:"+se.getName()+"值是:"+se.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent se) {
        System.out.println("context域中替换数据啦!键是:"+se.getName()+"值是:"+se.getValue());
    }
}
