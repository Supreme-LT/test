package cn.edu.goodsprovider.service.impl;

import cn.edu.goodscommons.domain.Book;
import cn.edu.goodsprovider.dao.GoodsDao;
import cn.edu.goodsprovider.service.GoodsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<Book> getBookList() {
        return goodsDao.getBookList();
    }

    @Override
    public Book getBookById(Integer id) {
        return goodsDao.getBookById(id);
    }

    @Override
    public void addBook(Book book) {
        goodsDao.addBook(book);
    }

    @Override
    public void deleteById(Integer id) {
        goodsDao.deleteById(id);
    }

    @Override
    public void update(Book book) {
        goodsDao.update(book);
    }
}
