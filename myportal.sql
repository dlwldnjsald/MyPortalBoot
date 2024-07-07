CREATE TABLE himedia.users(
	no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(20) NOT NULL,
    gender VARCHAR(5) NOT NULL,
    join_date timestamp DEFAULT NOW()
);


CREATE TABLE himedia.guestbook(
	no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    password VARCHAR(20),
    content VARCHAR(600),
    reg_date timestamp DEFAULT NOW()
);

CREATE TABLE himedia.board(
	no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    content VARCHAR(600),
    hit INT DEFAULT 0,
    reg_date TIMESTAMP DEFAULT NOW(),
    user_no INT,
    user_name VARCHAR(20)
);

CREATE TABLE himedia.file(
	no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE himedia.board_files_bridge(
	board_no INT,
    file_no INT,
    PRIMARY KEY(board_no, file_no)
);

