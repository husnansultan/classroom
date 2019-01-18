INSERT INTO CLASSROOM (classroom_ID, trainer, trainee_ID) VALUES ('1', 'Johny Boy', '1');
INSERT INTO TRAINEE (trainee_ID, traineeName, classroom_ID) VALUES ('1', 'Katrina Kootz', '1');
INSERT INTO TRAINEE (trainee_ID, traineeName, classroom_ID) VALUES ('2', 'Katrina Kootz', '1');
INSERT INTO TRAINEE (trainee_ID, traineeName, classroom_ID) VALUES ('3', 'Katrina Kootz', '1');

SELECT *
  FROM CLASSROOM c JOIN TRAINEE t 
    ON c.classroom_ID = t.classroom_ID
ORDER BY c.trainer;
