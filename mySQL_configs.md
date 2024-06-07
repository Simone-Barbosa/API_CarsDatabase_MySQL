## Configuração do application.properties para conexão com o banco de dados

server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/cars_database

spring.datasource.username=root

spring.datasource.password=***** (sua senha)

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true


## Instruções para criação das tabelas no banco de dados mySQL

### Crie o Schema chamado cars_database:

CREATE SCHEMA IF NOT EXISTS `cars_database`;

### Criar tabela color:

CREATE TABLE IF NOT EXISTS `cars_database`.`color` (
`id_color` int NOT NULL AUTO_INCREMENT,
`name_color` varchar(45) NOT NULL,
PRIMARY KEY (`id_color`)
)

### Criar tabela make (marca/fabricante):

CREATE TABLE IF NOT EXISTS `cars_database`.`make` (
`id_make` int NOT NULL AUTO_INCREMENT,
`name_make` varchar(45) NOT NULL,
PRIMARY KEY (`id_make`)
)

### Criar tabela cars:

CREATE TABLE IF NOT EXISTS `cars_database`.`cars` (
`id_car` int NOT NULL AUTO_INCREMENT,
`name_car` varchar(50) NOT NULL,
`year_manufacturing` int NOT NULL,
`year_model` int NOT NULL,
`model` varchar(100) NOT NULL,
`make_id` int DEFAULT NULL,
`color_list` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id_car`),
KEY `fk_car_make_idx` (`make_id`) /*!80000 INVISIBLE */,
CONSTRAINT `fk_car_make` FOREIGN KEY (`make_id`) REFERENCES `make` (`id_make`) ON DELETE RESTRICT ON UPDATE RESTRICT
)

### Criar tabela car_color:

CREATE TABLE IF NOT EXISTS `cars_database`.`car_color` (
`id_car` int NOT NULL,
`id_color` int NOT NULL,
KEY `fk_car_color_car1_idx` (`id_car`),
KEY `fk_car_color_color1_idx` (`id_color`),
CONSTRAINT `fk_car_color_car1` FOREIGN KEY (`id_car`) REFERENCES `cars` (`id_car`),
CONSTRAINT `fk_car_color_color1` FOREIGN KEY (`id_color`) REFERENCES `color` (`id_color`)
)