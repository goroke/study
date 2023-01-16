# input 2 numbers

# start = int(input('start number: '))
# end   = int(input('end   number: '))

start_end = input("start and end number: ").split()
start = int(start_end[0])
end = int(start_end[1])

if end < start:
    start, end = end, start

if start < 1:
    k = 1
else:
    k = start

while k <= end:

    i = 2
    while i < k:
        if not k % i:
            break
        i += 1
    else:
        print(k, end=' ')

    k += 1
