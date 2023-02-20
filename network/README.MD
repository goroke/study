## 기본적인 개념
- Socket
- Protocol
  - TCP/UDP
    - TCP: 신뢰할 수 있는 프로토콜(전 세계와 연결 가능)
    - UDP: 같은 네트워크에서만 쓴다
  - HTTP
  - FTP
  - SMTP
- Port  
  프로토콜마다 다르다.
- P2P
- Multicast/Unicast

## 구현
- InetAddress (JAVA)
  - 생성자 없음 (static getter 메서드를 이용해서 객체를 생성할 수 있다.)
    - getByName(String URL) → IP 주소를 알아낼 수 있다.
  - isReachable(int time)  
    주어진 시간(ms) 안에 핑이 돌아오는가?

- ServerSocket Class
  - 생성자 new ServerSocket(포트 번호)

- Socket Class
  - 생성자
  - 송신용 버퍼 getOutputStream
    - PrintWriter br = new PrintWriter(
      clientSocket.getOutputStream(), true));  
      뒤에 있는 boolean 매개변수는 버퍼를 자동으로 비워주느냐에 대한 여부

  - 수신용 버퍼 getInputStream
    - BufferedReader br = new BufferedReader(
      new InputStreamReader(
      clientSocket.getInputStream()));


- Socket 을 이용한 네트워크 구현
  - Server
    - ServerSocket 을 만든다.
    - 송신용 버퍼, 수신용 버퍼를 만든다.
    - Thread 를 만들어서 각각의 클라이언트를 처리한다.

- Thread Pool
  - 무분별한 Thread 생성으로 인한 과부하를 막을 수 있다.
  - 객체 생성
    - ExecutorService a = Executors.newFixedThreadPool(n);
    - Executors.newCachedThreadPool();
  - 사용
    - a.submit(runnable);
  - 끝나면 shutdown 해 줘야 한다.
    - a.shutdown();

- NIO
  - 주요 개념
    - Channel  
      프로그램들 사이에서 데이터의 흐름  
      양방향 처리 가능
      - FileChannel
      - DatagramChannel
      - SocketChannel
      - ServerSocketChannel
  
    - Buffer  
      데이터를 처리하기 위한 임시 저장 공간
      - _ByteBuffer buffer = ByteBuffer.allocate(int size)_;
  
    - Selector  
      싱글 스레드에서 여러 채널을 조작할 수 있게 하는 기술
      - 사용법
        - 객체 생성: _Selector selector = Selector.open()_;  
          (정적 메서드로 객체 생성)
        - 채널 등록(셀렉터가 아닌 채널에서 메서드를 호출한다):  
          _socketChannel.register(selector, SelectionKey.OP_WRITE, null)_;
            - SelectionKey 값들  
              (매개 변수로 들어간 SelectionKey 의 행동에 대해서만 Selector 에서 확인 가능)
              - OP_CONNECT
              - OP_ACCEPT
              - OP_READ
              - OP_WRITE  
            
              OR 연산으로 여러 개를 관찰하도록 할 수도 있다.
          - 채널의 Blocking Mode 는 꼭 꺼져 있어야 한다.  
            socketChannel.configureBlocking(false);
          - 리턴 값 → SelectionKey 객체
            - readOps (관찰 중인 행동들을 int 형태로 반환)
            - isAcceptable/isConnectable/isReadable/isWritable
            
        - 등록된 채널 선택
          - selector.selectedKeys() 안에 등록된 채널들이 있다(Set 형태).  
            보통 이를 순환하면서 사용한다.

- 비동기 소켓 채널(Asynchronous Socket Channels): 비동기 네트워킹 가능
  - 사용되는 클래스들
    - AsynchronousSocketChannel
    - AsynchronousServerSocketChannel
    - AsynchronousDatagramChannel
  - 비동기 처리 방식
    - Future 인터페이스
      - boolean isDone() 작업이 끝났는가?
      - get() 작업의 결과물을 리턴받는다.
        - get() // 리턴받을 때까지 무한정 대기
        - get(long timeout, TimeUnit unit) // 특정 시간만큼만 대기  
          TimeUnit 은 열거형 (TimeUnit.SECONDS 이런 식으로 쓴다.) 
    - CompletionHandler<V, A> 인터페이스
      - callback 방식


### 기타
- URL 받아오기 (URL, URLConnection)
- try (~~~~)  
  try 문 안에서만 동작하는 객체를 만들 수 있다.
- 함수형 인터페이스
  - Method Reference (ClassName::MethodName)
- Runnable 또한 함수형 인터페이스이므로 람다식을 넣을 수 있다.

- JSON


### 공부할 것들
- Stream (Python의 Generator 와 비슷함)
  - 특징
    - Raw Data 에 접근하지 않기 때문에 그에 따른 Side Effect 가 발생하지 않는다.
  - 용도
    - 실시간 연산이 필요하거나, 데이터가 방대한 경우(ex: 빅 데이터)
      - 데이터 전체를 받아오지 않음  
        A B C가 있으면, 처음에는 A에만 접근할 수 있고, 다음은 B에만 접근할 수 있는 식.
      - 병렬 처리에도 좋다

  - 사용법
    - Stream 생성
      - Collection (List 등등) 에서 불러오기  
        - java.util.Collection.stream()
        - java.util.Collection.parallelStream()
      - Array 에서 불러오기
        - Arrays.stream()  
          int, long, double 등등의 배열을 스트림 화 할 때 쓴다.
        - Stream.of()
        - IntStream.of()
        - LongStream.of()
        - DoubleStream.of()
      - 정수형
        - IntStream.range(~, ~)
        - LongStream.range(~, ~)
        - Random.ints()
        - Random.longs()
      - 파일 시스템
        - Files.list(Path) 디렉토리 안에 있는 파일들로 이루어진 스트림
        - Files.lines(Path, Charset) 파일을 한 줄씩 불러옴
      
    - 명령 처리
      - 변환 (스트림 → 스트림)
        - map~~~ (스트림 안의 내용을 함수 리턴값으로 변환하여 또 다른 스트림 반환 x → f(x))
        - flatMap~~~ (여러 개의 객체를 리턴하는 map)
        - ?..
      - 처리
        - peek
        - forEach

- UML 을 이용한 설계가 먼저다.

- OSI 7계층
  - 여길 보시오 https://shlee0882.tistory.com/110

- SOLID
  - 단일 책임의 원칙
  - 개방 폐쇄의 원칙
  - 리스코프 치환 원칙
    - 부모 클래스의 인스턴스로 자식 클래스를 받을 수 있도록 호환성을 보장해야 한다.
  - 인터페이스 분리 원칙
    - 인터페이스는
  - 역전성 의존의 원칙
    - ?..
  - Enumerator
  - StringBuilder / StringBuffer
  - ExecutorService
    - new 키워드로 만들 수 없고, static 메서드를 이용해서 만들 수 있다.

- 디자인 패턴

- StringBuilder
  - 삽입/삭제에 유리하다.

- 중첩 클래스(클래스 안에 클래스)
  - A 안에 B 를 선언하는 경우 _class A{class B ~~~~}_
  - 타입은 A.B 로 적는다.
  - static 이 아닌 경우는 인스턴스가 있어야 만들 수 있음 _A.B test = A.new B();_
  - 그래픽 다룰 때 이벤트 처리에서 많이 쓴다고 함