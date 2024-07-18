INSERT INTO SCHOOLS(id, school_name, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(0, 'admin用',  'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SCHOOLS(id, school_name, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SCHOOL_SEQ", '志水小学校',  'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SCHOOLS(id, school_name, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SCHOOL_SEQ", '志水中学校',  'FLAG_OFF', 0, now(), 0, now());

INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu', 'shimizu', 2, '$2a$10$vCTrN8/kF64repdPVlwM9Oz4K7ccRwkm54YKGeiiD1O0FBFiEX9Qi', 1, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu2', 'shimizu2', 1, '$2a$10$MH4auepNWwZsQoXpz98gbOuYzrHg2IRgJEeGUPACngpMEiBsaD/5W', 0, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu3', 'shimizu3', 2, '$2a$10$F3EFDR7FnAULJq0ps5iTYezEZr.b/r/.DbZAM5yOiGVcrLYD9ZcKW', 2, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SITE_USERS(id, login_id, user_name, authority, password, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SITE_USER_SEQ", 'ry-shimizu4', 'shimizu4', 3, '$2a$10$tCCOZlpxPtS2327Z3/AuJOLB588bHPpO8OFfcsbNpuYuQXEdiYWeC', 1, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO CLASSES(id, class_name, title, class_year, seat_start_point, site_user_id, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "CLASS_SEQ", '3-1', 'My class1', 2023, 1, 1, 1, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO CLASSES(id, class_name, title, class_year, seat_start_point, site_user_id, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "CLASS_SEQ", '5-2', 'class2', 2024, 2, 2, 0, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO CLASSES(id, class_name, title, class_year, seat_start_point, site_user_id, school_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "CLASS_SEQ", '5-3', 'class3', 2024, 2, 3, 2, 'FLAG_OFF', 0, now(), 0, now());

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

INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 11, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 12, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 13, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 21, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 22, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 23, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 31, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 32, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 33, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 41, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO SEATS(id, seat_number, class_id, empty_seat_flg, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "SEAT_SEQ", 42, 3, 'FLAG_OFF', 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '志水', 1, 1, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 早', 2, 2, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '浅田', 1, 3, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '清宮', 1, 4, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '坂本', 1, 5, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '多々良', 1, 6, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '倉莉瀬', 2, 7, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", 'バーランダー', 2, 8, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '南野', 1, 9, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村(翔)', 1, 10, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", NULL, 3, 11, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO OTHER_CLASSES(id, site_user_id, class_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "OTHER_CLASS_SEQ", 2, 1, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '志水', 1, 12, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村(早)', 2, 13, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '浅田大根', 1, 14, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '清宮', 1, 15, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '坂本', 1, 16, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '多々良', 1, 17, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '倉莉瀬', 2, 18, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", 'バーランダー', 2, 19, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '南野', 1, 20, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 翔', 1, 21, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '高橋', 2, 22, 'FLAG_OFF', 0, now(), 0, now());

INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '志水', 1, 23, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村(早)', 2, 24, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '浅田大根', 1, 25, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '清宮', 1, 26, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '坂本', 1, 27, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '多々良', 1, 28, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '倉莉瀬', 2, 29, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", 'バーランダー', 2, 30, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '南野', 1, 31, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '中村 翔', 1, 32, 'FLAG_OFF', 0, now(), 0, now());
INSERT INTO STUDENTS(id, student_name, sex_type, seat_id, delete_flg, created_by, created_dt, updated_by, updated_dt) VALUES(NEXT VALUE FOR "STUDENT_SEQ", '高橋', 2, 33, 'FLAG_OFF', 0, now(), 0, now());