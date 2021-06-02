package com.xxx.dao;

import com.xxx.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一个Book
    int addBook(Books books);

    // 根据id删除一个Book
    int deleteBookById(@Param("bookId") int id);

    // 更新Book
    int updateBook(Books books);

    // 根据id查询,返回一个Book
    // @Param("bookId") 表示和xml里面配置的bookID参数名不一致
    Books queryBookById(@Param("bookId") int id);

    // 查询全部Book,返回list集合
    List<Books> queryAllBook();

    // List<Books>
    // 查询Book,返回list集合
    Books queryBookByName(@Param("bookName") String bookName);

}
