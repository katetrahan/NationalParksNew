SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS states (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    numberOfParks VARCHAR,
    population VARCHAR

);


CREATE TABLE IF NOT EXISTS parks (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    peak VARCHAR,
    terrain VARCHAR,
    visits VARCHAR,
    resize VARCHAR
);
