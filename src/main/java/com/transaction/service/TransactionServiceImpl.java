package com.transaction.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.transaction.dto.TransactionDto;
import com.transaction.entity.Transaction;
import com.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository repo;

	public TransactionServiceImpl(TransactionRepository repo) {
		this.repo = repo;
	}

	@Override
	public void recordTransaction(TransactionDto transaction) {
		Transaction trans = new Transaction();
		BeanUtils.copyProperties(transaction, trans);
		repo.save(trans);
	}

}
