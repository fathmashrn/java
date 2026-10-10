USE college;

CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DECIMAL(10,2)
);

INSERT IGNORE INTO employee VALUES
(1, 'Anu', 25000.00);
