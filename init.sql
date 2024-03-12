CREATE TABLE vendors (
                         id             BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key (UUID)',
                         name           VARCHAR(20) NOT NULL COMMENT 'Company Name',
                         feedback_score INTEGER COMMENT 'Customer Feedback Score',
                         location       VARCHAR(200) COMMENT 'Geographical Presence'
);
CREATE TABLE products (
                          id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key (UUID)',
                          vid   BIGINT NOT NULL COMMENT 'Vendor ID',
                          name  VARCHAR(80) NOT NULL COMMENT 'Product Name',
                          price FLOAT NOT NULL COMMENT 'Price',
                          tags  TINYTEXT COMMENT 'Tags (up to three)',
                          FOREIGN KEY (vid) REFERENCES vendors(id)
);
CREATE TABLE customers (
                           id  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key (UUID)',
                           contact_number CHAR(20) COMMENT 'Contact Number',
                           location VARCHAR(200) COMMENT 'Receiving Address',
                           delivery_requirement VARCHAR(200) COMMENT 'Delivery Requirement/Notes'
);
CREATE TABLE orders (
                        id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key (UUID)',
                        cid    BIGINT NOT NULL COMMENT 'Customer ID',
                        status INT NOT NULL COMMENT 'Order Status',
                        date   DATETIME NOT NULL COMMENT 'Order Date',
                        FOREIGN KEY (cid) REFERENCES customers(id)
);
CREATE TABLE order_details (
                               id       BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key (UUID)',
                               oid      BIGINT NOT NULL COMMENT 'Order ID',
                               pid      BIGINT NOT NULL COMMENT 'Product ID',
                               quantity INT NOT NULL COMMENT 'Quantity',
                               FOREIGN KEY (oid) REFERENCES orders(id),
                               FOREIGN KEY (pid) REFERENCES products(id)
);