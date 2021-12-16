--------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE PRI
START WITH 1 INCREMENT BY 1;

CREATE TABLE USER_KFC(USER_ID NUMBER DEFAULT PRI.NEXTVAL  ,
                        USER_NAME VARCHAR2(100)NOT NULL,MAIL_ID VARCHAR2(100)NOT NULL UNIQUE,
                        MOBILE_NUMBER NUMBER NOT NULL UNIQUE,PRIMARY KEY(USER_ID));
                        
                        
                        


DESC USER_KFC;
SELECT *FROM USER_KFC;
select * from user_kfc where mail_id='hari@gmail.com'and mobile_number=1234567898;
update  user_kfc set user_name='Vinoth' where user_id=2;
delete user_kfc where user_id=2;
insert into  user_kfc values(2,'Vinoth','vkaathi@gmail.com',1234567893);

--------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE PRO
START WITH 1 INCREMENT BY 1;

CREATE TABLE PRODUCTS_KFC(PRODUCT_ID NUMBER DEFAULT PRO.NEXTVAL PRIMARY KEY,PRODUCT_NAME VARCHAR2(100)NOT NULL,
                            DESCRIPTION VARCHAR2(100)NOT NULL,PRODUCT_PRICE NUMBER NOT NULL,PRODUCT_TYPE VARCHAR2(100)NOT NULL,
                            PRODUCT_STATUS VARCHAR2(100)NOT NULL);
                            
                            
DESC PRODUCTS_KFC;
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES();
--------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE ORD
START WITH 1 INCREMENT BY 1;

CREATE TABLE ORDER_KFC(CART_ID NUMBER DEFAULT ORD.NEXTVAL PRIMARY KEY,PRODUCT_ID NUMBER NOT NULL,USER_ID NUMBER NOT NULL,QUANTITY NUMBER ,TOTAL_PRICE NUMBER(8,2),
                        FOREIGN KEY (PRODUCT_ID)REFERENCES PRODUCTS_KFC(PRODUCT_ID),
                        FOREIGN KEY (USER_ID) REFERENCES USER_KFC (USER_ID));
                        
DESCRIBE ORDER_KFC;
--------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE INVOICE_KFC(INVOICE_ID NUMBER PRIMARY KEY,PRODUCT_ID NUMBER,USER_ID NUMBER,FINAL_PRICE NUMBER(8,2),
                           FOREIGN KEY (PRODUCT_ID)REFERENCES PRODUCTS_KFC(PRODUCT_ID),
                           FOREIGN KEY (USER_ID)REFERENCES USERS_KFC(USER_ID));
            
DESCRIBE INVOICE_KFC;
                        
                       