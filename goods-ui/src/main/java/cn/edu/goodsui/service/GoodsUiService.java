package cn.edu.goodsui.service;

import cn.edu.goodscommons.domain.Book;
import cn.edu.goodscommons.vo.ResultVo;

import java.util.List;

public interface GoodsUiService {
    void testGoodsProvider();

    List<Book> getBookList();

    ResultVo getBookDetail(Integer id);

    String addBook(Book book);

    String update(Book book);

    String deleteById(Integer id);
}
