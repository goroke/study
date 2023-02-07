# 괄호 매칭 검사
from stack import Stack

BRACKET_OPEN = '({[<'
BRACKET_CLOSE = ')}]>'


def check_bracket(expression):
    bracket_stack = Stack(len(expression))

    for character in expression:

        for bracket_open, bracket_close in zip(BRACKET_OPEN, BRACKET_CLOSE):

            if character == bracket_open:
                bracket_stack.push(character)

            elif character == bracket_close:
                if bracket_stack.pop() != bracket_open:
                    return False

    return bracket_stack.is_empty()


if __name__ == "__main__":
    test_cases = 'asdf()()()()((', 'asdf', 'asdf(asd([dfs]))d'

    for test_case in test_cases:
        print(check_bracket(test_case))
