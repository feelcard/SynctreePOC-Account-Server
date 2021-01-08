use bankdb;

DROP TABLE IF EXISTS `account_info`;

CREATE TABLE `account_info` (
	`id`	varchar(50)	NOT NULL,
	`account_number`	varchar(50)	NULL,
	`password`	varchar(255)	NULL,
	`create_date`	varchar(50)	NULL,
	`suspension_date`	varchar(50)	NULL,
	`suspension_yn`	boolean	NULL,
	`balance`	bigint(8)	NULL,
	`account_type`	varchar(50)	NULL,
	`CI`	varchar(50)	NULL,
	`Field`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `trading_history`;

CREATE TABLE `trading_history` (
	`id`	varchar(50)	NOT NULL,
	`account_id`	varchar(50)	NOT NULL,
	`trading_date`	varchar(50)	NULL
);

ALTER TABLE `account_info` ADD CONSTRAINT `PK_ACCOUNT_INFO` PRIMARY KEY (
	`id`
);

ALTER TABLE `trading_history` ADD CONSTRAINT `PK_TRADING_HISTORY` PRIMARY KEY (
	`id`,
	`account_id`
);

ALTER TABLE `trading_history` ADD CONSTRAINT `FK_account_info_TO_trading_history_1` FOREIGN KEY (
	`account_id`
)
REFERENCES `account_info` (
	`id`
);
