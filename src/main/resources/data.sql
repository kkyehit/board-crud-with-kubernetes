DROP TABLE IF EXISTS boards_tb;

CREATE TABLE boards_tb (
  board_id INT AUTO_INCREMENT PRIMARY KEY,
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  title varchar(20),
  author_name varchar(20),
  content varchar(100)
);