package cn.edu.goodsui.service.impl;

import cn.edu.goodscommons.domain.Book;
import cn.edu.goodscommons.vo.ResultVo;
import cn.edu.goodsui.service.GoodsUiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUiServiceImpl implements GoodsUiService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodsProvider() {
        //1.调用服务的地址：应用名称和对应的映射url组合
        //根据 服务应用名称 和 对应的映射url 进入对应的controller方法中
        String object = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider返回的结果--->"+object);
    }

    @Override
    public List<Book> getBookList() {
        Book[] books = restTemplate.getForObject("http://goods-provider/provider/list", Book[].class);
        return Arrays.asList(books);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fullBackBookDetail",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }//降级响应设置的时间
    )
    public ResultVo getBookDetail(Integer id) {
        Book book = restTemplate.getForObject("http://goods-provider/provider/detail/"+id, Book.class);
        return ResultVo.ok(book);
    }

    public ResultVo fullBackBookDetail(Integer id) {
        return ResultVo.error("服务降级返回的响应内容");
    }


    @Override
    public String addBook(Book book) {
        String msg = restTemplate.postForObject("http://goods-provider/provider/add", book, String.class);
        return msg;
    }

    @Override
    public String update(Book book) {
        restTemplate.put("http://goods-provider/provider/update", book);
        //postForObject("http://goods-provider/provider/update", book, String.class);
        return "update success";
    }

    @Override
    public String deleteById(Integer id) {
        restTemplate.delete("http://goods-provider/provider/delete/"+id);
        //postForObject("http://goods-provider/provider/delete/"+id, String.class);
        return "delete success";
    }
}
