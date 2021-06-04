drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `item` (
    `Item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `Item_name` VARCHAR(40) NOT NULL,
    `Value` double NOT NULL,
    PRIMARY KEY (`Item_id`)
);

CREATE TABLE IF NOT EXISTS orders(
order_id INT NOT NULL auto_increment,
customer_id INT NOT NULL,
primary key(order_id),
foreign key (customer_id)references customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_items(
orderItems_id INT NOT NULL auto_increment,
order_id INT NOT NULL,
Item_id INT NOT NULL,
quantity INT NOT NULL,
total_cost Double NOT NULL,
primary key(orderItems_id),
foreign key (order_id)references orders(order_id) ON DELETE CASCADE,
foreign key (item_id)references Item(item_id) ON DELETE CASCADE
);