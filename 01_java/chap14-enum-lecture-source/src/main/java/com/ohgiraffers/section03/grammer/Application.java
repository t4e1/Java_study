package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. Enum의 문법에 대해 이해하고 활용할 수 있다.(클래스적인 면모를 보여줌) */
        /* 필기.
         *  enum 타입의 필드는 최초 사용 시에만 열거 타입의 인스턴스를 하나 생성하고 이후에는 생성자를
         *  호출하지 않는다.
         *  또한, enum 타입은 set으로 바꿔 반복시키며 필드들을 한번에 확인하고 활용할 수도 있다.
        * */
        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin);
        System.out.println(admin.getNameToLowerCase());

        UserRole2 consumer = UserRole2.CONSUMER;
        System.out.println(consumer.ordinal() + ", " + consumer.name() + ", " + consumer.getDescription()); // ordinal 을 통해 순번을 볼 수 있고, name 을 통해 필드 이름을 확인할 수도 있다.

        System.out.println("Set으로 바꿔 반복자를 활용해 보자.");
        System.out.println("===================================================");
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);
        Iterator<UserRole2> iter = roles.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().name());
        }
    }
}
