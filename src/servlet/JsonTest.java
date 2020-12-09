package servlet;

import com.google.gson.Gson;

import org.junit.Test;

public class JsonTest extends  BaseServlet{
    @Test
    public void  show(){
        Gson gson =new Gson();
        String s="{name:zhansgan;age:18}";

    }
}
