package domain;

import dao.BookDao;
import dao.impl.BookDaoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShopingCart {
    private int totalCount;
    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    BookDao bookDao=new BookDaoImpl();

    public int getTotalCount() {
        totalCount=0;
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
                totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public  BigDecimal getTotalPrice() {
        totalPrice=new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
           CartItem item=entry.getValue();
            totalPrice=totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public ShopingCart() {
    }

    @Override
    public String toString() {
        return "ShopingCart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice()+
                ", items=" + items +
                '}';
    }

    public void addItem(CartItem cartItem) {
      CartItem  item=items.get(cartItem.getId());
       if( item==null){
           items.put(cartItem.getId(),cartItem);
       }else {
          item.setCount((item.getCount()+1));

//          边界检查
          if(item.getCount()>=bookDao.queryBookById(cartItem.getId()).getStock()){
               item.setCount(bookDao.queryBookById(cartItem.getId()).getStock());
           }
          item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
       }
    }

    public void deleteItem(Integer id) {
            items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public boolean updateCount(Integer id,Integer count) {
        CartItem cartItem =items.get(id);
        if(count<0){
            count=0;
        }
            cartItem.setCount(count);
            if(count>bookDao.queryBookById(cartItem.getId()).getStock()){
                cartItem.setCount(bookDao.queryBookById(cartItem.getId()).getStock());
                cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
                return false;
            }
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            return true;
    }
}
