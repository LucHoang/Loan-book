package com.hsl.service;

import com.hsl.exception.DuplicateEmailException;
import com.hsl.model.Book;
import com.hsl.model.Order;
import com.hsl.repository.IBookRepository;
import com.hsl.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private IBookRepository bookRepository;

    public Order save(Order order){
        return orderRepository.save(order);
//        try {
//            return customerRepository.save(book);
//        } catch (DataIntegrityViolationException e) {
//            throw new DuplicateEmailException();
//        }
    }

    public Iterable<Order> findAllByCodeContaining(String code) {
        return orderRepository.findAllByCodeContaining(code);
    }

    public Book returnBook(Iterable<Order> orders) throws DuplicateEmailException, Exception {
        try {
            Long bookID = null;
            for (Order order : orders) {
                bookID = order.getBookId();
                delete(order);
                break;
            }
            Optional<Book> book = bookService.findOne(bookID);
//        bookService.save(book.get());

            book.get().setQuantity(book.get().getQuantity() + 1);
            return bookRepository.save(book.get());
        } catch  (InvalidDataAccessApiUsageException e) {
            throw new DuplicateEmailException();
        }
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
