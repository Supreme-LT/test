package cn.edu.goodsprovider.controller;

import cn.edu.goodscommons.domain.Book;
import cn.edu.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;
    /**
     * 测试goodsui调用是否成功
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了goodsProvider~~~");
        return "调用成功";
    }

    /**
     * 返回所有图书
     */
    @RequestMapping("/list")
    public List<Book> list(){
        List<Book> bookList = goodsProviderService.getBookList();
        return bookList;
    }

    /**
     * 查询单个图书
     */
    @RequestMapping("/detail/{id}")
    public Book detail(@PathVariable("id") Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Book book = goodsProviderService.getBookById(id);
        return book;
    }

    /**
     * 添加图书
     */
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return "success";
    }

    /**
     * 删除图书
     */
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        goodsProviderService.deleteById(id);
        return "success";
    }

    /**
     * 编辑图书
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        goodsProviderService.update(book);
        return "success";
    }

    @HystrixCommand(fallbackMethod = "fallBackHystrix",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//设置时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//设置次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//服务错误率
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num") Integer num){
        int n = (int)Math.floor(Math.random() * 100);
        int res = n / num;
        return "服务正常返回:"+n+"/"+num+"="+res;

    }
    public String fallBackHystrix(@RequestParam("num") Integer num){
        return "服务降级响应：num为0";
    }
}
