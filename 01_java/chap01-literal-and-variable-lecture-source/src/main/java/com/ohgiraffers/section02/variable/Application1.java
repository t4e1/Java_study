package com.ohgiraffers.section02.variable;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 변수의 사용 목적에 대해 이해할 수 있다. */
        /* soutv + 엔터를 치면 사용한 변수를 바로 print 할 수 있다.*/
        /* 필기.
         *  변수의 사용 목적
         *    1. 값에 의미를 부여하기 위한 목적 (의미 전달이 쉬워야 코드를 읽기 쉬워지고, 협업 및 유지보수에 유리하기 때문)
         *    2. 한 번에 저장해둔 값을 재사용 하기 위한 목적 (변수를 이용하여 코드를 작성하면, 값을 변경할 때도 보다 간편하게 변경이 가능)
         *    3. 시간에 따라 변하는 값을 저장하고 사용할 수 있다. (변하는 값을 저장하기 위한 공간)
         *    -> 변수의 사용은 재사용성, 유지보수성, 가독성을 향상시킬 수 있다
        * */

        /* 목차. 1. 값에 의미를 부여하기 위한 목적 */
        System.out.println("========== 값에 의미 부여 테스트 ==========");
        System.out.println("보너스를 포함한 급여: " + (1000000 + 200000) + '원'); // 1000000, 200000 이 무슨 숫잔지 작성자 말고는 모름

        int salary = 1000000;
        int bonus = 200000;
        System.out.println("보너스를 포함한 급여: " + (salary + bonus) + '원');   // 숫자가 salary&bonus 를 의미한다는 것을 다른 사람도 알 수 있음


        /* 목차. 2. 한 번에 저장해둔 값을 재사용하기 위한 목적 */
        System.out.println("========== 저장된 값 재사용 테스트 ==========");

        /* 설명. 10명의 고객에게 100 포인트를 지급해주는 내용을 출력하도록 작성 */
        System.out.println("1번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("2번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("3번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("4번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("5번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("6번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("7번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("8번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("9번 고객에게 포인트를 100포인트 지급하였습니다.");
        System.out.println("10번 고객에게 포인트를 100포인트 지급하였습니다.\n");           // 고객 숫자에 따라서 100이라는 변수를 계속 사용해줘야 한다.
        // '\n'은 엔터를 의미
        /* 설명. 공통적으로 사용된 100이라고 하는 값을 변수에 넣고 변수를 호출하여 코드를 개선 */
        int point = 100;                                                            // 만약 point 가 변경된다하더라도, point 변수의 값만 변경시켜주면 되기 때문에 유지보수나 수정도 쉬워진다.
        System.out.println("1번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("2번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("3번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("4번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("5번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("6번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("7번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("8번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("9번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");
        System.out.println("10번 고객에게 포인트를 " + point + "포인트 지급하였습니다.");

        /* 목차. 3. 시간에 따라 변하는 값을 저장하고 사용 할 목적 */
        System.out.println("========== 변수에 저장된 값 변경 테스트 ==========");
        int sum = 0;

        sum = sum + 10;                                                     // 기존에 0이 담겨있던 변수에 10을 덮어씀 (변수는 하나의 리터럴만 저장 가능)
        System.out.println("sum에 10을 더하면 현재 sum의 값은 : " + sum);

        sum = sum + 10;
        sum = sum + 10;
        sum = sum + 10;
        sum = sum + 10;
        sum = sum + 10;
        System.out.println("sum에 10을 5번 더하면 현재 sum의 값은 : " + sum);

        /* 설명. 동일한 sum이라는 하나의 변수를 어느 시점에 출력하느냐에 따라 출력 결과는 달라진다. (변수명은 같지만 들어있는 값은 달라짐) */

    }
}
