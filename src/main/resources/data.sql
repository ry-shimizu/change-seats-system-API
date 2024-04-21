INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu', 'shimizu', 2, 'password', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu2', 'shimizu2', 1, 'password2', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu3', 'shimizu3', 2, 'password3', 1, 0, now(), 0, now());

INSERT INTO CLASSES(id, class_name, title, class_year, seat_start_point, site_user_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "CLASS_SEQ", '3-1', 'My class1', 2023, 1, 1, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO CLASSES(id, class_name, title, class_year, seat_start_point, site_user_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "CLASS_SEQ", '5-2', 'My class2', 2024, 2, 1, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 11, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 12, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 13, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 21, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 22, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 23, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 31, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 32, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 33, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 41, 1, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 42, 1, 'FLAG_ON', 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 11, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 12, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 13, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 21, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 22, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 23, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 31, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 32, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 33, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 41, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 42, 2, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());


INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '志水', 1, 1, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 早', 2, 2, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '浅田', 1, 3, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '清宮', 1, 4, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '坂本', 1, 5, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '多々良', 1, 6, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '倉莉瀬', 2, 7, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", 'バーランダー', 2, 8, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '南野', 1, 9, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 翔', 1, 10, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", NULL, 3, 11, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO OTHER_CLASSES(id, site_user_id, class_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "OTHER_CLASS_SEQ", 1, 1, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '志水', 1, 12, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 早', 2, 13, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '浅田', 1, 14, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '清宮', 1, 15, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '坂本', 1, 16, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '多々良', 1, 17, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '倉莉瀬', 2, 18, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", 'バーランダー', 2, 19, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '南野', 1, 20, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 翔', 1, 21, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '高橋', 2, 22, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO OTHER_CLASSES(id, site_user_id, class_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "OTHER_CLASS_SEQ", 1, 2, 'FLAG_OFF', 0, now(), 0, now());
