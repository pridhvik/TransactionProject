package com.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

	private String transactionId;

	private String description;

	private Boolean isCredited;

	private Double transactionAmount;

	private String accountNumber;

	private String userName;
}
