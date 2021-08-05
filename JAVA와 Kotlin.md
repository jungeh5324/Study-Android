# JAVA와 Kotlin

## 공통점

* 두 언어 모두 컴파일러가 타입 오류를 잡아줌.
* 멀티 플랫폼 개발을 할 수 있음.
* 안드로이드 개발 가능. 객체 지향 프로그래밍을 지원함.

## 차이점

* Java는 class가 기본 단위로 class 안에서 로직을 만들어야 함.

  Kotlin은 class가 선택사항으로 Top-Level에서 변수, 함수의 선언과 구현이 가능함.(하지만 안드로이드 개발을 할 때는 Kotlin도 객체지향 언어처럼 클래스 내에서 로직을 작성해야 함.)

* Java(9 이하)는 타입 추론을 할 수 없음.

  Kotlin은 타입 추론이 가능함.

* Java는 null을 참조하면 예외를 발생시킴.(런타임 시에 흔히 발생할 수 있는 예외)

  Kotlin은 컴파일 시점에서 미리 방지 가능.(null을 확인하는 연산자가 존재하고 null이 가능한 타입도 있음)

* 변수/상수 표현이 다름.

  Java는 상수를 표현할 때 'final'을 붙임.

  ```java
  String str = ""; // 변수
  final String strFinal = ""; // 상수
  ```

  Kotlin은 변수는 'var', 상수는 'val'을 사용함.

  ```kotlin
  var str = ""; // 변수
  val strVal = ""; // 상수
  ```

  

## Kotlin의 장점

* 문법이 간결하고 사용성이 좋음.

  예 :

  Java

  ```java
  class Main {
      public static void main (String args[]){
          System.out.print("Hello World");
      }
  }
  ```

  Kotlin

  ```k
  System.out.print("Hello World");
  ```

* Null Safe 언어임.

  Java로 개발 할 때 NPE(NullPointException) 문제를 많이 겪게 되는데 Kotlin으로 개발 하면 Nullable, Non-nullable 개념을 가지고 있어 Java 라이브러리와 함께 사용하지 않는 한 NPE같은 문제가 발생하지 않음.

