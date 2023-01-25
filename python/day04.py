import random

grade_list = []
for grade in 'ABCD':
    grade_list.append(grade+'0')
    grade_list.append(grade+'+')
grade_list.append('F')

scores = random.choices(grade_list, k=5)
print(scores)

print(scores[14214:124897149389])


print(id(scores))
scores.extend(['F'] * 5)
print(id(scores), scores)  # 주소가 바뀌지 않는다.
scores += ['F'] * 5
print(id(scores), scores)  # 주소가 바뀌지 않는다.

print(sorted(scores))

extra = ['QWER', 'ASDF', 'ZXCV']
scores.insert(0, extra)

print(scores)

print(scores)