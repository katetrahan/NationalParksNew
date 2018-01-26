SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS states (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    numberOfParks VARCHAR,
    population VARCHAR,

);

