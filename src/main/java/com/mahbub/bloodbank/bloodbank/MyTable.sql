USE Blood_Bank_Java;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100),
                       mobile VARCHAR(20),
                       password VARCHAR(100),
                       blood_group VARCHAR(10),
                       district VARCHAR(50)
);