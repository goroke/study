from collections import deque


class Graph:
    def __init__(self, size):
        self.tab = 1
        self._size = size
        self._matrix = [[0] * size for _ in range(size)]
        self._name_array = None

    def __repr__(self):
        matrix_to_str = [('\t'*self.tab).join(map(str, row)) for row in self._matrix]
        if self._name_array:
            ret = '\t'*self.tab + ('\t'*self.tab).join(self._name_array)
            for i in range(self._size):
                ret += '\n' + self._name_array[i] + '\t'*self.tab + matrix_to_str[i]
        else:
            ret = '\n'.join(matrix_to_str)

        return ret

    def connect(self, start, end, weight=1):
        self._matrix[start][end] = weight

    def names(self, *name_array):
        if name_array:
            if len(name_array) == self._size:
                self._name_array = list(map(str, name_array))

        return name_array

    def dfs(self, start=0, behavior=None, return_name=False):

        def add_new_vertex(vertex, stack=True):
            nonlocal visited, visit_stack
            if stack: visit_stack.append(vertex)
            visited.append(vertex)

            # 순환하며 수행할 함수를 정했다면 실행한다.
            if behavior:
                behavior(self._name_array[vertex] if return_name else vertex)

        # 출발 지점
        current = start

        visited = []
        visit_stack = []

        while True:

            # 현재 지점에서 연결된 한 곳으로 간다.
            next = None

            for vertex in range(self._size):
                # 갔던 곳은 다시 가지 않는다.
                if vertex in visited:
                    continue

                # 안 갔던 곳으로 행선지를 정한다.
                else:
                    if self._matrix[current][vertex]:
                        next = vertex
                        break

            # 행선지를 찾으면
            if next:
                current = next
                add_new_vertex(current)

            # 행선지가 없는 경우
            else:
                print(f'{current} not found')
                # 뒤로 돌아간다.
                if visit_stack:
                    visit_stack.pop()
                    current = visit_stack.pop()

                # 돌아갈 곳조차 없다면 끝난 것
                else:
                    break

        # 순회한 모든 곳을 리턴한다.
        return [self._name_array[idx] for idx in visited] if return_name else visited

    def bfs(self, start=0, behavior=None, return_name=False):

        def add_new_vertex(vertex):
            nonlocal visited, visit_queue, current
            visit_queue.append(vertex)
            visited.append(vertex)

            # 순환하며 수행할 함수를 정했다면 실행한다.
            if behavior:
                behavior(self._name_array[vertex] if return_name else vertex)

        # 출발 지점
        current = start

        visited = []
        visit_queue = deque()
        add_new_vertex(current)

        while visit_queue:

            # 현재 지점에서 연결된 한 곳으로 간다.
            next = None

            for vertex in range(self._size):
                # 갔던 곳은 다시 가지 않는다.
                if vertex in visited:
                    continue

                # 안 갔던 곳으로 행선지를 정한다.
                else:
                    if self._matrix[current][vertex]:
                        next = vertex
                        break

            # 행선지를 찾으면
            if next:
                # 큐에 추가한다.
                current = next
                add_new_vertex(current)

            # 행선지가 없는 경우
            else:
                # 뒤로 돌아간다.
                if visit_queue:
                    visited.append(current)
                    current = visit_queue.popleft()
                else:
                    break


        # 순회한 모든 곳을 리턴한다.
        return [self._name_array[idx] for idx in visited] if return_name else visited


class UndirectedGraph(Graph):
    def __init__(self, size):
        super().__init__(size)

    def connect(self, start, end, weight=1):
        self._matrix[start][end] = self._matrix[end][start] = weight

    @property
    def lines(self):
        s = 0
        for row in self._matrix:
            s += sum(row)

        return s // 2


a = UndirectedGraph(9)
a.names(*'ABCDEFGHI')
a.connect(0, 1)
a.connect(0, 2)
a.connect(0, 4)
a.connect(1, 2)
a.connect(1, 3)
a.connect(1, 3)
a.connect(2, 3)
a.connect(2, 4)
a.connect(2, 5)
a.connect(4, 6)
a.connect(4, 7)
a.connect(6, 8)
a.connect(7, 8)

print(a)
print(a.lines)
for i in a.dfs(0):
    print('ABCDEFGHI'[i])
