# decorator
def print_instead_of_return(func):
    def temp_func(*args, **kwargs):
        print(func(*args, *kwargs))

    return temp_func


@print_instead_of_return
def add_ints(a, b):
    return a + b


add_ints(2, 4)
