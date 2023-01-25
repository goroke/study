import random


def calc_fee(ages) -> dict:
    """
    요금 계산
    :param ages: 입장 인원 나이의 리스트
    :return: (성인 인원, 아동 인원, 지불할 금액)
    """
    fee = adults = kids = 0
    for age in ages:
        if age >= 19:
            fee += 10000
            adults += 1
        else:
            fee += 3000
            kids += 1

    return {'adults': adults, 'kids': kids, 'total': len(ages), 'fee': fee}


visitor_cnt = int(input('입장 인원은 몇 명인가요? '))
visitor_ages = [random.randint(1, 60) for i in range(visitor_cnt)]

entrance_info = calc_fee(visitor_ages)
print(f"성인 {entrance_info['adults']:,}명, 아동 {entrance_info['kids']:,}명으로 "
      f"총 {entrance_info['total']:,}명 입장하십니다.\n"
      f"총 금액은 {entrance_info['fee']:,}원입니다.")
