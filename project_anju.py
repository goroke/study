import random

# 술안주
sul_anju = {'맥주': '치킨',
            '소주': '골뱅이 소면',
            '와인': '치즈',
            '고량주': '짬뽕',
            '맹물': '공기밥'}

sul_anju = dict(맥주='치킨', 소주='골뱅이 소면', 와인='치즈', 고량주='짬뽕')

suls = list(sul_anju)
anjus = list(sul_anju.values())

# 입력 가능 범위
numbers = [str(i) for i in range(1, len(suls)+1)]
ordered = False

while True:
    print('술을 선택하세요. ', end='')
    for i in range(len(suls)+2):
        print(f'{i+1})' + (suls + ['아무거나', '계산'])[i], end=' ')

    order = input(': ')

    # 계산
    if order == str(len(suls)+2):
        if ordered:
            print('돈내놔')
        else:
            print('아무것도 안 시켰잖아요')
        break

    # 아무거나
    elif order == str(len(suls)+1):
        sul = random.choice(suls)
        anju = random.choice(anjus)
        print(f'→ 추천 주류: {sul}\n'
              f'  추천 요리: {anju}\n그냥 주는 대로 드세요.')

        ordered = True

    # 메뉴 선택
    elif order in numbers:
        order = int(order) - 1
        sul = suls[order]
        print(f'{sul}에 어울리는 안주는 {sul_anju[sul]}입니다.')

        ordered = True

    else:
        print('뭐야 제대로 입력하세요')

    print()
