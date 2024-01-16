package com.testcomapany.section01.array;

import java.util.Arrays;

public class Application01 {

    /* 배열 복습 */
    /* 하나의 변수에 여러 자료값을 담을 수 없을까 에서 시작
     * -> 변수 관리가 용이해진다. & 코드가 깔끔해진다
     * 배열은 참조자료형. RAM 에 저장되며 stack 이랑 heap을 사용한다.
     * stack : 변수와 메소드가 올라가는 공간
     * heap  : 참조자료형의 실제 데이터가 올라가는 공간
     * 배열을 선언하는 부분에서 stack 에 공간이 할당되고, 크기를 대입하면서 heap 에 공간을 할당한다.
     * 이후 실제 데이터가 저장되어있는 주소값이 stack에 있는 배열 변수에 저장된다
     * heap에 올라가는 순간부터 배열은 기본값을 가지게 된다
     * (별도의 데이터 입력 없이도 각 데이터 타입의 기본값이 입력됨)
     * */
    public static void main(String[] args) {

        /* 배열의 기본 형태 */
        int[] arr = new int[5];                 // int arr[] 의 형태로 변수명에 대괄호를 붙여도 선언은 가능하다. 다만 지양할 것

        /* 배열 사용시 주의 사항 */
        /* 1. 하나의 배열에는 같은 데이터 타입만 저장 가능하다
         * 2. 배열을 선언할 때 무조건 크기를 지정해줘야 한다 ( new int[5]와 같이 )
        * */

        /* 배열에 입력된 값 확인 */
        /* 1. Arrays.toString 메소드 사용*/
        System.out.println(Arrays.toString(arr));

        /* 2. for 반복문을 통한 출력 */
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        /* 3. for each 문을 통한 출력 */
        for (int i : arr ){
            System.out.println(i);
        }
    }
}
