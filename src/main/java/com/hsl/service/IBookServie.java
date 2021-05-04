package com.hsl.service;

import com.hsl.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookServie {
    Iterable<Book> findAll();

    Page<Book> findAll(Pageable pageInfo) throws Exception;

    List<Book> search(String keyword);

    Page<Book> search(String keyword, Pageable pageInfo);

    Optional<Book> findOne(Long id) throws Exception;

    Book save(Book book);

    List<Book> save(List<Book> Books);

    boolean exists(Long id);

    List<Book> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Book book);

    void delete(List<Book> books);

    void deleteAll();
}
