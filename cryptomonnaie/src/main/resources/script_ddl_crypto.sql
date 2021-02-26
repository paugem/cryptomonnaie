CREATE DATABASE IF NOT EXISTS cda_cryptomonnaie;
GRANT ALL PRIVILEGES ON cda_cryptomonnaie.* TO 'cda1'@'%';

CREATE TABLE IF NOT EXISTS currency(
   id_currency INT AUTO_INCREMENT NOT NULL,
   label_currency VARCHAR(50) NOT NULL,
   current_price DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS avoirs(
   id_avoirs INT AUTO_INCREMENT NOT NULL,
   date_achat DATE NOT NULL,
   prix_achat_unite DECIMAL(15,2) NOT NULL,
   nbre_unite INT NOT NULL,
   id_currency INT NOT NULL,
   PRIMARY KEY(id_avoirs),
   FOREIGN KEY(id_currency) REFERENCES currency(id_currency)
);
