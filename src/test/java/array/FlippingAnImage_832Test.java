package array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-22
 */
class FlippingAnImage_832Test {
    FlippingAnImage_832 flip;

    @BeforeEach
    void setUp() {
        flip = new FlippingAnImage_832();
    }

    @Test
    void flipAndInvertImage() {
        int[][] input = new int[3][3];
        input[0] = new int[]{1, 1, 0};
        input[1] = new int[]{1, 0, 1};
        input[2] = new int[]{0, 0, 0};

        int[][] expected = new int[3][3];
        expected[0] = new int[]{1, 0, 0};
        expected[1] = new int[]{0, 1, 0};
        expected[2] = new int[]{1, 1, 1};

        int[][] res = flip.flipAndInvertImage(input);
        boolean isSame = true;
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] != res[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        assertTrue(isSame);
    }
}