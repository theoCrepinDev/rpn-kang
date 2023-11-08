package info.dmerej;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

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
        final Integer result = calculator.execute(value);

        //Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(15);
    }

    @Test
    void given_2_floating_numbers_when_execute_then_null() {
        //given
        final String value = "1.3 5.5 +";

        //When
        final Integer result = calculator.execute(value);

        //then
        assertThat(result).isNull();
    }

    @Test
    void given_1_int_numbers_when_execute_then_null() {
        //given
        final String value = "5 +";

        //When
        final Integer result = calculator.execute(value);

        //then
        assertThat(result).isNull();
    }

    @Test
    void given_2_int_numbers_1_operator_in_middle_when_execute_then_null() {
        //given
        final String value = "1 + 3";

        //When
        final Integer result = calculator.execute(value);

        //then
        assertThat(result).isNull();
    }
}
