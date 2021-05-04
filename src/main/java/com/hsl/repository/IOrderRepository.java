package com.hsl.repository;

import com.hsl.model.Book;
import com.hsl.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderRepository extends PagingAndSortingRepository<Order, Long> {
    Iterable<Order> findAllByCodeContaining(String code);
}
