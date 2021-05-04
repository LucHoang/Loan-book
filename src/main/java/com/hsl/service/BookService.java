package com.hsl.service;

import com.hsl.model.Book;
import com.hsl.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookServie{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) throws Exception {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> search(String keyword) {
        return null;
    }

    @Override
    public Page<Book> search(String keyword, Pageable pageInfo) {
        return null;
    }

    @Override
    public Optional<Book> findOne(Long id) throws Exception {
        Optional<Book> customerOptional = bookRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not found!");
        }
        return customerOptional;
    }

    @Override
    public Book save(Book book){
        book.setQuantity(book.getQuantity()-1);
        return bookRepository.save(book);
//        try {
//            return customerRepository.save(book);
//        } catch (DataIntegrityViolationException e) {
//            throw new DuplicateEmailException();
//        }
    }

    @Override
    public List<Book> save(List<Book> Books) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Book> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void delete(Book book) { ;
    }

    @Override
    public void delete(List<Book> books) {

    }

    @Override
    public void deleteAll() {

    }
}
