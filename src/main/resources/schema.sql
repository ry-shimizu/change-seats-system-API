-- User
DROP ALL OBJECTS;

CREATE SEQUENCE school_seq;
CREATE SEQUENCE site_user_seq;
CREATE SEQUENCE class_seq;
CREATE SEQUENCE seat_seq;
CREATE SEQUENCE other_class_seq;
CREATE SEQUENCE student_seq;

CREATE TYPE AUTHORITY AS ENUM ('ADMIN', 'GENERAL','SCHOOL_ADMIN');
CREATE TYPE SEXTYPE AS ENUM ('MAN', 'WOMAN', 'OTHER');
CREATE TYPE FLAGTYPE AS ENUM ('FLAG_ON', 'FLAG_OFF');
CREATE TYPE SEATSTARTPOINT AS ENUM ('RIGHT', 'LEFT');

CREATE TABLE IF NOT EXISTS SCHOOLS(
    id INT NOT NULL PRIMARY KEY,
	school_name VARCHAR(40) NOT NULL,
	delete_flg FLAGTYPE NOT NULL,
	created_by INT NOT NULL,
	created_dt TIMESTAMP(0) NOT NULL,
	updated_by INT NOT NULL,
    updated_dt TIMESTAMP(0) NOT NULL
);

CREATE TABLE IF NOT EXISTS SITE_USERS(
    id INT NOT NULL PRIMARY KEY,
	login_id VARCHAR(30) NOT NULL,
	user_name VARCHAR(40) NOT NULL,
	authority AUTHORITY NOT NULL,
	password VARCHAR(255) NOT NULL,
	school_id INT NOT NULL,
	delete_flg FLAGTYPE NOT NULL,
	created_by INT NOT NULL,
	created_dt TIMESTAMP(0) NOT NULL,
	updated_by INT NOT NULL,
    updated_dt TIMESTAMP(0) NOT NULL,
    FOREIGN KEY (school_id) REFERENCES SCHOOLS(id)
);

CREATE TABLE IF NOT EXISTS CLASSES(
    id INT NOT NULL PRIMARY KEY,
    class_name VARCHAR(5) NOT NULL,
    title VARCHAR(15) NOT NULL,
    class_year SMALLINT NOT NULL,
    seat_start_point SEATSTARTPOINT NOT NULL,
    site_user_id INT NOT NULL,
    school_id INT NOT NULL,
	delete_flg FLAGTYPE NOT NULL,
	created_by INT NOT NULL,
	created_dt TIMESTAMP(0) NOT NULL,
	updated_by INT NOT NULL,
    updated_dt TIMESTAMP(0) NOT NULL,
    FOREIGN KEY (site_user_id) REFERENCES SITE_USERS(id),
    FOREIGN KEY (school_id) REFERENCES SCHOOLS(id)
);

CREATE TABLE IF NOT EXISTS OTHER_CLASSES(
    id INT NOT NULL PRIMARY KEY,
    site_user_id INT NOT NULL,
    class_id INT NOT NULL,
	delete_flg FLAGTYPE NOT NULL,
	created_by INT NOT NULL,
	created_dt TIMESTAMP(0) NOT NULL,
	updated_by INT NOT NULL,
    updated_dt TIMESTAMP(0) NOT NULL,
    FOREIGN KEY (site_user_id) REFERENCES SITE_USERS(id),
    FOREIGN KEY (class_id) REFERENCES CLASSES(id)
);

CREATE TABLE IF NOT EXISTS SEATS(
    id INT NOT NULL PRIMARY KEY,
    seat_number SMALLINT NOT NULL,
    class_id INT NOT NULL,
    empty_seat_flg FLAGTYPE NOT NULL,
	delete_flg FLAGTYPE NOT NULL,
	created_by INT NOT NULL,
	created_dt TIMESTAMP(0) NOT NULL,
	updated_by INT NOT NULL,
    updated_dt TIMESTAMP(0) NOT NULL,
    FOREIGN KEY (class_id) REFERENCES CLASSES(id)
);

CREATE TABLE IF NOT EXISTS STUDENTS(
    id INT NOT NULL PRIMARY KEY,
    student_name VARCHAR(6),
    sex_type SEXTYPE NOT NULL,
    seat_id INT NOT NULL,
	delete_flg FLAGTYPE NOT NULL,
	created_by INT NOT NULL,
	created_dt TIMESTAMP(0) NOT NULL,
	updated_by INT NOT NULL,
    updated_dt TIMESTAMP(0) NOT NULL,
    FOREIGN KEY (seat_id) REFERENCES SEATS(id)
);