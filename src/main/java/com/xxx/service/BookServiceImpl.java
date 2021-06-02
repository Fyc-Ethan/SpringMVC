package com.xxx.service;

import com.xxx.dao.BookMapper;
import com.xxx.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    // 调用dao层的操作，设置一个set接口，方便Spring管理
    // spring4.0之后不建议在字段使用autowired，可以在构造方法或setter上写。甚至有构造方法的时候可以省略@Autowired也可以自动实现注入

    private BookMapper bookMapper;

    // @Autowired 代替Bean的操作，注入
    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        // 业务层调用dao层
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
