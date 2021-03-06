DROP TABLE MEMBER;
DROP SEQUENCE MEMBER_SEQ;

CREATE TABLE MEMBER(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(32) NOT NULL UNIQUE,
	NAME VARCHAR2(64),
	ADDRESS VARCHAR2(100),
	GENDER VARCHAR2(10),
	REGDATE DATE
);

CREATE SEQUENCE MEMBER_SEQ START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE;