CREATE TABLE IF NOT EXISTS product
(
    id SERIAL PRIMARY KEY,
    showcase_id INT,
    position VARCHAR(120) NOT NULL,
    name VARCHAR(120) NOT NULL,
    type VARCHAR(120) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    add_date date NOT NULL,
    update_date date NOT NULL,
    FOREIGN KEY (showcase_id) REFERENCES showcase (id)
);
