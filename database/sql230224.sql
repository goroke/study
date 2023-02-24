# - (all/distinct [entity]) 이런 식으로 쓴다. 릴레이션에 붙는 키워드 같음.
# all이 기본.

# - as: 테이블, 필드 뒤에 붙음
# select (column) as ~~~ from ~~~; as를 이용해서 필드의 별명을 정할 수 있다. 안 써도 된다.
# like ~~~

# - group by: select 연산 키워드
# group by a, b; (a, b) 가 같은 튜플들끼리 모아서 계산한다.
#   group by가 없으면 select 뒤에 오는 필드들은 테이블 전체 범위를 의미하지만, 있으면 그룹 내부를 의미한다.
#   group by a, b having ~~~; having 이하의 조건을 만족하는 것들만 모아서 계산한다.
# 여기에 where 는 쓸 수 없다. where 는 개별 데이터의 조건, having 은 데이터 집단의 조건이기 때문.

# - order by: select 연산 키워드
# order by (asc/desc) 아무것도 적지 않으면 asc 취급. 
# select [ *이 부분 ] from ~~~~~ where ~~~~; 이 부분에 통계 수식(count, sum, avg, max, min, ...) 을 쓸 수 있다.

# - join: 테이블 간 연산자
# join을 수행하는 속도는 inner join이 가장 빠르다고 한다.

SELECT   제품명, 재고량, 단가, 재고량*단가 해쳐먹을수있는돈
FROM     제품
WHERE    제조업체 = '한빛제과';

SELECT   주문고객, 주문제품, 수량, 주문일자
FROM     주문
WHERE    주문고객 = 'apple' or 수량 >= 15;


#	[예제 7-22]
SELECT   고객이름, 나이, 등급, 적립금
FROM     고객
WHERE    고객이름 LIKE '김%';


#	[예제 7-23]
SELECT   고객아이디, 고객이름, 등급
FROM     고객
WHERE    고객아이디 LIKE '_____'; # 5글자의 데이터를 찾는다.


#	[예제 7-24]
SELECT   고객이름
FROM     고객
WHERE    나이 IS NULL;


#	[예제 7-25]
SELECT   고객이름
FROM     고객
WHERE    나이 IS NOT NULL;


#	[예제 7-26]
SELECT   고객이름, 등급, 나이
FROM     고객
ORDER BY   나이  DESC;


#	[예제 7-27]
SELECT  주문고객, 주문제품, 수량, 주문일자
FROM    주문
WHERE   수량 >= 10
ORDER BY  주문제품 ASC, 수량 DESC;


#   [예제 7-28]
select avg(단가) from 제품;


#   [예제 7-29]
select sum(재고량) '재고량 합계' from 제품 where 제조업체='한빛제과';
select 재고량 '재고량 합계' from 제품;


#   [예제 7-30]
select count(*) "고객 수" from 고객;  # 행 개수만 읽으므로 탐색 속도가 빠르다.
select count(고객아이디) "고객 수" from 고객;  # 기본 키는 null이 없으므로 카디널리티가 나온다.


#   [예제 7-31]
select count(distinct 제조업체) as '제조업체 수' from 제품;


#   [예제 7-32]
select 주문제품, sum(수량) as 총주문수량
from 주문
group by 주문제품;


#   [예제 7-33, 7-34]
select 제조업체, count(*) as 제품수, max(단가) 최고가
from 제품
group by 제조업체
having count(*) >= 3;
# 제조업체가 만든 제품 수와 제일 비싼 제품의 단가


#   [예제 7-35]
select 등급, count(*) "고객 수", avg(적립금) "평균 적립금" from 고객 group by 등급
having avg(적립금) >= 1000;


#	[예제 7-36]
SELECT   주문제품, 주문고객, SUM(수량) AS 총주문수량, count(*) AS 주문건수
FROM     주문
GROUP BY  주문제품, 주문고객;


#   그냥 혼자 연습
# left join: 주문 테이블은 가만히 있고, 오른쪽에 제품번호에 대한 정보가 붙는다.
select count(*) from 주문 left join 제품 on 주문.주문제품 = 제품.제품번호;
# right join: 주문 테이블은 가만히 있고, 왼쪽에 제품번호에 대한 정보가 붙는다.
select count(*) from 제품 right join 주문 on 주문.주문제품 = 제품.제품번호;


SELECT   제품명, 주문고객, SUM(수량) AS 총주문수량
FROM     주문 left join 제품 on 주문.주문제품 = 제품.제품번호
GROUP BY  주문제품, 주문고객;


#	[예제 7-37]
select 제품명 from 주문 left join 제품 on 주문.주문제품=제품.제품번호 where 주문고객='banana';
select * from 주문 inner join 제품;


#	[예제 7-38]
select 주문.주문제품, 주문.주문일자 from 고객, 주문
where 고객.나이 >= 30 and 주문.주문고객 = 고객.고객아이디;


#	[예제 7-39]
select p.제품명 from 제품 p, 고객 c, 주문 o
where c.고객이름 = '고명석' and c.고객아이디 = o.주문고객 and p.제품번호 = o.주문제품;


#	[예제 7-45] 혼자 해본 것
# 2022.3.15 주문한 사람
select distinct 고객.고객이름 from 고객, 주문
where 주문.주문일자 = '2022-3-15' and 고객.고객아이디 = 주문.주문고객;


# 주문 안 한 고객 찾기
select 고객이름 from 고객 where 고객아이디 not in (select 주문고객 from 주문);
