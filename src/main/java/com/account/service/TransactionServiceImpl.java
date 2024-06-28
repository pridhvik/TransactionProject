package com.account.service;

import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.account.dto.TransactionDto;
import com.account.entity.Transaction;
import com.account.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository repo;

	public TransactionServiceImpl(TransactionRepository repo) {
		this.repo = repo;
	}

	@KafkaListener(topics = "account-transactions", groupId = "pk-group")
	@Override
	public void recordTransaction(TransactionDto transaction) {
		System.out.println(transaction.toString());
		Transaction trans = new Transaction();
		BeanUtils.copyProperties(transaction, trans);
		repo.save(trans);
	}

}
