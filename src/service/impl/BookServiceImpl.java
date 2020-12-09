package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import domain.Page;
import service.BookService;

import java.util.List;


public class BookServiceImpl implements BookService {
    BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {

        return  bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page page =new Page();
    int totalCount= bookDao.queryForTotalCount();
    int pageTotal=totalCount/pageSize;
        if(totalCount%pageSize>0){
        pageTotal+=1;
    }
        if(pageNo<1){
        pageNo=1;
    }
        if (pageNo>pageTotal){
        pageNo=pageTotal;
    }

        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setPageTotal(pageTotal);
    List<Book> items=bookDao.queryForPageItems((pageNo-1)*pageSize,pageSize);
        page.setItems(items);
        return page;
}

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page page =new Page();
        int totalCount= bookDao.queryForTotalCountByPrice(min,max);
        int pageTotal=totalCount/pageSize;
        if(totalCount%pageSize>0){
            pageTotal+=1;
        }
        if(pageNo<1){
            pageNo=1;
        }
        if (pageNo>pageTotal){
            pageNo=pageTotal;
        }

        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setPageTotal(pageTotal);
        List<Book> items=bookDao.queryForPageItemsByPrice((pageNo-1)*pageSize,pageSize,min,max);
        page.setItems(items);
        return page;



    }
}
