package com.account.service;

import java.io.IOException;

import com.account.dto.TransactionDto;

import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

public interface TransactionService {

	public void recordTransaction(TransactionDto transaction) throws MessagingException, TemplateException, IOException;
}
