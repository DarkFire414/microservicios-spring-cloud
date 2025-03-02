CREATE TABLE IF NOT EXISTS USERS
(
    USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
    CELL_PHONE VARCHAR(40),
    LAST_NAME VARCHAR(50),
    NAME VARCHAR(50)
);

INSERT INTO USERS (USER_ID, CELL_PHONE, LAST_NAME, NAME)
VALUES
    (1, '123-456-7890', 'Smith', 'John'),
    (2, '987-654-3210', 'Johnson', 'Emily'),
    (3, '555-555-5555', 'Williams', 'Michael'),
    (4, '111-222-3333', 'Davis', 'Jessica'),
    (5, '444-444-4444', 'Brown', 'Christopher');