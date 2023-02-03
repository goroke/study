# 선형 리스트(Linear list)

# 선형 리스트 중간에 자료를 끼워 넣는 과정
def insert_data(idx, value):
    """
    선형 리스트의 중간에 값을 삽입합니다.
    :param idx: 삽입할 위치
    :param value: 삽입할 값
    :return: None
    """
    if idx < 0:
        idx = len(linear_list) + idx + 1
    elif idx > len(linear_list):
        raise ValueError(f"누가 {len(linear_list)}개짜리 배열에 번호를 {idx}를 넣습니까!!")
        return

    # 1. 빈 공간을 추가한다. [a, b, d] -> [a, b, d, (빈 공간)]
    linear_list.append(None)

    # 2. 빈 공간을 원하는 자리까지 옮긴다. [a, b, d, (빈 공간)] -> [a, b, (빈 공간), d]
    i = len(linear_list) - 1    # 맨 오른쪽부터 시작
    while i > idx:  # 시간 복잡도 O(N)
        linear_list[i] = linear_list[i-1]   # 데이터를 오른쪽으로 밀기 위해 오른쪽에 일단 복사하고
        linear_list[i-1] = None  # 밀린 자리는 지운다.
        i -= 1

    # 3. 빈 공간에 원하는 값을 넣는다.
    linear_list[idx] = value


# 선형 리스트 중간에 있는 자료를 삭제하는 과정
def delete_data(idx):
    """
    선형 리스트의 특정 위치에 있는 값을 삭제합니다.
    :param idx: 삭제할 위치
    :return: None
    """
    # 1. 해당 자리를 비운다. [a, b, x, c, d] -> [a, b, (빈 공간), c, d]
    linear_list[idx] = None

    # 2. 비운 자리를 맨 끝으로 밀어낸다.
    i = idx  # 비운 위치에서 시작
    while i < len(linear_list) - 1:  # 시간 복잡도 O(N)
        linear_list[i] = linear_list[i+1]   # 빈칸을 오른쪽으로 밀어내기 위해 왼쪽으로 데이터를 복제하고
        linear_list[i+1] = None  # 오른쪽은 지운다.
        i += 1

    # 3. 끝 자리를 삭제한다.
    linear_list.pop()


# 특정 자리 이후를 삭제한다.
def delete_after(idx):
    i = len(linear_list) - 1
    while i >= idx:
        linear_list[i] = None
        del(linear_list[i])
        i -= 1
    # del(linear_list[idx:])    # 극한의 숏코딩


linear_list = [1, 2, 3, 4, 100, 5, 6, 7, 9, 10]

insert_data(8, 8)
print(linear_list)

delete_data(4)
print(linear_list)

delete_after(5)
print(linear_list)

if __name__ == "__main__":
    linear_list = []
    while True:
        select = input("선택하세요(1: 추가, 2: 삽입, 3: 삭제, 4: 종료)--> ")
        if select == '1':
            data = input("추가할 데이터--> ")
            linear_list.append(data)
        elif select == '2':
            pos = int(input("삽입할 위치--> "))
            data = input("추가할 데이터 --> ")
            insert_data(pos, data)
        elif select == '3':
            pos = int(input("삭제할 위치--> "))
            delete_data(pos)
        elif select == '4':
            break
        else:
            print("장난하지 마세요")
            continue

        print(linear_list)

