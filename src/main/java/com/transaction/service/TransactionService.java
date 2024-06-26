package com.transaction.service;

import com.transaction.dto.TransactionDto;

public interface TransactionService {

	public void recordTransaction(TransactionDto transaction);
}
