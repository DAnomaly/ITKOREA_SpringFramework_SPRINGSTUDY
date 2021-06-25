DROP TABLE MEMBER;
DROP SEQUENCE MEMBER_SEQ;

CREATE TABLE MEMBER(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(32) NOT NULL UNIQUE,
	PW VARCHAR2(64) NOT NULL, -- 암호화된 비밀번호 64바이트
	NAME VARCHAR2(64),
	EMAIL VARCHAR2(100) NOT NULL UNIQUE,
	REGDATE DATE
);

CREATE SEQUENCE MEMBER_SEQ START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE;