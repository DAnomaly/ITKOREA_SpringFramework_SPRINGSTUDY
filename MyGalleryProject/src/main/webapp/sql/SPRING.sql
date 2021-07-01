DROP TABLE BOARD;
DROP TABLE GALLERY_COM;
DROP TABLE GALLERY;
DROP TABLE MEMBER;

DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE GALLERY_SEQ;
DROP SEQUENCE GALLERY_COM_SEQ;
DROP SEQUENCE BOARD_SEQ;

CREATE TABLE MEMBER(
    MEMBER_NO NUMBER PRIMARY KEY,
    ID VARCHAR2(32) UNIQUE NOT NULL,
    PW VARCHAR2(64) NOT NULL,
    NAME VARCHAR2(16),
    TEL VARCHAR2(14) UNIQUE NOT NULL,
    EMAIL VARCHAR2(64) UNIQUE NOT NULL,
    ADDRESS VARCHAR2(128),
    REGDATE DATE,
    STATE NUMBER(1)
);

CREATE TABLE GALLERY(
    GALLERY_NO NUMBER PRIMARY KEY,
    ID VARCHAR2(32) NOT NULL,
    TITLE VARCHAR2(300) NOT NULL,
    CONTENT VARCHAR2(4000),
    POSTDATE DATE,
    LASTMODIFY DATE,
    IP VARCHAR2(100),
    HIT NUMBER,
    IMAGE VARCHAR2(300),
    STATE NUMBER(1)
);
ALTER TABLE GALLERY ADD CONSTRAINT GALLERY_MEMBER_FK FOREIGN KEY(ID) REFERENCES MEMBER(ID);

CREATE TABLE GALLERY_COM(
    GALLERY_COM_NO NUMBER PRIMARY KEY,
    GALLERY_NO NUMBER NOT NULL,
    ID VARCHAR2(32) NOT NULL,
    CONTENT VARCHAR2(4000),
    POSTDATE DATE,
    IP VARCHAR2(100)
);
ALTER TABLE GALLERY_COM ADD CONSTRAINT GALLERY_COM_MEMBER_FK FOREIGN KEY(ID) REFERENCES MEMBER(ID);
ALTER TABLE GALLERY_COM ADD CONSTRAINT GALLERY_COM_GALLERY_FK FOREIGN KEY(GALLERY_NO) REFERENCES GALLERY(GALLERY_NO);

CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    ID VARCHAR2(32) NOT NULL,
    CONTENT VARCHAR2(2000),
    POSTDATE DATE,
    IP VARCHAR2(100),
    STATE NUMBER(1),
    GROUPNO NUMBER,
    GROUPORD NUMBER(3),
    DEPTH NUMBER(2)
);
ALTER TABLE BOARD ADD CONSTRAINT BOARD_MEMBER_FK FOREIGN KEY(ID) REFERENCES MEMBER(ID);

CREATE SEQUENCE MEMBER_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE GALLERY_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE GALLERY_COM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
