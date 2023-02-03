def insert_friend(name, number):
    target = (name, number)
    talk.append(None)

    for i in range(len(talk)-1, 0, -1):
        # print(talk[i-1:i+1])  # i-1: ('~~', ~~), i: None

        if number <= talk[i-1][1]:
            talk[i] = target
            break

        talk[i] = talk[i-1]
        talk[i-1] = None  # i-1: None, i: ('~~', ~~)

    else:
        talk[0] = target


talk = [('다현', 200), ('정연', 150), ('쯔위', 90), ('사나', 30), ('지효', 15)]
insert_friend('미나', 100)

print(talk)

// ['이름':HP]
// 연습문제