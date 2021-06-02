package com.xxx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FYC
 */

/**
 * // lombok写法
 * // Setter + Getter + toString 方法
 * @Data
 * // 有参构造方法
 * @AllArgsConstructor
 * // 有参构造方法
 * @NoArgsConstructor
 * */
public class Books {
    private  int bookID;
    private  String bookName;
    private  int bookCounts;
    private  String detail;

    public Books() {
    }

    public Books(int bookID, String bookName, int bookCounts, String detail) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.detail = detail;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public String getDetail() {
        return detail;
    }


    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", detail='" + detail + '\'' +
                '}';
    }

}
