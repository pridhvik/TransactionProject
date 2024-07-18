package com.account.service;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.account.dto.TransactionDto;
import com.account.entity.Transaction;
import com.account.repository.TransactionRepository;

import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository repo;
	private EmailService mailService;

	public TransactionServiceImpl(TransactionRepository repo, EmailService mailService) {
		super();
		this.repo = repo;
		this.mailService = mailService;
	}

	@KafkaListener(topics = "account-transactions", groupId = "pk-group")
	@Override
	public void recordTransaction(TransactionDto transaction)
			throws MessagingException, TemplateException, IOException {
		Transaction trans = new Transaction();
		BeanUtils.copyProperties(transaction, trans);
		Transaction save = repo.save(trans);
		System.out.println(save);
		mailService.sendEmail(save);
	}

}
