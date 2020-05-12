DROP TABLE OFFERS;
DROP TABLE CAR;
DROP TABLE CUSTOMER;
DROP TABLE EMPLOYEE;


--TABLES
CREATE TABLE CAR(
CAR_ID INTEGER PRIMARY KEY,
MAKE VARCHAR2(50),
CAR_MODEL VARCHAR2(50),
COLOR VARCHAR2(50),
CAR_YEAR INTEGER,
CAR_COST NUMBER(*,2),
PURCHASE_STATUS VARCHAR(50) DEFAULT 'AVAILABLE',
CAR_OWNER VARCHAR(50)
);

CREATE TABLE CUSTOMER(
USERNAME VARCHAR2(50) PRIMARY KEY,
PASSWORD VARCHAR2(50),
FIRST_NAME VARCHAR2(50),
LAST_NAME VARCHAR2(50),
CREDIT_SCORE INTEGER
);

CREATE TABLE EMPLOYEE(
EMP_ID INTEGER PRIMARY KEY,
FIRST_NAME VARCHAR2(50),
LAST_NAME VARCHAR2(50)
);

CREATE TABLE OFFERS(
OFFER_ID INTEGER PRIMARY KEY,
USERNAME VARCHAR2(50),
CAR_ID INTEGER,
CAR_COST NUMBER(*,2),
DOWN_PMT NUMBER(*,2),
LOAN_LENGTH INTEGER,
LOAN_BALANCE NUMBER(*,2),
ANN_EFF_RATE NUMBER(*,2),
MTHLY_PMT NUMBER(*,2),
PMT_LEFT INTEGER,
OFFER_STATUS VARCHAR(50)
);

--CONSTRAINTS
ALTER TABLE OFFERS
ADD CONSTRAINT FK_OFFERS_CUSTOMER
FOREIGN KEY (USERNAME) REFERENCES CUSTOMER(USERNAME);

ALTER TABLE OFFERS
ADD CONSTRAINT FK2_OFFERS_CAR
FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID);

--SEQUENCES
CREATE SEQUENCE MYSEQ;
CREATE SEQUENCE MYSEQ2;
UPDATE OFFERS SET OFFER_ID = MYSEQ.NEXTVAL;
UPDATE OFFERS SET CAR_ID = MYSEQ2.NEXTVAL;

--PROCEDURES
CREATE OR REPLACE PROCEDURE NEWCARACCEPTED 
(USERN IN VARCHAR2, CID IN INTEGER)
AS
BEGIN
UPDATE CAR SET CAR_OWNER = USERN WHERE CAR_ID = CID;
UPDATE CAR SET PURCHASE_STATUS = 'Unavailable' WHERE CAR_ID = CID;
UPDATE OFFERS SET OFFER_STATUS = 'Accepted' WHERE USERNAME = USERN AND CAR_ID = CID;
DELETE FROM OFFERS WHERE CAR_ID = CID AND USERNAME != USERN;
COMMIT;
END;
/


-----------------------------------------------
