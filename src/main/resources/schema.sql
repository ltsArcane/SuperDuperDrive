CREATE TABLE IF NOT EXISTS USERS (
id serial PRIMARY KEY,
username VARCHAR(20) UNIQUE,
salt VARCHAR,
password VARCHAR,
firstname VARCHAR(20),
lastname VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS NOTES (
  id serial PRIMARY KEY,
  title VARCHAR(20),
  content VARCHAR (1000),
  userid INT,
  foreign key (userid) references USERS(id)
);

CREATE TABLE IF NOT EXISTS FILES (
  id serial PRIMARY KEY,
  name VARCHAR,
  type VARCHAR,
  size VARCHAR,
  data BYTEA,
  userid INT,
  foreign key (userid) references USERS(id)
);

CREATE TABLE IF NOT EXISTS CREDENTIALS (
  id SERIAL PRIMARY KEY,
  url VARCHAR,
  username VARCHAR,
  key VARCHAR,
  password VARCHAR,
  userid INT,
  FOREIGN KEY (userid) REFERENCES USERS(id)
);
