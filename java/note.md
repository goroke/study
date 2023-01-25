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
       
       - 설치 안 되는 경우
     CMOS Setup 의 문제일 가능성 있음.
     가상화 기술 *(Virtualization Technology; VT)* 이 Disabled 인 경우는 설치 프로그램이 동작하지 않음
     → VT 옵션을 Enabled 로 바꿔주면 된다.
     　
     (Intel 계열 CPU에서 자주 발생하는 문제)
    - <a href=https://www.jetbrains.com/idea/>IntelliJ</a>

    - (경우에 따라) 웹 컴파일러
---
### 기타
>**폴더 정리** 잘 해야 한다.
> - C 드라이브는 운영체제가 쓰도록 양보할 것
> 
> - 디렉토리 명은 웬만하면 영문, 숫자 등등으로만 만들자. 공백이나 한글, 특수 문자는 쓰지 말 것. (호환성 문제 생길 여지 있음)
