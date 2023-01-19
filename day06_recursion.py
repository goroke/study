# recursion
def factorial_for(n):
    for i in range(1, n):
        n *= i
    return n


# recursion
def factorial_rec(n):
    return n * factorial_rec(n-1) if n else 1


print(factorial_for(6))
print(factorial_rec(6))
