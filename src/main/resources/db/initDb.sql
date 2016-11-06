-- создаем таблицу для работы режима remember-me
CREATE TABLE persistent_logins (
  username varchar(64) not null,
  series varchar(64) not null,
  token varchar(64) not null,
  last_used timestamp not null,
  PRIMARY KEY (series)
);
-- оздаем таблицу пользователей
CREATE TABLE users (
  id INTEGER PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  login VARCHAR(255),
  password VARCHAR(255)
);