string = input()
max_cnt = 0
max_char = '?'

for char in set(string):
    if cnt := string.count(char) > max_cnt:
        max_cnt = cnt
        max_char = char
    elif cnt == max_cnt:
        max_char = '?'

print(max_char)

freq = {char: string.count(char) for char in string}
students =