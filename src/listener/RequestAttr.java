package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;


public class RequestAttr implements ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request添加新数据啦!键是:"+srae.getName()+"值是:"+srae.getValue());
    }

    public  void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("request移除数据啦!键是:"+srae.getName()+"值是:"+srae.getValue());
    }
        public  void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("request替换数据啦!键是:"+srae.getName()+"值是:"+srae.getValue());
    }
}
