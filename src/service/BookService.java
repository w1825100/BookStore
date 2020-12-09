package service;

import domain.Book;
import domain.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBook(Integer id);
    void updateBook(Book book);
    Book queryBookById(Integer id);
    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
