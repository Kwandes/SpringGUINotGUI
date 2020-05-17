-- Create and populate a person table for the java spring practice
-- ---------------------------------------------------------------

USE spring;

DROP TABLE person;

CREATE TABLE person
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20),
    last_name  VARCHAR(30)
);

INSERT INTO person(first_name, last_name)
VALUES ('Clark', 'Kent'),
       ('Petur', 'Parkur'),
       ('Bruce', 'Gordon'),
       ('Bruce', 'Bannnner'),
       ('Thomas', 'Engine'),
       ('Peter', 'Hansen'),
       ('Hans', 'Hansun'),
       ('Claus', 'Hansan'),
       ('Peder', 'Hansen'),
       ('Bob', 'Hanson');

