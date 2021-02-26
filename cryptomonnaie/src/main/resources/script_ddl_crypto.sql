CREATE DATABASE IF NOT EXISTS cda_cryptomonnaie;
GRANT ALL PRIVILEGES ON cda_cryptomonnaie.* TO 'cda1'@'%';

CREATE TABLE IF NOT EXISTS currency(
   id_currency INT AUTO_INCREMENT NOT NULL,
   name_currency VARCHAR(50) NOT NULL,
   label_currency VARCHAR(3) NOT NULL,
   current_price DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(id_currency)
);

CREATE TABLE IF NOT EXISTS holding(
   id_holding INT AUTO_INCREMENT NOT NULL,
   purchase_date DATE NOT NULL,
   unit_purchase_price DECIMAL(15,2) NOT NULL,
   quantity INT NOT NULL,
   id_currency INT NOT NULL,
   PRIMARY KEY(id_holding),
   FOREIGN KEY(id_currency) REFERENCES currency(id_currency)
);
