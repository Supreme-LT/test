package cn.edu.goodsprovider.dao;

import cn.edu.goodscommons.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    List<Book> getBookList();

    Book getBookById(Integer id);

    void addBook(Book book);

    void deleteById(Integer id);

    void update(Book book);
}
