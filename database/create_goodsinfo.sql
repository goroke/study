create  database malldb ;
show databases;
desc goodsinfo;
use malldb;
create table goodsinfo (
code char(5) not null,
name varchar(30) not null,
price int(8) not null,
maker varchar(2), primary key(code) ) ;

show tables;
desc goodsinfo;
insert into goodsinfo(code, name, price,maker) values('10001' , '디지털TV', 350000, 'LG');
insert into goodsinfo(code, name, price,maker) values('10002' , '냉장고'  , 470000, 'SS');
insert into goodsinfo(code, name, price,maker) values('10003' , '에어컨'  , 270000, 'DW');

SELECT * FROM goodsinfo;

SELECT * FROM malldb.goodsinfo;
select name, price from goodsinfo;

select * from goodsinfo where price > 300000 ;
