package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.LibraryRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final TransactionRepository transactionRepository;
    private final LibraryRepository libraryRepository;

    //        ---------------------------------BOOKS---------------------------------------
    @Autowired
    public BookService(BookRepository bookRepository, TransactionRepository transactionRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.transactionRepository = transactionRepository;
        this.libraryRepository = libraryRepository;
    }

    public List<Book> getAllBooks(){
        return  bookRepository.getAllBooks();
    }

    public List<Book> getAllBooksBySearch(String query){
        List<Book> foundBooks = new java.util.ArrayList<>(List.of());
        for (Book book: bookRepository.getAllBooks()) {
            if (book.getTitle().contains(query)){
                foundBooks.add(book);
            }
            else if (book.getAuthor().getFirst_name().contains(query)) {
                foundBooks.add(book);
            }

        }
        return foundBooks;
    }

//        ---------------------------------TRANSACTIONS---------------------------------------

//    @Cacheable(value = "allTransactions")
//    public List<Transaction> getAllTransactions(){
//        return bookRepository.getAllTransactions();
//    }
    public List<Transaction>getAllTransactionsByUser(User user){
        return transactionRepository.getAllTransactionsByUser(user.getId());
    }
//    @CacheEvict(value = "allTransactions", allEntries = true)
    public boolean addNewTransaction(Transaction transaction){
        return transactionRepository.addTransaction(transaction.getUser().getId(), transaction.getBook().getId(), transaction.getValue(), transaction.getStatus().toString(), transaction.getDate());
    }
//        ---------------------------------Library---------------------------------------

    public List<Library> getAllLibrariesByUser(User user){
        return libraryRepository.getAllLibrariesByUser(user.getId());
    }
    public Optional<Library> getLibraryByIdByAuthenticatedUser(Long library_id, User authenticatedUser){
        return libraryRepository.getLibraryById(library_id, authenticatedUser.getId());
    }
    public boolean addLibrary(Library library){
        return libraryRepository.addLibrary(library.getTitle(), library.getUser().getId());
    }
}
