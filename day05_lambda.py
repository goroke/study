# lambda
import random

def squares(n):
    """
    square
    :param n: integer
    :return: integer
    """
    return n**2


def process(no_lists, f):
    for no in no_lists:
        print(f(no))


numbers = [random.randint(1, 100) for i in range(5)]
print(numbers)
process(numbers, lambda n: n*n)

