CREATE TABLE notes (
                       id BIGINT PRIMARY KEY AUTOINCREMENT,
                       content TEXT NOT NULL,
                       user_id BIGINT NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);
