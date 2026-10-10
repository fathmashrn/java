USE college;

CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);

INSERT IGNORE INTO student VALUES
(1, 'Anu', 85),
(2, 'Riya', 90),
(3, 'Amal', 78);
