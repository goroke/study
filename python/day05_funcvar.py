# closure
# 함수를 인수로 받을 수도 있고, 리턴할 수도 있다.
# 이를 위해 inner function 을 만들 수 있음
# 고차 함수(closure): 무언가 정보를 넣으면 → 그 정보가 반영된 함수가 반환된다.
def multiply(times):
    def calc_multi(value):
        return times * value

    return calc_multi


double = multiply(2)
triple = multiply(3)
half = multiply(.5)

print(double(10), triple(100), half(20))
print(double)


def repeat(cnt=1):
    def repeat_inner(func, *args, **kwargs):
        # 주어진 횟수만큼 반복하는 함수를 리턴
        def repeating():
            rets = (func(*args, **kwargs) for i in range(cnt))
            return tuple(rets)

        return repeating

    return repeat_inner


@repeat(10)
def amugeona():
    print('아무거나')


print(amugeona())


def buffer():
    x = 0

    def plus_more(n):
        nonlocal x
        x += n
        return x

    return plus_more


c = buffer()
print(c(10), c(10), c(10), c(10), c(-10))

# print(outer(10, 20))
# print()
