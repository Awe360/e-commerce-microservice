-- Create category table
CREATE TABLE IF NOT EXISTS category (
    id          INTEGER      NOT NULL PRIMARY KEY,
    description VARCHAR(255),
    name        VARCHAR(255) NOT NULL
);

-- Create product table with proper foreign key
CREATE TABLE IF NOT EXISTS product (
    id                INTEGER        NOT NULL PRIMARY KEY,
    description       VARCHAR(255),
    name              VARCHAR(255)   NOT NULL,
    available_quantity DOUBLE PRECISION NOT NULL,
    price             NUMERIC(38, 2) NOT NULL,
    category_id       INTEGER        NOT NULL,
    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
        REFERENCES category(id)
);

-- Sequences (PostgreSQL style – safe with IF NOT EXISTS)
CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS product_seq  INCREMENT BY 50;