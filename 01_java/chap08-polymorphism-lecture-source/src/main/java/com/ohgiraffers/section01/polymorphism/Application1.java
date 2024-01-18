package com.ohgiraffers.section01.polymorphism;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 다형성과 타입 형변환에 대해 이해할 수 있다. */
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.howling();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.howling();
        tiger.bite();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.howling();
        rabbit.jump();

        /* 설명. 다형성 적용(부모 타입으로 자식 인스턴스의 주소값 저장) */
        Animal an1 = new Tiger();
        Animal an2 = new Rabbit();

        /* 설명. Animal은 Tiger나 Rabbit이 아니다(Animal은 Tiger나 Rabbit 타입을 지니고 있지 않다.) */
//        Tiger tg1 = new Animal();
//        Rabbit rb1 = new Animal();

        /* 설명. 동적바인딩 확인하기 */
        /* 필기.
         *  컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가
         *  런타임 당시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩이 바뀌어 동작하는 것을 의미한다.
         *  (동적 바인딩의 조건: 1. 상속, 2. 오버라이딩)
        * */
        /* 컴파일 시점에는 Tiger가 아니라 Animal로 판단된다. (an1. 을 해도 Animal 관련 메소드만 나오고 Tiger 메소드는 안나온다) */
        System.out.println("=========== 동적바인딩 확인 ==========");
        an1.howling();
        an2.howling();

        /* 설명. 오버라이딩 되지 않은(자식에서 추가하거나 확장한 메소드) 메소드 호출은 다운캐스팅을 해 주어야 한다. */
        /* 필기.
         *  instanceof란?
         *   해당 객체의 타입을 런타임 시점에 확인하기 위한 연산자;
        * */
        if(an1 instanceof Tiger) {      // an1은 Tiger 타입의 인스턴스 입니까
            ((Tiger) an1).bite();
        }
        if(an1 instanceof Rabbit) {
            ((Rabbit)an1).jump();
        }

        /* 설명. 다형성은 상속관게의 객체들간에 형변환*/
        Animal animal2 = new Tiger(); // 자동형변환(auto up-casting), 다형성, 묵시적 형변환
        Rabbit rabbit2 = (Rabbit)an2; // 강제 형변환(down-casting), 다형성 x, 명시적 형변환
    }
}
