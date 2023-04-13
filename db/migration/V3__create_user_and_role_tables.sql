CREATE TABLE roles
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    display_name VARCHAR(255) NOT NULL
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR(255) UNIQUE NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id  INTEGER NOT NULL REFERENCES roles(id)
);

CREATE UNIQUE INDEX idx_users_login ON users (login);
CREATE UNIQUE INDEX idx_users_email ON users (email);