package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yancy3@lenovo.com
 * created on 2019-03-04
 */
public class ReverseInteger_7_Test {
    ReverseInteger_7 reverseInteger7 = new ReverseInteger_7();

    @Test
    public void should_return_321() {
        Assert.assertEquals(321, reverseInteger7.reverseInterger(123));

    }

    @Test
    public void should_return_negative_321() {
        Assert.assertEquals(-321, reverseInteger7.reverseInterger(-123));
    }

    @Test
    public void should_return_0_when_out_of_range() {
        Assert.assertEquals(0, reverseInteger7.reverseInterger(Integer.MAX_VALUE + 1));
        Assert.assertEquals(0, reverseInteger7.reverseInterger(Integer.MIN_VALUE - 1));
    }
}