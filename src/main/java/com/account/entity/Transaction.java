package com.account.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	private String transactionId;

	private String description;

	private Boolean isCredited;
	
	private Double transactionAmount;
	
	private String accountNumber;
	
	private String userName;

	@CreationTimestamp
	private LocalDateTime transactionDate;
}
