package info.dmerej;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    final Calculator calculator = new Calculator();

    @AfterAll
    static void afterAll() {

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_values.csv", numLinesToSkip = 1)
    void given_source_value_when_RPNEvaluation_return_good_result(String input, double expected) {
        assertThat(
                calculator.RPNEvaluation(input)
        ).isEqualTo(expected);
    }


    @Disabled("Error not handle")
    @Test
    void given_2_floating_numbers_when_RPNEvaluation_then_null() {
        //given
        final String value = "1.3 5.5 +";

        //When
        final Double result = calculator.RPNEvaluation(value);

        //then
        assertThat(result).isNull();
    }

    @Disabled("WIP verifyExpression")
    @Test
    void given_2_int_numbers_1_operator_in_middle_when_verifyExpression_then_should_throw() {
        //given
        final String value = "1 + 3";

        //When
        final Double result = calculator.RPNEvaluation(value);

        //assertThat(exception.getMessage()).isEqualTo("Expecting two integers arguments");
    }

    @Disabled("WIP verifyExpression")
    @Test
    void given_3_int_numbers_0_operator_when_verifyExpression_then_should_throw() {
        //given
        final String value = "1 1 3";

        //When
        final Double result = calculator.RPNEvaluation(value);

        //assertThat(exception.getMessage()).isEqualTo("Expecting an operator as the 3rd argument");
    }

    @Disabled("WIP verifyExpression")
    @Test
    void given_bad_model_operator_when_verifyExpression_then_should_throw() {
        //given
        final String value = "1 3 + 6 - 5 5 +";

        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.verifyExpression(value));

        assertThat(exception.getMessage()).isEqualTo("Expecting (integer, operator) pattern");
    }

    @Test
    void given_by_zero_division_when_RPNEvaluation_then_should_throw() {
        //given
        final String value = "1 3 + 6 - 0 /";

        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.RPNEvaluation(value));

        assertThat(exception.getMessage()).isEqualTo("/ by zero");
    }

    @Disabled("WIP verifyExpression")
    @Test
    void given_good_model_operator_when_verifyExpression_then_should_not_throw() {
        //given
        final String value = "1 3 + 6 - 5 / 5 +";

        assertDoesNotThrow(() -> calculator.verifyExpression(value));
    }


    @Disabled("WIP verifyExpression")
    @Test
    void given_two_int_no_operand_when_verifyExpression_then_should_throw_exception() {
        final String value = "1 3";

        assertThrows(NumberFormatException.class, () -> calculator.verifyExpression(value));
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
    void given_double_as_string_when_isDouble_then_return_true() {
        String value = "1.4";

        final Boolean result = calculator.isDouble(value);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void given_not_double_as_string_when_isDouble_then_return_false() {
        String value = "h";

        final Boolean result = calculator.isDouble(value);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void given_int_as_string_when_isDouble_then_return_true() {
        String value = "1";

        final Boolean result = calculator.isDouble(value);

        //then
        assertThat(result).isTrue();
    }
}

