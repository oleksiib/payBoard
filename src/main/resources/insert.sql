
INSERT INTO users VALUES ('admin', 'admin', true, '2000-01-01');
INSERT INTO users VALUES ('user', 'user', true, '2000-01-01');

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

INSERT INTO balance (money, saveMoneyDate, userID, editedById ) VALUES (12.55, NOW(), 'user', 'admin');
