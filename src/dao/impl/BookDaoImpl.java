package dao.impl;

import dao.BaseDao;
import dao.BookDao;
import domain.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book values(null,?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteById(Integer id) {
        String sql="delete from t_book where id=?";

        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update  t_book set  name=?,author=?,price=?,sales=?,stock=?,img_path=? where id =?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select * from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select * from t_book ";
        return queryForList(Book.class,sql);
    }

    @Override
    public int queryForTotalCount() {
        String sql="select count(*) from t_book";
          Number num=(Number)queryForSingleValue(sql);
        return  num.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin,int pageSize) {
        String sql="select * from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select * from t_book where price between ? and ? order by price  limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }

    @Override
    public int queryForTotalCountByPrice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number  number= (Number) queryForSingleValue(sql,min,max);
        return number.intValue();
    }
}
