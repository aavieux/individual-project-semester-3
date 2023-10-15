package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    //        ---------------------------------BOOKS---------------------------------------
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return  bookRepository.getAllBooks();
    }



//        ---------------------------------TRANSACTIONS---------------------------------------

//    @Cacheable(value = "allTransactions")
//    public List<Transaction> getAllTransactions(){
//        return bookRepository.getAllTransactions();
//    }
    public List<Transaction>getAllTransactionsByUser(User user){
        return bookRepository.getAllTransactionsByUser(user.getId());
    }
//    @CacheEvict(value = "allTransactions", allEntries = true)
    public boolean addNewTransaction(Transaction transaction){
        return bookRepository.addTransaction(transaction.getUser().getId(), transaction.getBook().getId(), transaction.getValue(), transaction.getStatus().toString(), transaction.getDate());
    }
}
