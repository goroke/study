def print_poly(px):
    term = len(px)
    poly_str = ''

    for i in range(len(px)):
        coef = px[i]
        term -= 1

        if coef > 0 and i:
            poly_str += f'+'
        elif coef == 0:
            continue

        poly_str += f'{coef}x^{term} '

    print(poly_str)


def calc_poly(v, px):
    return sum(a*v**(len(px)-i-1) for i, a in enumerate(px))


def print_poly_special(tx, px):
    poly_str = ''

    for i in range(len(px)):
        coef = px[i]
        term = tx[i]

        if coef > 0 and i:
            poly_str += f'+'
        elif coef == 0:
            continue

        poly_str += f'{coef}x^{term} '

    print(poly_str)


def print_poly_special(px):
    poly_str = ''

    for i in range(len(px[0])):
        coef = px[0][i]
        term = px[1][i]

        if coef > 0 and i:
            poly_str += f'+'
        elif coef == 0:
            continue

        poly_str += f'{coef}x^{term} '

    print(poly_str)


def calc_poly_special(v, tx, px):
    ret = 0
    for i in range(len(px)):
        term = tx[i]
        coef = px[i]
        ret += coef*v**term

    return ret


print_poly([1, 3, 4, -5, 6, 0, 1])
print(calc_poly(2, [3, -4, 0, 6]))


# 리스트가 너무 커진다면, 오히려 변수 하나를 더 써서 메모리 낭비를 줄일 수 있다.
print_poly_special([[10000, 300, 40, 5], [2, 3, 4, 6]])
