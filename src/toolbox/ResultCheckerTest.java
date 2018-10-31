package toolbox;

import com.chunks.mylib.TestCaseGenerator.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author chongyang18@gmail.com
 * @date 13/04/2018
 */
public class ResultCheckerTest {
    /**
     * 声明（为null）：输出流 (字符设备) console
     */
    private PrintStream console = null;
    /**
     * 声明（为null）：bytes 用于缓存console 重定向过来的字符流
     */
    private ByteArrayOutputStream bytes = null;
    private int[] arr = new int[10000];
    private int[] arrCopy = new int[10000];
    private int[] sortedArr = new int[10000];

    @Before
    public void setUp() throws Exception {
        // 分配空间
        bytes = new ByteArrayOutputStream();
        // 获取System.out 输出流的句柄
        console = System.out;
        // 将原本输出到控制台Console的字符流 重定向 到 bytes
        System.setOut(new PrintStream(bytes));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000) - new Random().nextInt(10000);
            sortedArr[i] = arr[i];
            arrCopy[i] = arr[i];
        }
        Arrays.sort(sortedArr);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void isIntArrayEqual() {
        assertTrue(ResultChecker.isIntArrayEqual(arrCopy, arr));
        assertFalse(ResultChecker.isIntArrayEqual(sortedArr, arr));
    }

    @Test
    public void isIntArraySorted() {
        assertTrue(ResultChecker.isIntArraySorted(sortedArr));
        assertFalse(ResultChecker.isIntArraySorted(arr));
    }

    @Test
    public void linkedListPrinter() {
        int testSize = 10000;
        Node node = TestCaseGenerator.linkedListFromOneToLength(testSize);
        ResultChecker.linkedListPrinter(node);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= testSize; i++) {
            if(i != testSize) {
                sb.append(i).append("->");
            }else {
                sb.append(i);
            }
        }
        String s = sb.toString();
        assertEquals(s, bytes.toString());

    }
}