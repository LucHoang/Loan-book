package com.hsl.controller;

import com.hsl.exception.DuplicateEmailException;
import com.hsl.model.Book;
import com.hsl.model.Order;
import com.hsl.repository.IOrderRepository;
import com.hsl.service.IBookServie;
import com.hsl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookContrller {
    @Autowired
    private IBookServie bookServie;

    @Autowired
    private OrderService orderService;

    @GetMapping("/book")
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/list");
        Page<Book> books = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/book/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/info");
            Optional<Book> customerOptional = bookServie.findOne(id);
            modelAndView.addObject("book", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/book");
        }
    }

    @PostMapping("/book")
    public ModelAndView updateCustomer(Book book) throws DuplicateEmailException {
        if (book.getQuantity()<=0) {
            throw new DuplicateEmailException();
        } else {
            bookServie.save(book);
            int code = (int) (Math.random() * 100000);
            Order order = new Order(book.getId(), Integer.toString(code));
            orderService.save(order);
            ModelAndView modelAndView = new ModelAndView("/order");
            modelAndView.addObject("order", order);
            return modelAndView;
        }
    }

    @GetMapping("/return")
    public ModelAndView returnBook(@RequestParam("search") Optional<String> search) throws DuplicateEmailException, Exception {
        Iterable<Order> orders;
        orders = orderService.findAllByCodeContaining(search.get());
        orderService.returnBook(orders);
        ModelAndView modelAndView = new ModelAndView("redirect:/book");
//        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/inputs-not-acceptable");
    }

    private Page<Book> getPage(Pageable pageInfo) throws Exception {
        return bookServie.findAll(pageInfo);
    }

    private Page<Book> search(Optional<String> s, Pageable pageInfo) {
        return bookServie.search(s.get(), pageInfo);
    }
}
