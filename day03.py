number = int(input("정수 입력: "))
counts = 0
for k in range(2, number):
    if number % k == 0:
        print(number, 'is NOT prime number!')
        break
else:
    print(number, 'is prime number!')
