"""
제데네_귀
"""


def get_odds():
    for num in range(10):
        if num % 2:
            yield num


def get_odds_new():
    yield from [i for i in range(10) if i % 2]


# 그냥 이래도 되는 거 아닌가
get_odds_kkomsu = range(1, 10, 2)

print(list(get_odds())[2])
print(list(get_odds_new())[2])
print(list(get_odds_kkomsu)[2])


# 등비수열
def geom_seq(first=1, rate=1):
    seq = first
    while True:
        yield seq
        seq *= rate


# 을 이용해서 대충 무한등비급수 구하기
s = 0
for i in geom_seq(100, -.5):
    s += i
    if i <= 1e-100: break

# 생각보다 빠르다
print(s)
