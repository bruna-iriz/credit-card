CREATE TABLE `tb_account` (
  `account_id` bigint(20) NOT NULL,
  `account_balance` decimal(19,2) DEFAULT NULL,
  `document_number` varchar(255) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY (`document_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tb_merchant` (
  `merchant_id` bigint(20) NOT NULL,
  `country` varchar(2),
  `name` varchar(40) NOT NULL,
  `state` varchar(255) NOT NULL,
  PRIMARY KEY (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_transactions` (
  `transaction_id` bigint(20) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `benefits_categories` int(11) NOT NULL,
  `event_date` datetime NOT NULL,
  `mcc` varchar(255) NOT NULL,
  `merchant_id` bigint(20) NOT NULL,
  `status_transaction` varchar(255) DEFAULT NULL,
  `total_amount` decimal(19,2) DEFAULT NULL,
  `account_account_id` bigint(20) NOT NULL,
  `merchant_merchant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY (`account_account_id`),
  KEY (`merchant_merchant_id`),
  FOREIGN KEY (`merchant_merchant_id`) REFERENCES `tb_merchant` (`merchant_id`),
  FOREIGN KEY (`account_account_id`) REFERENCES `tb_account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;