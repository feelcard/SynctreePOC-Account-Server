use carddb;

DROP TABLE IF EXISTS `card_info`;

CREATE TABLE `card_info` (
	`id`	varchar(50)	NOT NULL,
	`card_number`	varchar(50)	NULL,
	`password`	varchar(255)	NULL,
	`create_date`	varchar(50)	NULL,
	`suspension_date`	varchar(50)	NULL,
	`suspension_yn`	varchar(50)	NULL,
	`card_type`	varchar(50)	NULL,
	`CI`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `payment_history`;

CREATE TABLE `payment_history` (
	`id`	varchar(50)	NOT NULL,
	`card_id`	varchar(50)	NOT NULL,
	`payment_date`	varchar(50)	NULL,
	`product`	varchar(255)	NULL,
	`price`	bigint(8)	NULL
);

ALTER TABLE `card_info` ADD CONSTRAINT `PK_CARD_INFO` PRIMARY KEY (
	`id`
);

ALTER TABLE `payment_history` ADD CONSTRAINT `PK_PAYMENT_HISTORY` PRIMARY KEY (
	`id`,
	`card_id`
);

ALTER TABLE `payment_history` ADD CONSTRAINT `FK_card_info_TO_payment_history_1` FOREIGN KEY (
	`card_id`
)
REFERENCES `card_info` (
	`id`
);
