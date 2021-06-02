package com.xxx.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xxx.dao.BookMapper;
import com.xxx.pojo.Books;
import com.xxx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;


/**
 * 查询全部书籍
 * */

// @Controller就是扫描controller下的类，然后全部自动生成bean，不用再xml手动配置了
@Controller
@RequestMapping("/book")
public class BookController {

/*        // 调用Service
        @Autowired
        // 指定一个唯一的bean对象注入!
        // @Qualifier 注解只是告诉controller层去处理那个类的，这是类的标识
        @Qualifier("bookServiceImpl")
        // 找到service实体类，如果在service使用的不是注解注入，会首先找到xml文件的bean
*/

    // 使用  @Resource 替代 @Autowired + @Qualifier
    // 也可以找到service层
    @Resource(name="bookServiceImpl")
    private BookService bookService;

    // 查询全部的书籍，并返回一个书籍展示页面
    @RequestMapping("/allBook")
    // 返回一个url路径
    public String list(Model model) {
        List<Books> books = bookService.queryAllBook();

        // 封装数据，直接在jsp页面取出并渲染
        model.addAttribute("list", books);

        // 封装要跳转的视图，放在ModeLAndView中，视图解析器会进行设置前缀和后缀
        return "allBook";
    }

    // 跳转添加书籍页面
    // 网页url
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        // 进入addBook.jsp
        return "addBook";
    }

    // 添加书籍请求,form表单提交时进行的操作
    @RequestMapping("/addtheBook")
    public String addBook(Books books) {
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        // 回到首页，重定向,重定向可以阻止重复提交表单
        // 重定向到@RequestMapping("/allBook") 请求
        return "redirect:/book/allBook";
    }

    // 跳转修改数据页面
    @RequestMapping("/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable("id") int id, Model model){
        // 获取书籍ID
        Books books = bookService.queryBookById(id);

        model.addAttribute("Books", books);
        return "updateBook";
    }

    // 修改书籍请求,form表单提交时进行的操作
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook=>" + books);
        bookService.updateBook(books);
        // 回到首页，重定向,重定向可以阻止重复提交表单
        // 重定向到@RequestMapping("/allBook") 请求
        return "redirect:/book/allBook";
    }


    // 删除数据
    @RequestMapping("/delBook/{bookId}")
    public String delBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        System.out.println("delBookId=>  " + id);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        // 接收前端信息，处理业务
        Books books = bookService.queryBookByName(queryBookName);
        System.err.println("queryBook" + books);

        // 返回业务结果，传递数据到前端
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        model.addAttribute("list", list);
        return  "redirect:/book/allBook";

        // 前端查询为空，不显示数据，解决方法
        // 直接return “redirect:/allBook”?
        // 这里其实换一种思路，SQL改为模糊查询也是可以的。
        // 判断查询数据是否为空
        // 加入分页跳转功能，加入1000万数据（采用redis数据库或者Hbase），加入elatisearch搜索,在加入实时增加数据，加入kafka
    }


}
