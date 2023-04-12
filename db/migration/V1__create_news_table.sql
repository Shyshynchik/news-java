CREATE TABLE articles
(
    id         SERIAL PRIMARY KEY,
    title      VARCHAR(255),
    date       DATE,
    annotation VARCHAR(255),
    body       TEXT,
    counter    INTEGER
);