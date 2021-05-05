## **Shopping mall project - 쇼핑몰 프로젝트**  

## Purpose of project / 프로젝트의 목적

```
1. Springframework 기반의 backend framework 기술 능력 향상
2. backend framework와 DataBase를 연동함으로써 RDBMS 설계 능력 향상
3. SQL 언어를 Spring JPA 라는 JAVA 기반 언어로 설계 함으로써 객체지향설계 능력 향상 
4. Spring Web MVC를 활용하여 Model, View, Controller 로 나누어 설계하는 능력 향상 
```

## function of project / 프로젝트의 구현기능
* 회원
```
1. 회원가입 - 이름, 비밀번호, 이메일, 주소 등을 기입한다.
2. 회원정보 - 회원들의 정보들을 한꺼번에 보여준다.
3. 회원수정 및 삭제 - 회원정보 페이지에서 수정과 삭제를 할 수 있다.
```
* 상품
```
1. 상품등록 - 이름, 카테고리, 가격, 수량 등을 기입한다.
2. 상품목록 - 등록한 상품들을 한꺼번에 보여준다.
3. 상품수정 및 삭제 - 상품목록 페이지에서 수정과 삭제를 할 수 있다.
```
* 주문
```
1. 상품주문 - 상품주문 할 회원명, 상품이름, 수량 등을 기입한다.
2. 주문내역 - 주문한 상품들을 보여주고 누가, 언제 등 주문한 상세정보를 보여준다.
3. 주문취소 - 주문내역 페이지에서 주문한 상품을 취소할 수 있다. 
```
## How to operate the project / 프로젝트는 어떻게 동작하는가 
```
1. Start SpringBoot Server / 스프링부트 서버를 실행시켜 준다
2. localhost:8080/ 로 접속한다 
```

## Getting Started / 어떻게 시작하나요?

### Prerequisites / 선행 조건

아래 사항들이 설치가 되어있어야합니다.

```
java SDK >= 11
java jdk >= 1.8
springframework.boot >= 2.4.3 
spring data jpa
spring web
lombok
thymeleaf
mysql
```

### Installing / 설치(어떻게 설치, 사용하는가)

아래 사항들로 현 프로젝트에 관한 모듈들을 설치할 수 있습니다.

* ##### [start.spring](https://start.spring.io/)
```
1. 위 링크를 타고 접속
2. 프로젝트명, 스프링부트 버전 등 작성
3. 오른쪽 위 ADD DEPENDENCIES 클릭
4. Spring Web, Spring Data JPA, Thymeleaf, Lombok, MySQL Driver 추가
5. 하단의 GENERATE 클릭 후 프로젝트 생성
```

### Installing Guidance Documents / 설치 가이드 문서 


* ##### [quickstart](https://spring.io/quickstart) - 퀵 스타트
* ##### [guides](https://spring.io/guides) - 가이드 문서 


## Running the tests

### 테스트는 이런 식으로 동작합니다

* 프로젝트가 잘 생성되었는지 확인합니다 

```
1. Intellij, Eclipse 등 Build Tool 접속 후 생성해둔 프로젝트를 'Open as project'로 연다
2. Project Build 가 완료되면 '프로젝트명'Application.java 를 실행한다
3. 실행 후 localhost:8080 으로 접속했을 때 white label page 가 뜨면 성공 
```

## Built With

* [CokeLee777](https://github.com/CokeLee777) - Create all of this project

## Contributiong

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us. / [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) 를 읽고 이에 맞추어 pull request 를 해주세요.

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://gist.github.com/PurpleBooth/LICENSE.md) file for details / 이 프로젝트는 MIT 라이센스로 라이센스가 부여되어 있습니다. 자세한 내용은 LICENSE.md 파일을 참고하세요.

### References 
1. 자바 ORM 표준 JPA 프로그래밍
2. 인프런 - [김영한의 스프링 부트와 JPA 실무 완전 정복 로드맵](https://www.inflearn.com/roadmaps/149)
3. 인프런 - [우아한형제들 개발팀장 김영한의 스프링 완전 정복](https://www.inflearn.com/roadmaps/373)

## Acknowledgments / 감사의 말 
Thank you for visiting my repository
