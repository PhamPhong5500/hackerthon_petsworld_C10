create database `petsworld`;
use `petsworld`;

create TABLE IF NOT EXISTS roles (
                                     id INT primary key auto_increment,
                                     name VARCHAR(50) not null unique
    );

create TABLE IF NOT EXISTS customers (
                                         id INT primary key auto_increment,
                                         first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
    email VARCHAR(50) not null,
    gender bit not null,
    address VARCHAR(250) not null,
    image VARCHAR(250),
    username varchar(100) not null unique,
    password VARCHAR(50) not null,
    status bit not null,
    active bit not null,
    role_id INT not null
    );


create TABLE IF NOT EXISTS services (
	id INT primary key auto_increment,
	name VARCHAR(50) not null,
    description VARCHAR(50),
    booking_time date,
    duration varchar(100),
    price float(8,2)
    );

create TABLE IF NOT EXISTS partners (
                                        id INT primary key auto_increment,
                                        first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
    email VARCHAR(50) NOT NULL UNIQUE CHECK (`email` LIKE '%_@_%.__%'),
    address VARCHAR(100) not null,
    image VARCHAR(50) ,
    username varchar(50) not null unique,
    password VARCHAR(250) not null,
    status bit  not null,
    active bit not null,
    type varchar(50),
    role_id INT not null,
    description VARCHAR(50)
    );

create TABLE IF NOT EXISTS partner_service (
                                               id INT primary key auto_increment,
                                               partner_id int not null,
                                               service_id int not null);
 create table IF NOT exists products(
id int primary key auto_increment,
name varchar(250) not null,
quantity int,
price varchar(250),
status double,
image varchar(250)
);   
   

                                        
create table if not exists carts (
	id int primary key auto_increment,
    name varchar(50) 
);

create table cart_product(
	cart_id int,
    product_id int
);

create TABLE IF NOT EXISTS orders (
                                      id INT primary key auto_increment,
                                      customer_id INT not null,
                                      partner_id INT,
                                      service_id INT not null,
                                      total INT ,
                                      time datetime,
                                      cart_id int
);

create table if not exists order_service(
                                            id INT primary key auto_increment,
                                            order_id int not null,
                                            service_id int not null
);

create  TABLE IF NOT EXISTS pets (
                                     id INT primary key auto_increment,
                                     customer_id int not null,
                                     name VARCHAR(50) not null,
    description VARCHAR(50),
    gender bit not null,
    birth date
    );
    


-- customers
ALTER TABLE customers ADD CONSTRAINT FK_customer_role FOREIGN KEY (`role_id`) REFERENCES roles (`id`);


-- partners
ALTER TABLE partners ADD CONSTRAINT FK_partner_role FOREIGN KEY (`role_id`) REFERENCES roles (`id`);

-- partner-service
ALTER TABLE partner_service ADD CONSTRAINT FK_partner_service FOREIGN KEY (`partner_id`) REFERENCES partners (`id`);
ALTER TABLE partner_service ADD CONSTRAINT FK_service_partner FOREIGN KEY (`service_id`) REFERENCES services (`id`);


-- card_product
ALTER TABLE cart_product ADD CONSTRAINT FK_cart_product FOREIGN KEY (`cart_id`) REFERENCES carts (`id`);
ALTER TABLE cart_product ADD CONSTRAINT FK_product_cart FOREIGN KEY (`product_id`) REFERENCES products (`id`);
-- orders
ALTER TABLE orders ADD CONSTRAINT FK_order_customer FOREIGN KEY (`customer_id`) REFERENCES customers (`id`);
ALTER TABLE orders ADD CONSTRAINT FK_order_partner FOREIGN KEY (`partner_id`) REFERENCES partners (`id`);
ALTER TABLE orders ADD CONSTRAINT FK_order_cart FOREIGN KEY (`cart_id`) REFERENCES carts (`id`);


-- order-service
ALTER TABLE order_service ADD CONSTRAINT FK_order_service FOREIGN KEY (`service_id`) REFERENCES services (`id`);
ALTER TABLE order_service ADD CONSTRAINT FK_service_order FOREIGN KEY (`order_id`) REFERENCES orders (`id`);

-- pet
ALTER TABLE pets ADD CONSTRAINT FK_pet_customer FOREIGN KEY (`customer_id`) REFERENCES customers (`id`);

INSERT INTO customers (first_name, last_name, email, gender, address, image, username, password, status, active, role_id)
VALUES
   ('John', 'Doe', 'john.doe@example.com', b'1', '123 Nguyen Van Linh, District 7, Ho Chi Minh City', NULL, 'johndoe', 'password123', 1, 1, 1),
    ('Jane', 'Doe', 'jane.doe@example.com', b'0', '456 Nguyen Trai, District 5, Ho Chi Minh City', NULL, 'janedoe', 'password456', 1, 1, 1),
    ('Bob', 'Smith', 'bobsmith@example.com', 1, '789 Elm St, Anytown USA', 'bob.jpg', 'bobsmith', 'mypassword', 1, 1, 1),
    ('Alice', 'Johnson', 'alicejohnson@example.com', 0, '246 Maple St, Anytown USA', 'alice.jpg', 'alicejohnson', 'mypassword', 1, 1, 4),
    ('David', 'Lee', 'davidlee@example.com', 1, '369 Pine St, Anytown USA', 'david.jpg', 'davidlee', 'mypassword', 1, 1, 2),
    ('Sarah', 'Jones', 'sarahjones@example.com', 0, '135 Oak St, Anytown USA', 'sarah.jpg', 'sarahjones', 'mypassword', 1, 1, 1),
    ('James', 'Brown', 'jamesbrown@example.com', 1, '246 Cedar St, Anytown USA', 'james.jpg', 'jamesbrown', 'mypassword', 1, 1, 2),
    ('Mary', 'Wilson', 'marywilson@example.com', 0, '579 Elm St, Anytown USA', 'mary.jpg', 'marywilson', 'mypassword', 1, 1, 2),
    ('William', 'Davis', 'williamdavis@example.com', 1, '135 Maple St, Anytown USA', 'william.jpg', 'williamdavis', 'mypassword', 1, 1, 3),
    ('Elizabeth', 'Taylor', 'elizabethtaylor@example.com', 0, '579 Cedar St, Anytown USA', 'elizabeth.jpg', 'elizabethtaylor', 'mypassword', 1, 1, 1),
    ('Michael', 'Johnson', 'michaeljohnson@example.com', 1, '246 Pine St, Anytown USA', 'michael.jpg', 'michaeljohnson', 'mypassword', 1, 1, 2),
    ('Megan', 'Brown', 'meganbrown@example.com', 0, '579 Oak St, Anytown USA', 'megan.jpg', 'meganbrown', 'mypassword', 1, 1, 1),
    ('Christopher', 'Smith', 'christophersmith@example.com', 1, '246 Cedar St, Anytown USA', 'christopher.jpg', 'christophersmith', 'mypassword', 1, 1, 2);
    
    
INSERT INTO partners (first_name, last_name, email, address, image, username, password, status, active, type, role_id, description) VALUES
('John', 'Doe', 'johndofcbdgfe@example.com', '123 Main St, Anytowjujuyn USA', 'johhỵnjutpg', 'johnrgtrurdoe', 'password123', 1, 1, 'partner', 1, 'Example partner'),
('Jane', 'Doe', 'jalbhmnhnedoe@example.com', '456 Main St, Anytown USA', 'jane.jpg', 'janeu/l,udoe', 'password456', 1, 1, 'partner', 2, 'Example partner'),
('Bob', 'Smith', 'bobsmith@example.com', '789 Main St, Anytown USA', 'bob.jpg', 'bobsmith', 'password789', 1, 1, 'partner', 3, 'Example partner'),
('Alice', 'Jones', 'alicejones@example.com', '1 Main St, Anytown USA', 'alice.jpg', 'alicejuiouiones', 'passwordabc', 1, 1, 'partner', 1, 'Example partner'),
('Joe', 'Johnson', 'joejohnson@example.com', '2 Main St, Anytown USA', 'joe.jpg', 'joejoiuohhnson', 'passworddef', 1, 1, 'partner', 2, 'Example partner'),
('Sara', 'Lee', 'saralee@example.com', '3 Main St, Anytown USA', 'sara.jpg', 'saralee', 'passwordghi', 1, 1, 'partner', 3, 'Example partner'),
('David', 'Brown', 'davidbrown@example.com', '4 Main St, Anytown USA', 'david.jpg', 'davidbrown', 'passwordjkl', 1, 1, 'partner', 1, 'Example partner'),
('Emily', 'Taylor', 'emilytaylor@example.com', '5 Main St, Anytown USA', 'emily.jpg', 'emilytaylor', 'passwordmno', 1, 1, 'partner', 2, 'Example partner'),
('Mike', 'Davis', 'mikedavis@example.com', '6 Main St, Anytown USA', 'mike.jpg', 'mikedavis', 'passwop0rdpqr', 1, 1, 'partner', 3, 'Example partner'),
('Karen', 'Wilson', 'karenwilson@example.com', '7 Main St, Anytown USA', 'karen.jpg', 'karenwilson', 'passwordstu', 1, 1, 'partner', 1, 'Example partner');


INSERT INTO pets (customer_id, name, description, gender, birth)
VALUES
(1, 'Max', 'Golden Retriever', 1, '2018-05-01'),
(2, 'Bella', 'Siamese', 0, '2019-02-14'),
(3, 'Charlie', 'Beagle', 1, '2017-11-15'),
(4, 'Luna', 'Tabby', 0, '2018-09-07'),
(5, 'Rocky', 'German Shepherd', 1, '2016-04-23'),
(6, 'Lucy', 'Poodle', 0, '2019-08-08'),
(7, 'Daisy', 'Golden Doodle', 0, '2020-01-05'),
(8, 'Bailey', 'Labrador Retriever', 1, '2015-12-11'),
(9, 'Sadie', 'Yorkshire Terrier', 0, '2016-07-20'),
(10, 'Toby', 'Cocker Spaniel', 1, '2017-03-19');

iNSERT INTO products (name, quantity, price, status, image)
VALUES
  ('Product A', 1, '100.00', 17, 'https://scooby-nextjs.vercel.app/assets/images/bg/cart-01.png'),
  ('Product B', 2, '50.00', 75, 'https://scooby-nextjs.vercel.app/assets/images/bg/cart-02.png'),
  ('Product C', 1, '20.00', 43, 'https://scooby-nextjs.vercel.app/assets/images/bg/cart-03.png');
    
INSERT INTO partner_service (partner_id, service_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 1),
    (3, 3),
    (4, 2),
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 2);
    
INSERT INTO services (name, description, booking_time, duration, price)
VALUES
    ('Haircut', 'Standard haircut for men', '2023-03-20', '30 minutes', 25.00),
    ('Manicure', 'Nail treatment for hands', '2023-03-21', '45 minutes', 35.00),
    ('Pedicure', 'Nail treatment for feet', '2023-03-22', '60 minutes', 45.00),
    ('Massage', 'Full-body massage', '2023-03-23', '90 minutes', 80.00),
    ('Facial', 'Facial treatment', '2023-03-24', '60 minutes', 60.00),
    ('Waxing', 'Hair removal for men', '2023-03-25', '30 minutes', 40.00),
    ('Hair Coloring', 'Coloring service for hair', '2023-03-26', '120 minutes', 150.00),
    ('Eyebrow Threading', 'Threading service for eyebrows', '2023-03-27', '15 minutes', 15.00),
    ('Makeup', 'Makeup application', '2023-03-28', '60 minutes', 50.00),
    ('Teeth Whitening', 'Teeth whitening treatment', '2023-03-29', '45 minutes', 70.00);

