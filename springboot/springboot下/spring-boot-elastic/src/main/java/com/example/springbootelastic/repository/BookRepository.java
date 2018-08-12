package com.example.springbootelastic.repository;

import com.example.springbootelastic.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchCrudRepository<Book,Integer> {

    List<Book> findByBookNameLike(String bookName);
}
