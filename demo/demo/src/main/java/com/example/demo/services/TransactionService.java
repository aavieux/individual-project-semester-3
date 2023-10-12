package com.example.demo.services;

import com.example.demo.models.Transaction;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.getAllTransactions();
    }

    public boolean addNewTransaction(Transaction transaction){
        return transactionRepository.addTransaction(transaction.getUser().getId(), transaction.getBook().getId(), transaction.getValue(), transaction.getStatus().toString(), transaction.getDate());
    }
}
