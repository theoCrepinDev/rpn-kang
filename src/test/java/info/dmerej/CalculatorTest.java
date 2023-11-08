package info.dmerej;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    final Calculator calculator = new Calculator();

    @AfterAll
    static void afterAll() {

    }

    @Test
    void given_2_int_1_plus_when_execute_then_should_return_addition() {
        //Given
        final String value = "12 3 +";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(15);
    }

    @Disabled("Error not handle")
    @Test
    void given_2_floating_numbers_when_execute_then_null() {
        //given
        final String value = "1.3 5.5 +";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //then
        assertThat(result).isNull();
    }

    @Disabled("Error not handle")
    @Test
    void given_1_int_numbers_when_execute_then_null() {
        //given
        final String value = "5 +";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //then
        assertThat(result).isNull();
    }

    @Disabled("Error not handle")
    @Test
    void given_2_int_numbers_1_operator_in_middle_when_execute_then_null() {
        //given
        final String value = "1 + 3";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //then
        assertThat(result).isNull();
    }

    @Test
    void given_int_as_string_when_isInteger_then_return_true() {
        String value = "1";

        final Boolean result = calculator.isInteger(value);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void given_not_int_as_string_when_isInteger_then_return_false() {
        String value = "h";

        final Boolean result = calculator.isInteger(value);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void given_2_int_1_minus_when_execute_then_should_return_subtraction() {
        //Given
        final String value = "12 3 -";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(9);
    }

    @Test
    void given_3_int_1_minus_1_plus_when_execute_then_should_return_result() {
        //Given
        final String value = "12 3 - 4 +";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(13);
    }

    @Test
    void given_3_int_2_plus_when_execute_then_should_return_result() {
        //Given
        final String value = "12 3 + 4 +";

        //When
        final Integer result = calculator.RPNEvaluation(value);

        //Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(19);
    }
}

