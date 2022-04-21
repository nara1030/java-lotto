# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항
- 문자열 계산기
    - 사칙연산 테스트
        - [x] 덧셈
        - [x] 뺄셈
        - [x] 곱셈
        - [x] 나눗셈
    - 입력 테스트
        - [x] 공백 없을 경우 예외 발생
        - [x] 공백 있는 경우 String 배열 반환
        - [x] 예외 발생한 경우 재입력 받기
    - [x] 문자열 계산기 테스트
- 로또
    - 입력 테스트
        - [x] 구입 금액을 입력
        - [x] 음수 및 문자를 입력한 경우 예외 발생
        - [x] 구입 금액 입력 시 예외 발생 경우 재입력 받기
        - [x] 지난 주 당첨번호 입력
    - 로또 테스트
        - [x] 1부터 45 내의 중복되지 않는 숫자 6개를 포함한 로또 생성
        - [x] 구입금액에 대한 로또 생성
        - [x] 구매개수 반환
        - [x] 지난 주 당첨번호와 비교하여 일치 개수 반환
        - [ ] 수익률 반환
    - 출력 테스트
        - [x] 구매개수 출력
        - [x] 로또 결과 출력
        - [x] 당첨 통계 출력
        - [ ] 수익률 출력

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)