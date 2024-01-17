package com.ohgiraffers.section05.parameter;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ParameterTest {


    public void testPrimitiveTypeParameter(int num) {
        num = 10;
        System.out.println("매개변수로 전달받은 값: " + num );
    }

    public void testPrimitiveTypeArrayParameter(int[] iArr) {
        iArr[0] = 8;
    }

    public void testClassTypeParameter(Rectangle rectangle) {

        /* 설명. 전달받은 사각형의 넓이와 둘레 출력 */
        System.out.println("========== 변경 전 사각형의 넓이와 둘레 ==========");
        rectangle.calArea();
        rectangle.calRound();

        /* 설명. 전달받은 사각형의 너비와 높이를 변경 */
        rectangle.setWidth(20);
        rectangle.setHeight(40);

        /* 설명. 변경 후 사각형의 넓이와 둘레 출력 */
        System.out.println("========== 변경 후 사각형의 넓이와 둘레 ==========");
        rectangle.calArea();
        rectangle.calRound();

    }


    public void testVariableLengthArrayParameter(String... str) {
        System.out.println(Arrays.toString(str));

    }
}
