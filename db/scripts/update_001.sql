CREATE TABLE IF NOT EXISTS posts (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(100),
                                     description TEXT,
                                     created DATE default current_date,
                                     visible BOOLEAN default false,
                                     city_id integer
);

CREATE TABLE IF NOT EXISTS candidates (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100),
                           description TEXT,
                           visible BOOLEAN default false,
                           created DATE default current_date,
                           city_id integer,
                           photo bytea
);

CREATE TABLE IF NOT EXISTS userss (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password TEXT
);

 ALTER TABLE userss ADD CONSTRAINT email_unique UNIQUE (email);





CREATE TABLE IF NOT EXISTS city
(
    id SERIAL PRIMARY KEY,
    name TEXT
);

INSERT INTO city(name) VALUES ('Москва');
INSERT INTO city(name) VALUES ('СПб');
INSERT INTO city(name) VALUES ('Екб');