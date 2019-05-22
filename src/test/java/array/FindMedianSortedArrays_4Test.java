package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-03
 */
public class FindMedianSortedArrays_4Test {
    private FindMedianSortedArrays_4 find;

    @Before
    public void setUp() {
        find = new FindMedianSortedArrays_4();
    }

    @Test
    public void should_return_2() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        Assert.assertEquals(2.0, find.findMedianSortedArrays(nums1, nums2), 0);
    }

    @Test
    public void should_return_2_point_5() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        Assert.assertEquals(2.5, find.findMedianSortedArrays(nums1, nums2), 0);
    }
}