import socket
import sys

SERVER_ADDRESS = 'localhost' #'165.246.115.165'
PORT = 20000
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    s.connect((SERVER_ADDRESS, 20000))
except ConnectionRefusedError:
    print('서버 연결이 않뒙니다.')
    exit()

while True:
    print('전송 메시지 입력: ')
    msg = sys.stdin.readline()
    if msg.lower() == 'exit':
        break
    else:
        s.send(msg.replace('/', '\n').encode())

        data = s.recv(1024).decode()
        print(f'서버로부터 받은 메시지: {data}')

s.close()
