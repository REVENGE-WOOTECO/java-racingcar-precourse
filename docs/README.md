# 미션 - 자동차 경주 게임

---

## 🔍 구현 방법

---

### MVC Model
- Model : Car
- View : InputView(입력 담당), PrintView(출력 담당)
- Controller : CarController(Car 생성 및 Car 메서드 활용)
- Utils : InputView 검증 
    
<br>

## 🔧 구현 기능

---

### 기능 명세
- [X] 자동차의 이름을 쉼표(,) 기준으로 구분해서 받는다.
- [ ] 입력된 자동차의 이름을 기반으로 Car instance를 생성하고, CarController의 List에 저장한다.
- [ ] 시도할 횟수를 입력받는다.
- [ ] CarList를 순환하며, 랜덤 값을 기반으로 Car의 Go/Stop 여부를 판단하고 처리한다.
- [ ] 종료 후 가장 distance가 큰 Car name을 출력한다.

<br>

### 예외 처리
- 예외 상황 발생 시 에러 문구를 출력한다. 문구는 [ERROR]로 시작되어야 한다.
- 예외 발생 시 `IllegalArgumentException`을 발생시키고, 에러 메시지를 출력 후 그 부분부터 다시 입력받는다.
- 예외에 알맞은 문구를 출력한다.


- [X] 이름이 쉼표로 구분되는지 확인
- [X] 이름 입력 사이사이에 공백이 있는지 확인
- [X] 이름이 5자 이하인지 확인
- [ ] 시도 횟수가 0 이상인지 확인

<br>

### 추가 처리
- [ ] 매직 넘버, SystemMessage 처리한다.
- [ ] public method는 Unit Test로 검증하도록 시도해본다.