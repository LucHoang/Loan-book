package com.hsl.repository;

import com.hsl.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {
}
