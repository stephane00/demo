CREATE TABLE users(
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities(
  username VARCHAR(50) PRIMARY KEY,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);