package cn.edu.goodsprovider.service;

import cn.edu.goodscommons.domain.Book;

import java.util.List;

public interface GoodsProviderService {
    List<Book> getBookList();

    Book getBookById(Integer id);

    void addBook(Book book);

    void deleteById(Integer id);

    void update(Book book);
}
