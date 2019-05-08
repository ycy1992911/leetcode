package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yancy3@lenovo.com
 * created on 2019-04-28
 */
public class ThreeSumTest {
    private int[] arr;
    private ThreeSum ts = new ThreeSum();

    @Test
    public void should_return_distinct_result() {
        arr = new int[]{0, 0, 0, 0, 0, 0};
        List res = ts.threeSum(arr);
        Assert.assertEquals(Arrays.asList(0, 0, 0), res.get(0));
    }

    @Test
    public void should_return_000() {
        arr = new int[]{0, 0, 0};
        List res = ts.threeSum(arr);
        Assert.assertEquals(Arrays.asList(0, 0, 0), res.get(0));
    }

    @Test
    public void should_return_empty_for_all_negative_integer() {
        arr = new int[]{-1, -1, -1};
        List res = ts.threeSum(arr);
        Assert.assertTrue(res.isEmpty());
    }

    @Test
    public void should_return_empty_for_all_positive_integer() {
        arr = new int[]{1, 1, 1};
        List res = ts.threeSum(arr);
        Assert.assertTrue(res.isEmpty());
    }

    @Test
    public void should_return_a_list_with_two_elements() {
        arr = new int[]{-1, 0, 1, 2, -1, -4};
        List res = ts.threeSum(arr);
        System.out.println(res);
        Assert.assertEquals(2, res.size());
        Assert.assertTrue(res.contains(Arrays.asList(-1, 0, 1)));
        Assert.assertTrue(res.contains(Arrays.asList(-1, -1, 2)));
    }

    @Test
    public void should_return_empty_for_empty_input() {
        arr = new int[]{};
        List res = ts.threeSum(arr);
        Assert.assertTrue(res.isEmpty());
    }


    @Test
    public void should_return_empty_for_empty_input1() {
        arr = new int[]{1, -1};
        List res = ts.threeSum(arr);
        Assert.assertTrue(res.isEmpty());
    }
}