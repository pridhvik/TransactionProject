package com.account.service;

import com.account.dto.TransactionDto;

public interface TransactionService {

	public void recordTransaction(TransactionDto transaction);
}
