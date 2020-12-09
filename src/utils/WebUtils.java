package utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static void parseBean(Object bean, HttpServletRequest req) {
        try {
            BeanUtils.populate(bean, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static int parseInt(String str, int defaultVaule) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {

        }
        return defaultVaule;
    }

}
