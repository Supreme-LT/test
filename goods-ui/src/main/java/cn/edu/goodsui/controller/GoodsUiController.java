package cn.edu.goodsui.controller;

import cn.edu.goodscommons.domain.Book;
import cn.edu.goodscommons.vo.ResultVo;
import cn.edu.goodsui.service.GoodsUiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUiController {

    @Resource
    private GoodsUiService goodsUiService;

    /**
     * 测试goodsui调用goodsprovider
     */
    @RequestMapping("/test")
    public String test(){
        goodsUiService.testGoodsProvider();
        return "success";
    }

    /**
     * 查询所有图书
     */
    @RequestMapping("/list")
    public List<Book> list() {
        List<Book> bookList = goodsUiService.getBookList();
        return bookList;
    }

    /**
     * 根据id查询图书
     */
    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id") Integer id) {
        ResultVo book = goodsUiService.getBookDetail(id);
        return book;
    }

    /**
     * 添加图书
     */
    @PostMapping("/add")
    public String add(@RequestBody Book book) {
        goodsUiService.addBook(book);
        return "success";
    }

    /**
     * 编辑图书
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        goodsUiService.update(book);
        return "success";
    }

    /**
     * 删除图书
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        goodsUiService.deleteById(id);
        return "success";
    }

    /****************************************/

}
