SIZE = 3

is_full = lambda: top + 1 == SIZE
is_empty = lambda: top == -1


def push(data):
    global top, stack
    if is_full():
        print("스꽉")
        return

    else:
        top += 1
        stack[top] = data


def pop():
    global top, stack
    if is_empty():
        print("스비")
    else:
        data = stack[top]
        stack[top] = None
        top -= 1
        return data


def pick():
    global top, stack
    if is_empty():
        print("스비")
    else:
        data = stack[top]
        return data


if __name__ == "__main__":
    stack = [None] * SIZE
    top = -1
    while True:
        menu = input("삽입(I) / 추출(E) / 확인(V) / 종료(X)").lower()
        if menu == 'x':
            break
        if menu == 'i':
            push(input("data: "))
        if menu == 'e':
            print(pop())
        if menu == 'v':
            print(stack)
