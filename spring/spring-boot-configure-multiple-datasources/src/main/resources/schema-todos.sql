CREATE TABLE IF NOT EXISTS todos (
  id        bigint       NOT NULL,
  title     VARCHAR(256) NOT NULL,
  completed boolean      NOT NULL,
  PRIMARY KEY(id)
);