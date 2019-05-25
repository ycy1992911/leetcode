package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-25
 */
@ExtendWith(MockitoExtension.class)
class RemoveOutermostParentheses_1021Test {
    @Spy
    private RemoveOutermostParentheses_1021 remove;

    @Test
    void should_return_empty_when_input_is_empty() {
        //given
        String input = "";

        //then
        assertEquals("", remove.removeOuterParentheses(input));

        //verify
        verify(remove, times(1)).removeOuterParentheses(input);
    }

    @Test
    void should_return_empty_when_input_is_null() {
        //given
        String input = null;

        //then
        assertEquals("", remove.removeOuterParentheses(input));

        //verify
        verify(remove, times(1)).removeOuterParentheses(input);
    }

    @Test
    void should_return_empty_when_input_has_only_one_level() {
        //given
        String input = "()()";

        //then
        assertEquals("", remove.removeOuterParentheses(input));

        //verify
        verify(remove, times(1)).removeOuterParentheses(input);
    }

    @Test
    void should_return_three_pair_of_parentheses() {
        //given
        String input = "(()())(())";

        //then
        assertEquals("()()()", remove.removeOuterParentheses(input));

        //verify
        verify(remove, times(1)).removeOuterParentheses(input);
    }

    @Test
    void should_return_empty_when_no_2nd_level_parentheses() {
        //given
        String input = "(()())(())(()(()))";

        //then
        assertEquals("()()()()(())", remove.removeOuterParentheses(input));

        //verify
        verify(remove, times(1)).removeOuterParentheses(input);

    }
}