# 미션 - 자동차 경주 게임

## :heavy_check_mark: 구현할 기능 목록
+ [x] 경주게임을 진행할 자동차 이름 입력받기
  + 예외처리->"에러메세지: 잘못된 자동차 이름입니다."
    + 이름이 5자 초과인 경우
    + 이름이 공백인 경우
    + 같은 이름이 입력된 경우
    + 이름이 빈 문자열인 경우
  + 에러메세지 출력 후 다시 입력받기
+ [x] 시도할 횟수 입력받기
  + 예외처리->"에러메세지: 1 이상의 숫자만 입력 가능합니다."
    + 숫자가 아닌 경우
    + 0을 입력받은 경우
  + 에러메세지 출력 후 다시 입력받기
+ [x] 자동차 별로 무작위 값 구하여 4 이상일 경우 전진
  + 0 ~ 9 사이의 무작위 값
+ [x] 각 차수별 실행 결과 출력
  + 형식
    (자동차이름) : (전진횟수) * -
+ [x] 모든 시도가 끝난 후 우승자 출력
  + 형식
    최종 우승자 : (자동차이름) 
  + 우승자가 여러명일 경우 쉼표(,)로 구분하여 출력

## :heavy_check_mark: 피드백 후 수정 목록
+ [x] 유효성 검증 클래스 명명 수정
  + Validation -> Validator
+ [ ] Validator 클래스 수정
  + 생성자가 필요없는 유틸성 클래스임
  + 유틸리티 클래스의 경우 생성자 private으로 변경
  + 관련글 찾아 학습
    + [유틸리티 클래스](https://spongeb0b.tistory.com/100)
    + [private 생성자](https://jinjinyang.tistory.com/34)
+ [ ] CheckCarName, CheckPlayTime, Validator
  + [ ] CheckCarName.validate(carNameArray) 형태가 아닌 생성자를 통해 validate하는이유?
    + 단일책임원칙
    + 생성자가 하는 역할, 책임
  + [ ] CheckCarName, CheckPlayTime 과한 클래스 분리인가?
    + tradeoff
  + CheckCarName, CheckPlayTime 클래스가 꼭 필요하다면 내부에서 new 로 생성하기 보다 validation 클래스의 인스턴스 변수로 두고 생성자를 주입받는 방법이 있을텐데 왜 new를 통해 생성하였는가?
+ [ ] CheckPlayTime에서 생성자를 통해 validate하는 이유?
+ [ ] 사용하지 않는 기본 생성자를 만든 이유?
+ [x] 클래스 내부에서만 사용하는 메서드 private으로 변경
  + 이유
    + 외부에서 값을 필요로 할 순 있지만, 그 내부 사정이 어떻게 돌아가는지 알 필요 없을 경우
    + 보안 측면으로 자료 보호 가능
    + 복잡한 로직을 굳이 알 필요가 없음
+ [x] checkCarName 의 List 이름 변경
+ [x] checkCarName 의 duplicate 확인법
  + Set, stream api활용
+ [x] checkCarName 의 공백만 존재할경우 확인법
  + 현재문제: 여러 공백이 들어온 자동차 이름은 걸러낼 수 없음
  + java string api의 trim 사용
+ [x] checkCarName 의 빈문자열일 경우
  + carNameLength를 확인할 때 함께 확인 가능
+ [x] checkCarName 의 가장 뒤에 , 가 포함된 경우
  + 정규표현식 사용
+ [x] 하나의 클래스에만 사용할 상수라면 해당 클래스 내부에 정의하는것을 권장
  + 기능이 추가되어 상수를 의종하는 클래스가 많아지게 될 경우의 문제점!
    + 일부 클래스에 대한 정책이 변경되어 상수값을 10으로 변경하는 순간 5의 값에 의존하던 클래스들은 예기치 못한 변경으로 인해 영향을 받게 되고 리팩터링이 어려워짐
+ [ ] InputUser에서 default접근 제어자를 사용한 이유?
+ [ ] InputUser 클래스에서 객체를 외부에서 생성자로 주입받지 않고 내부에서 생성하는 이유?
+ [ ] RacingGame 클래스에서 LinkedList, default 생성자를 사용한 이유?
+ [ ] RacingGame 클래스의 getWinner메소드 depth 1로 줄이기
  + stream으로 처리
+ [ ] Car에서 position을 getter로 가져와 비교하고 있는데 이러한 부분을 Car 객체에게 메세지를 보내도록 수정하기
+ [ ] CarList를 Car 클래스로 랩핑하면 승자를 구하는 로직을 해당 객체에게 위임할 수 있음
+ [x] RacingGame의 , 추가해주는 부분 수정
  + String method, Stream api에 쉼표 삽입 기능 학습, 적용
    + String.join(구분자,요소)
+ [ ] Car객체를 생성할 때 이름에 대한 Length 검사가 없는 이유?
+ [ ] method depth 2에서 1로 줄이기
  + java stream api 사용
+ [ ] (선택) mvc패턴 학습 및 적용

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

## ✉️ 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr) 에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 를 참고한다.
  - **Pull Request만 보내고, 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<br>

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.

### 추가된 요구사항

- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
   - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
   - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 프로그래밍 요구사항 - Car 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

```java
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
}
```

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

<br>

---

## 📈 과제 진행 요구사항

- 미션은 [java-racingcar-precourse](https://github.com/woowacourse/java-racingcar-precourse) 저장소를 Fork/Clone해 시작한다.
- **기능을 구현하기 전에 java-racingcar-precourse/docs/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
   - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고한다.

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
