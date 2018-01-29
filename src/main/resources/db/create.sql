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
    terrain VARCHAR,
    visits VARCHAR,
    resize VARCHAR
);

CREATE TABLE IF NOT EXISTS tips (
    id int PRIMARY KEY auto_increment,
    writtenBy VARCHAR,
    content VARCHAR,
    rating INTEGER,
    parkId INTEGER

);

CREATE TABLE IF NOT EXISTS states_parks (
    id int PRIMARY KEY auto_increment,
    stateId INTEGER,
    parkId INTEGER

);
