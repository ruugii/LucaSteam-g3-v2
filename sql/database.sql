
CREATE TABLE publisher (
    id_publisher BIGINT PRIMARY KEY AUTO_INCREMENT,
    publisher_name VARCHAR(255) NOT NULL
);

CREATE TABLE genre (
    id_genre BIGINT PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(255) NOT NULL
);

CREATE TABLE platform (
    id_platform BIGINT PRIMARY KEY AUTO_INCREMENT,
    platform_name VARCHAR(255) NOT NULL
);

CREATE TABLE game (
    id_game BIGINT PRIMARY KEY AUTO_INCREMENT,
    game_name VARCHAR(255) NOT NULL,
    year int,
    sales BIGINT,
    id_platform BIGINT,
    id_genre BIGINT,
    id_publisher BIGINT,
    FOREIGN KEY (id_platform) REFERENCES platform(id_platform),
    FOREIGN KEY (id_genre) REFERENCES genre(id_genre),
    FOREIGN KEY (id_publisher) REFERENCES publisher(id_publisher)
)
