(강의록은 <a href=https://drive.google.com/file/d/1DVTOurLhHgkH518_9zsPf19fQLjXgrl6/view>여기</a>에 있습니다)  
<a href=https://cafe.naver.com/javadbkang>깦페 바로가기</a>

# 1. 시작
## 1-1. 필요한 것들
- **JDK** (Java Development Kit)
    - JRE(런타임 환경), JVM(가상 머신) 포함
    - <a href = https://www.oracle.com/kr/java/technologies/downloads>Oracle 사이트</a>에서 다운 받을 수 있음
(cmd 에서 java -version 입력했을 때, 버전이 찍히면 제대로 설치된 것)

- **환경 변수** 설정  
    - 시스템 변수 추가
        - *JAVA_HOME* (새로 만들 것)  
        JDK 가 설치된 곳
    *(ex: C:\Program Files\Java\jdk-19)*
    
        -    *Path* (추가)  
        %JAVA_HOME%\bin

- **Editor**
    - <a href=https://www.eclipse.org/downloads/> <img src=https://www.eclipse.org/downloads/assets/public/images/logo-eclipse.png width=15> Eclipse </a>
       - Eclipse IDE for Java Developers: Java 프로그래밍용  
       Eclipse IDE for Enterprise Java and Web Developers: 웹 프로그래밍(JSP)용  

       - 참고  
       [Window] - [Preferences] 에서 Save Actions 에 들어간 후,  
       Perform the selected actions on save 를 체크하면 여러 가지로 편리한 기능을 쓸 수 있다.  
       (자동 import, 자동 코드 정리 기능 등등등)    
       
       - 한글이 깨지는 경우
         [Window] - [Preferences] 에서 General - Workspace로 진입 후, 하단의 "Text file encoding" 부분을 MS949 로 설정하면 안 깨진다.
       
       - 설치 안 되는 경우
     CMOS Setup 의 문제일 가능성 있음.
     가상화 기술 *(Virtualization Technology; VT)* 이 Disabled 인 경우는 설치 프로그램이 동작하지 않음
     → VT 옵션을 Enabled 로 바꿔주면 된다.
     　
     (Intel 계열 CPU에서 자주 발생하는 문제)
    - <a href=https://www.jetbrains.com/idea/>IntelliJ</a>

    - (경우에 따라) 웹 컴파일러
  
## 1-2. 프로젝트 생성 (with Eclipse)

- **새 프로젝트 생성** [File] - [New] - [Java Project]  
Java Project 가 없을 수도 있는데, 그럼 그냥 Project를 선택하면 된다.  

- 설정값 입력
  - Project name  
*(프로젝트 이름은 CamelCase 를 쓰는 것이 관례라고 한다. 뻥이었다.)*  

  - *Next&gt;* 를 누르면 대충 디렉토리가 뜬다.  
  확인해보고 이상 없으면 *Finish* 눌러서 프로젝트를 생성하면 된다.
# 2. 무언가 만들어보기
## 2-1. 기본 입출력 구현
### 2-1-1. 스트림(Stream)
입출력 메커니즘  
(데이터의 흐름을 의미한다.)

- 방향성
    - 입력 스트림(Console → Java)
        - **System.<nolink>in**: 표준 입력 스트림
    - 출력 스트림(Java → Console)
  
- 데이터의 형태
    - 문자 스트림(4Byte 단위)
    - 바이트 스트림

### 2-1-2. 출력
- System.out.print
줄바꿈이 없는 출력
- System.out.println
줄바꿈이 있는 출력
- System.out.printf
C언어 비스무리한 친구  
줄바꿈은 없다  
(printf의 f는 formatted 라는 뜻을 가지고 있다)
- System.out.write
문자를 버퍼에 넣기만 한다  
print, println 등을 호출해야 출력이 된다.  
  
### 2-1-3. 입력
[입력 장치] → 표준 입력 스트림(System.<nolink>in) → InputStreamReader

- Scanner 클래스 이용 (JDK 8 버전부터 지원)
  1. import java.util.Scanner
    (라이브러리를 불러 와야 한다.)
  2. Scanner a = new Scanner(System.<nolink>in);
    (Scanner 생성자 자체에 입력을 기다리는 기능이 있는가? → 없다. next 메서드 등을 써야 입력을 기다린다.)
  3. a.next(*[String]*), a.nextInt(*[int]*) 등등
    입력된 값을 순차적으로 읽어온다.
    공백류 문자(\t, \n, Space Bar)로 구분된다.

## 2-2. 변수 선언
- int a = ~~;
- Integer a = ~~;
- 또 뭐가 더 있다던데
### 2-2-1. 변수 타입
- 정수(integer)
- 실수
    - **float**: 4byte
    - **double**: 8byte
- 문자(char)
- 문자열(String): 마지막 글자는 Null 문자(\0) 가 와야 한다.
 - 아무거나(var): 처음 값에 따라 데이터 타입이 결정된다. 값의 데이터 타입이 애매하면 에러가 난다.
- 배열(array): 같은 타입의 변수가 여러 개 들어있는 것  
  int a[] = {1, 2, 3};  
  int a[] = new int[10];
  int a[] = new int[10][10]; // 2차원 배열도 생성 가능
#### 강제 형 변환(cast)
3.0 → double  
3.0f → float  
*(float)* 3.0 → float

### 2-2-2. 상수
**final** double PI = 3.1415926;  
(보통 상수의 이름은 대문자로 쓴다.)  
final 키워드가 메서드나 클래스에 붙으면 상속, 오버라이드가 불가능한 상태가 된다.

### 2-2-3. 정적 변수(static)
Java는 그 특성 상 모든 코드가 클래스로 이루어져 있는데, static 키워드를 쓰면 변수(혹은 메서드)가 "클래스 소속" 이 된다.
static 키워드가 붙으면, 컴파일 시점에서 변수 공간을 할당한다.  
즉, 실행되기 전부터 변수가 들어갈 공간이 준비된다는 뜻이다.  

## 2-3. 기본 문법
### 2-3-1. 연산자
- 삼항 연산자(조건 연산자)
    *[condition]*? *[value_if_true]*:*[value_if_false]*  
    
- 논리 연산자
    - && (and)
    - || (or)
    - ! (not)
    - ^ (xor)

### 2-3-2. 제어문
python과 달리 if, for 등등의 조건 식은 소괄호로 묶어야 한다.  
콜론 대신 중괄호 블록을 이용한다. (안의 명령이 하나일 때는 중괄호 생략 가능)
ex) if(a == 1) {a++;}  

- 조건문
    - if(*[condition1]*) ... else if(*[condition2]*) ... else
    - switch ... case
- 반복문
    - for
    - while
    - do ... while
    - 무한반복 → for(;;) or while(true)
- 분기문
    - break
    - continue
    - return

### 2-3-3. static

변수나 함수에 static 을 붙이면 클래스 소속이 된다.  
안 붙이면 인스턴스 소속이 되기 때문에, 인스턴스를 만들어야 쓸 수 있다.

## 2-4. 함수 정의
**public**<sub>(접근 권한)</sub> **static**<sub>(인스턴스 없이 사용 가능 여부)</sub> **void**<sub>(반환 타입)</sub> main (매개 변수들) { \~\~\~\~\~\~ }

### 기타
- **폴더 정리** 잘 해야 한다.
  - C 드라이브는 운영체제가 쓰도록 양보할 것
 
  - 디렉토리 명은 웬만하면 영문, 숫자 등등으로만 만들자. 공백이나 한글, 특수 문자는 쓰지 말 것. (호환성 문제 생길 여지 있음)
- **모듈**(Module): 비슷한 역할을 하는 함수/클래스들을 묶어놓은 것  

- Java는 철저히 객체지향적인 언어이므로 파일도 클래스 단위(파일명 = 클래스명)로 만들어야 한다. (프로젝트 전체가 클래스 구조)
- Member function = Method
- "%d" 의 "%" 는 placeholder 라고 읽는다.  
  (percent 로써의 의미는 없기 때문)
- new 연산자
    - 메모리 공간을 확보한 후 그 공간에 인스턴스를 만든다.
    - 인스턴스의 주소 값을 반환한다.
- String 은 char의 배열이지만 파이썬 식의 인덱싱, 슬라이싱을 지원하지 않는다.
    - 인덱싱 대신 *[String]*.charAt(*[index]*) 를 쓸 수 있다.
    - 슬라이싱 대신 *[String]*.subString(*[start]*, *[end]*)를 쓸 수 있다.

# 3. 객체 지향 프로그래밍
## 3. 1. 개념
- **캡슐화**: 공개할 필요가 없는 정보는 숨기면서, 개발자가 마치 완제품을 사용하듯이 클래스를 쓸 수 있게 한다.  
  (Java에서는 접근 지정자를 이용해 정보를 숨길 수 있다.)
- **상속성**: 비슷한 성격이거나 하위 개념인 클래스는 속성, 메서드를 물려받을 수 있다.
- **다형성**: 같은 메서드를 각각의 방식대로 구현할 수 있다.

## 3. 2. 접근 지정자

- public  
 모두가 접근할 수 있다.

- protected
  외부 패키지에서는 접근할 수 없고, 같은 패키지나, 하위 클래스에서는 접근이 가능하다.

- (default)
  같은 패키지에 묶여 있으면 접근할 수 있다.  
  상속받은 클래스에서는 접근이 안 된다.

- private
  객체 내에서만 접근할 수 있다.  
  static인 경우는 그 클래스 안에서만 접근할 수 있다.
  상속받은 클래스에서도 쓸 수 없다.

| |클래스 내부|패키지 내부|하위 클래스|패키지 외부|
|-|-|-|-|-
|public|O|O|O|O
|protected|O|O|O|X
|(default)|O|O|X|X
|private|O|X|X|X

## 3. 3. static과 안 static
- 인스턴스 메서드 (인스턴스 소속)
  - 실행 중에 생성된다.
  - (java code) - compiler - (byte code) - ***interpreter*** - (result)
  - 동적 기억 공간(Heap)에 생성
  - **this** 키워드 사용 가능
    - 인스턴스 자신을 가리킨다.
    - this를 호출할 수도 있는데, 생성자가 호출된다.
  - 객체마다 다르게 작동해야 하는 경우
  - 정적 속성과 메서드에 접근할 수 있다.


- 정적 메서드 (클래스 소속)
  - 컴파일 시에 생성되며, 프로그램을 켜자마자 로드된다.
  - (java code) - compiler - (byte code) - ***interpreter*** - (result) 
  - 정적 기억 공간에 생성
  - **this** 사용 불가능
  - 객체 특성과 무관한 경우
  - 인스턴스 속성과 메서드에는 접근할 수 없다.

## 3. 4. 상속(Inheritance)
### class B extends A
A라는 클래스를 상속한다.  
A가 슈퍼 클래스, B가 서브 클래스가 된다.

### 3. 4. 1. 서브 클래스의 생성자
- 상속받았다고 해서 생성자를 안 만들면 작동이 안 된다.
- 생성자를 만들면, 기본적으로 슈퍼 클래스의 기본 생성자(매개변수 없는 것)도 같이 실행된다.
- super() 함수는 슈퍼 클래스의 생성자인데, 생성자 첫 줄에 이 함수를 호출하면, 기본 생성자 대신 그 호출된 함수가 실행된다.


# ★. 따로 공부해볼 것들
따로 공부해볼 내용들이므로, 공부 완료했으면 아래에 내용 정리 후 체크 바람
- [ ] **GUI** (수업 중에 따로 다룰 시간이 없을 것 같음)
- [ ] Java 프로그램 구조 (책에 있음)
- [x] **Modifiers** (접근 권한 지정자)
  - 3\. 2 를 참고할 것
- [ ] module-info.java 와 에러