CREATE TABLE IF NOT EXISTS showcase
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    address VARCHAR(120) NOT NULL,
    type VARCHAR(120) NOT NULL,
    create_date date NOT NULL,
    last_date date NOT NULL
);