package dao;

import domain.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);
    int deleteById(Integer id);
    int updateBook(Book book);
    Book  queryBookById(Integer id);
    List<Book> queryBooks();

    int queryForTotalCount();

    List<Book> queryForPageItems(int begin,int pageSize);

    List<Book> queryForPageItemsByPrice(int i, int pageSize, int min, int max);

    int queryForTotalCountByPrice(int min, int max);
}
