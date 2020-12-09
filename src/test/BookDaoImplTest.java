package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoImplTest {
BookDao bd=new BookDaoImpl();
    @Test
    public void addBook() {
        Book book = new Book(null, "战三", "我擦", new BigDecimal(666), 1000, 0, null);
        bd.addBook(book);
    }

    @Test
    public void deleteById() {
        bd.deleteById(242);
    }

    @Test
    public void updateBook() {
        Book book = new Book(241, "战思", "我2擦", new BigDecimal(666), 1000, 0, null);
        bd.updateBook(book);
    }


    @Test
    public void queryBookById() {
        System.out.println(bd.queryBookById(241));
    }

    @Test
    public void queryBooks() {
        System.out.println(bd.queryBooks());
    }

    @Test
    public void queryForTotalCount() {
        System.out.println(bd.queryForTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bd.queryForPageItems(4,4));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bd.queryForPageItemsByPrice(0,5,10,200));
    }

    @Test
    public void queryForTotalCountByPrice() {
        System.out.println(bd.queryForTotalCountByPrice(10,200));
    }
}