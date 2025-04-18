CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(30) NOT NULL UNIQUE,
  salt VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  first_name VARCHAR(50),
  last_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS notes (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100),
  description TEXT,
  user_id INT NOT NULL REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS files (
  id SERIAL PRIMARY KEY,
  filename VARCHAR(255) NOT NULL,
  type VARCHAR(100),
  size VARCHAR(20),
  data BYTEA NOT NULL,
  user_id INT NOT NULL REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS credentials (
  id SERIAL PRIMARY KEY,
  url VARCHAR(2083),
  username VARCHAR(100) NOT NULL,
  key VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  user_id INT NOT NULL REFERENCES users(id)
);
