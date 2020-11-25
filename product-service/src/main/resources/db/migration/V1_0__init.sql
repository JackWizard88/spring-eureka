create table products (
    id                      bigint primary key AUTO_INCREMENT,
    title                   varchar(255),
    price                   decimal(10,2)
);

insert into products (title, price)
values
('Хлеб', 25.50),
('Сосиски', 225.50),
('Йогурт', 85.50),
('Сливки', 250.90),
('Морковь', 35.00),
('Лук', 45.50),
('Чеснок', 25.50),
('Кабачок', 30.90),
('Масло', 120.99),
('Коффе', 450.90),
('Сыр', 650),
('Чай', 250.80),
('Молоко', 79.90),
('Томаты', 150.99),
('Огурцы', 89.90),
('картофель', 49.00),
('Яйца', 130.49),
('Персики', 130.49),
('Бананы', 130.49),
('Яблоки', 130.49);

create table orders (
    id                      bigint primary key AUTO_INCREMENT,
    price                   decimal(10,2)
);

create table order_items (
    id                      bigint primary key AUTO_INCREMENT,
    product_id              bigint references products(id),
    order_id                bigint references orders(id),
    price                   decimal(10,2),
    price_per_product       decimal(10,2),
    quantity                int
);