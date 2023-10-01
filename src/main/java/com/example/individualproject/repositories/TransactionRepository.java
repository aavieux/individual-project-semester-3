package com.example.individualproject.repositories;

import com.example.individualproject.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // You can define custom query methods here if needed
}
