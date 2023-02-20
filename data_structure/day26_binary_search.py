import random
random.shuffle(l := list(range(100)))
l = sorted(l[:30])
print(l)

find = int(input())
start = 0
end = len(l)

while start <= end:
    mid = (start + end) // 2
    print(mid, l[mid])

    if find > l[mid]:
        start = mid + 1
    elif find == l[mid]:
        break
    else:
        end = mid - 1
else:
    print('못 찾겠다 꾀꼬리')
