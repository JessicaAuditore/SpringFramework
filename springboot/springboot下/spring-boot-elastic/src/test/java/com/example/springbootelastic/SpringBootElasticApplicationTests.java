package com.example.springbootelastic;

import com.example.springbootelastic.entity.Article;
import com.example.springbootelastic.entity.Book;
import com.example.springbootelastic.repository.BookRepository;
//import io.searchbox.client.JestClient;
//import io.searchbox.core.Index;
//import io.searchbox.core.Search;
//import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticApplicationTests {

//    @Autowired
//    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

//    @Test
//    public void contextLoads() throws IOException {
//        //1、给ES中索引（保存）一个文档
//        Article article = new Article();
//        article.setId(1);
//        article.setTitle("好消息");
//        article.setAuthor("zhangsan");
//        article.setContent("Hello world");
//
//        //构建一个索引功能
//        Index index = new Index.Builder(article).index("atguigu").type("news").build();
//        //执行
//        jestClient.execute(index);
//    }

    //测试搜索
    @Test
    public void search(){
//        String json="";
//        new Search.Builder()
    }

    @Test
    public void testBookRepository(){
//        Book book=new Book();
//        book.setId(1);
//        book.setBookName("西游记");
//        book.setAuthor("吴承恩");
//        bookRepository.save(book);
        for(Book book:bookRepository.findByBookNameLike("游")){
            System.out.println(book);
        }

    }

}
