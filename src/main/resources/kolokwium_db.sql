CREATE DATABASE IF NOT EXISTS jaz_zaliczenie;
USE jaz_zaliczenie;

DROP TABLE IF EXISTS currency;
CREATE TABLE currency
(
    id                BIGINT      NOT NULL AUTO_INCREMENT,
    cur_name          VARCHAR(10) NOT NULL,
    start_search_date DATE        NOT NULL,
    end_search_date   DATE        NOT NULL,
    avg_currency      FLOAT       NOT NULL,
    search_date       DATE        NOT NULL,
    search_time       TIME        NOT NULL,
    PRIMARY KEY (id)
);