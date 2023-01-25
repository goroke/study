# set (dict에서 key만 남은 형태)

# 8.2.1 Set 만들기: set(). ( {} 이렇게 하면 안 된다. dict가 생기기 때문 )
drinks = {
    'martini': {'vodka', 'vermouth'},
    'black russian': {'vodka', 'kahlua'},
    'white russian': {'cream', 'kahlua', 'vodka'},
    'manhattan': {'rye', 'vermouth', 'bitters'},
    'screwdriver': {'orange juice', 'vodka'}
}

# 8.2.2 set(str), set(list), set(dict)

# 8.2.3 원소의 개수: len(set)

# 8.2.4 add('값')
# 8.2.5 remove('값') - 순서가 없어서 '마지막' 원소나 '몇 번째' 원소의 개념은 없다.

# 8.2.6 for x in set~~: ← 작동은 하지만, 순서는 어떻게 나올지 알 수 없다.

# 8.2.7 x in set → x ∈ set

# 8.2.8
# 교집합(& / intersection), 합집합(| / union), 차집합(- / difference) 등등..
# 대칭차집합(^ / symmetric_difference), 부분집합(<= / is_subset or >= / is_superset), 진부분집합(<)
print({1, 2, 3} | {2, 3, 4})

# 8.2.9 comprehension

# 8.2.10 frozenset

# 9


def is_prime(N):
    if N == 1:
        return False

    for n in range(2, int(N**.5)+2):
        if not N%n:
            return False

    return True


print(is_prime(1))

# buggy
# 함수가 정의됨과 동시에 주소가 저장된다고 생각하면 되는가?..


def calc_fee(*ages):
    """
    요금 계산
    :param ages: 나이
    :return: 지불할 금액
    """
    fee = 0
    for age in ages:
        if age >= 19:
            fee += 10000
        else:
            fee += 3000
    return fee


print(calc_fee(45, 43, 10, 7))


def search(kwd='a', **database):
    #    kwd = input()
    if kwd in database:
        print(database[kwd])
    else:
        print('not found')


search('a', a=100, b=200)


# 데커레이터(함수 → 함수): 말 그대로 함수를 받아서 다른 함수로 바꿔주는 함수.)
# 함수 위에 데커레이터를 박으면 자동적으로 데커레이터에 들어갔다 나온 상태가 된다.
# 기존 함수에 추가적인 행동을 더 해줄 수 있다. (매개 변수/리턴 값들 모두 제어당한다

def print_args(func):
    def inner_print_args_func(*a):
        print(a)
        return func(*a)
    return inner_print_args_func


@print_args
def plus_one(x):
    print("I'm here")
    return x+1

print(plus_one(100))
