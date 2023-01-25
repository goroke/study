try:
    expr = [int(i) for i in input('분자 분모 입력: ').split()]
    if len(expr) > 2:
        raise IndexError

    print(expr[0] / expr[1])

except ZeroDivisionError as err:
    print('분모에 0이 올 수 없습니다')

except ValueError as err:
    print('뭘 넣은 거에요')

except IndexError:
    print('두 개 입력하세요 인간아')

except Exception as err:
    print('알 수 없는 에러가 발생하셨습니다. (%s)' % err)
