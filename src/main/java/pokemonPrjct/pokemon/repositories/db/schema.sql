CREATE TABLE pokemon (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  appearance VARCHAR(255),
  type VARCHAR(50),
  size ENUM('small', 'normal', 'large') DEFAULT 'normal',
  hp INT NOT NULL,
  attack INT NOT NULL,
  defense INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE player (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  crystals INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

CREATE TABLE pokemon_player (
  id INT NOT NULL AUTO_INCREMENT,
  pokemon_id INT NOT NULL,
  player_id INT NOT NULL,
  current_health_points INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pokemon_id) REFERENCES pokemon (id),
  FOREIGN KEY (player_id) REFERENCES player (id)
);
