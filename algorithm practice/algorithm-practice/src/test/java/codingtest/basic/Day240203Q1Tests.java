package codingtest.basic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Day240203Q1Tests {

    private static String input1, input2, input3;
    private static double output1, output2, output3;

    @BeforeAll
    public static void set () {

        input1 = "3\n" +
                "40 80 60";
        output1 = 75.0;
        input2 = "3\n" +
                "10 20 30";
        output2 = 66.666667;
        input3 = "4\n" +
                "1 100 100 100";
        output3 = 75.25;

    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2),
                arguments(input3, output3)
        );
    }

    @DisplayName("평균 조작 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void arraysTest(String input, Double output) throws Exception {
        double result = Day240203Q1.solution(input);
        Assertions.assertEquals(output, result, 0.01);

    }

}
