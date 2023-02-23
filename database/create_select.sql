# -- DDL --

# 데이터베이스 생성
create database malldb;

# 데이터베이스 안에 테이블(=릴레이션=엔티티) 생성
# 활성화된 데이터베이스가 없는 상태로는 실행할 수 없다.
use malldb;

# 테이블 생성 구문
create table userTbl	# 테이블명
(userID    char(8)     not null primary key,
 userName  varchar(10) not null, # 그냥 char 타입은 고정 길이 문자열
 birthYear int         not null,
 addr      char(2)     not null,
 mobile1   char(3)     not null,
 mobile2   char(8)     not null,
 height    smallint, # 2바이트 정수 타입 (-32768 ~ 32767)
 mDate     date
);

drop table userTbl;  # 이러면 삭제된다.


# DML
insert
into userTBL
values('LSG', '이승기', 1967, '서울', '011', '11111111', 182, '2008-8-8'),
      ('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4'),
      ('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7'),
      ('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-4-4'),
      ('SSK', '성시경', 1979, '서울', '010', '12345678', 186, '2013-12-12'),
      ('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-9-9'),
      ('YJS', '윤종신', 1969, '경남', '010', '12345678', 170, '2005-5-5'),
      ('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-3-3'),
      ('JKW', '조관우', 1965, '경기', '018', '99999999', 172, '2010-10-10'),
      ('BBK', '비비킴', 1973, '서울', '010', '00000000', 176, '2013-5-5');


update userTBL
set height=182, mdate='2008-8-8' where userid='LSG';

select userid from usertbl;

select * from usertbl;

create table buyTbl
(num       int auto_increment # 자동으로 1씩 증가
           not null primary key,
 userID    char(8),
 foreign key (userID) references usertbl(userID),
 prodName  char(6)  not null,
 groupName char(4)  not null,
 price     int      not null,
 amount    smallint not null
);

drop table buytbl;
commit;

alter table buytbl drop amount;
alter table buytbl add (price int not null,
						amount smallint not null);
alter table buytbl modify groupName char(4);	# 괄호 쓰면 안 됨



insert into buyTbl values
(NULL, 'KBS', '운동화', NULL, 30, 2),
(NULL, 'KBS', '노트북', '전자', 1000, 1),
(NULL, 'JYP', '모니터', '전자', 200, 1),
(NULL, 'BBK', '모니터', '전자', 200, 5),
(NULL, 'KBS', '청바지', '의류', 50, 3),
(NULL, 'BBK', '메모리', '전자', 80, 10),
(NULL, 'SSK', '책', '서적', 15, 5),
(NULL, 'EJW', '책', '서적', 15, 2),
(NULL, 'EJW', '청바지', '의류', 50, 1),
(NULL, 'BBK', '운동화', NULL, 30, 2),
(NULL, 'EJW', '책', '서적', 15, 1),
(NULL, 'BBK', '운동화', NULL, 30, 2);

commit;

select * from buytbl;