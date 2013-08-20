
CREATE TABLE users (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(50) NOT NULL,
	enabled BIT NOT NULL default true,
	dateCreated DATETIME NOT NULL
);

CREATE TABLE authorities (
  id BIGINT NOT NUll PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

ALTER TABLE authorities ADD CONSTRAINT fk_authorities_users foreign key (username) REFERENCES users(username);


CREATE TABLE balance (
  id BIGINT NOT NUll PRIMARY KEY AUTO_INCREMENT,
	money DECIMAL(10, 2) NOT NULL,
	saveMoneyDate DATETIME NOT NULL,
	userID VARCHAR(50) NOT NULL,
	editedById VARCHAR(50) NOT NULL
);

ALTER TABLE balance ADD CONSTRAINT fk_balance_users foreign key (userID) REFERENCES users(username);
ALTER TABLE balance ADD CONSTRAINT fk_balance_users_edited_by foreign key (editedById) REFERENCES users(username);

