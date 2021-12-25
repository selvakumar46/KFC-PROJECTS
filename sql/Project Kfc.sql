--------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE PRI
START WITH 1 INCREMENT BY 1;

CREATE TABLE USER_KFC(USER_ID NUMBER DEFAULT PRI.NEXTVAL  ,
                        USER_NAME VARCHAR2(100)NOT NULL,MAIL_ID VARCHAR2(100)NOT NULL UNIQUE,
                        MOBILE_NUMBER NUMBER NOT NULL UNIQUE,PRIMARY KEY(USER_ID));
                        

DESC USER_KFC;
SELECT *FROM USER_KFC;
insert into user_kfc (user_name,mail_id,mobile_number) values ('kumar','kumar@gmail.com',6705347898);
--select * from user_kfc where mail_id='hari@gmail.com'and mobile_number=1234567898;
--update  user_kfc set user_name='Vinoth' where user_id=2;
--delete user_kfc where user_id=2;
--insert into  user_kfc values(2,'Vinoth','vkaathi@gmail.com',1234567893);
update user_kfc set mail_id='' where mobile_number=?;

--------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE PRO
START WITH 1 INCREMENT BY 1;

CREATE TABLE PRODUCTS_KFC(PRODUCT_ID NUMBER DEFAULT PRO.NEXTVAL PRIMARY KEY,PRODUCT_NAME VARCHAR2(100)NOT NULL,
                            DESCRIPTION VARCHAR2(100)NOT NULL,PRODUCT_PRICE NUMBER NOT NULL,PRODUCT_TYPE VARCHAR2(100)NOT NULL,
                            PRODUCT_STATUS VARCHAR2(100)NOT NULL);
                            
                            
DESC PRODUCTS_KFC;
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Stay Home Bucket','Enjoy 4pc of crispty and more',749,'non-veg','Available');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Family Feast','chicken, Medium Popcorn and 1 btle pepsi',789,'non-veg','Availabe');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('5pc Smoky Red','Red Grilled Chicken',429,'non-veg','Sold Out');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Super Snacker Combo','med Popcorn,4 Strips,1 chilled Pepsi',429,'non-veg','Available');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Classic Zinger Meal','Zinger Burger,Medium fries,1 chilled Pepsi',319,'non-veg','Sold Out');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('2 Classic Veg Krispers','delicious veg Value Burgers',138,'veg','Available');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Veg-Non-Veg Krispers Combo','2 veg ,2 Non-veg burgers',349,'non-veg','Available');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Pepsi ','330ml Can',60,'veg','Available');
INSERT INTO PRODUCTS_KFC (PRODUCT_NAME,DESCRIPTION,PRODUCT_PRICE,PRODUCT_TYPE,PRODUCT_STATUS)VALUES('Red Bull','Energy Drink',160,'veg','Available');

update  products_kfc set product_name='Pepsi' where product_id=8;

select * from products_kfc where product_name='Red Bull';
commit;
select * from products_kfc;
select * from products_kfc where product_status='Available';
--------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE ORD
START WITH 1 INCREMENT BY 1;

CREATE TABLE ORDER_KFC(CART_ID NUMBER DEFAULT ORD.NEXTVAL PRIMARY KEY,PRODUCT_ID NUMBER NOT NULL,USER_ID NUMBER NOT NULL,QUANTITY NUMBER ,TOTAL_PRICE NUMBER(8,2),
                        FOREIGN KEY (PRODUCT_ID)REFERENCES PRODUCTS_KFC(PRODUCT_ID),
                        FOREIGN KEY (USER_ID) REFERENCES USER_KFC (USER_ID));
                        
DESCRIBE ORDER_KFC;
select * from order_kfc;
select * from products_kfc where product_name='Pepsi ';
delete  from user_kfc where user_id=22;
--------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE INVOICE_KFC(INVOICE_ID NUMBER PRIMARY KEY,PRODUCT_ID NUMBER,USER_ID NUMBER,FINAL_PRICE NUMBER(8,2),
                           FOREIGN KEY (PRODUCT_ID)REFERENCES PRODUCTS_KFC(PRODUCT_ID),
                           FOREIGN KEY (USER_ID)REFERENCES USERS_KFC(USER_ID));
            
DESCRIBE INVOICE_KFC;
                        
select pr.product_name,ord.quantity,ord.total_price from products_kfc pr inner join order_kfc ord on ord.product_id=pr.product_id where user_id=69; 
--------------------------------------------------------------------------------------------------------------------------------


create table admin_kfc (amin_name varchar2(100) not null,mail_id varchar2(100)unique not null,mobile_number number(10)unique not null);

insert into admin_kfc values('Ganesh','ganesh@gmail.com',1);

select * from admin_kfc;
--------------------------------------------------------------------------------------------------------------------------------
create sequence ord_item
start with 1 increment by 1;

create table invoice_kfc(invoice_id number default ord_item.nextval primary key,product_id number,user_id number,Quantity number,total_price number(8,2),
                       delivery_adress varchar2(200) ,order_date date default sysdate);
select * from invoice_kfc;           
--------------------------------------------------------------------------------------------------------------------------------
desc invoice_kfc;
drop table order_items_kfc;
select * from order_kfc where user_id=24;
select * from order_kfc where user_id=70;
update order_kfc set Quantity=9 where user_id=81;
update order_kfc set Quantity=3, total_price=500  where user_id=24 and product_id=8;
--------------------------------------------------------------------------------------------------------------------------------
create sequence cart_id
start with 1 increment by 1;
create table cart_items (cart_id number default cart_id.nextval primary key,product_id number,user_id number,product_name varchar2(100),quantity number,
                        total_Price number ,status varchar2(100) default 'Ordered',order_date date default sysdate,
                        foreign key (product_id)references products_kfc(product_id),
                        foreign key (user_id)references user_kfc(user_id));
                        
desc cart_items;
select * from cart_items;

update  cart_items  set status='delevered' where user_id=24;
select * from cart_items where status='Ordered';
commit;