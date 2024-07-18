<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Transaction Notification</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			line-height: 1.6;
		}

		.container {
			margin: 20px;
			padding: 20px;
			border: 1px solid #ddd;
			border-radius: 5px;
		}

		.header {
			font-size: 1.5em;
			margin-bottom: 20px;
		}

		.transaction-details {
			margin: 20px 0;
		}

		.transaction-details table {
			width: 100%;
			border-collapse: collapse;
		}

		.transaction-details th,
		.transaction-details td {
			border: 1px solid #ddd;
			padding: 8px;
		}

		.transaction-details th {
			background-color: #f2f2f2;
		}

		.footer {
			margin-top: 20px;
			font-size: 0.9em;
		}
	</style>
</head>

<body>
	<div class="container">
		<div class="header">Transaction Notification</div>

		<p>Dear ${trans.userName},</p>

		<p>We are writing to inform you that a transaction has been processed on your account. Below are the details of
			the transaction:</p>

		<div class="transaction-details">
			<table>
				<tr>
					<th>Transaction ID</th>
					<td>${trans.transactionId}</td>
				</tr>
				<tr>
					<th>Transaction Date</th>
					<td>${trans.transactionDate}</td>
				</tr>
				<tr>
					<th>Amount</th>
					<td>${trans.transactionAmount}</td>
				</tr>
				<tr>
					<th>Account Number</th>
					<td>${trans.accountNumber}</td>
				</tr>
			</table>
		</div>

		<p>If you have any questions or concerns about this transaction, please contact our customer support.</p>

		<div class="footer">
			<p>Thank you,</p>
			<p>Your Bank</p>
			<p>Customer Support: support@yourbank.com | +123 456 7890</p>
		</div>
	</div>
</body>

</html>