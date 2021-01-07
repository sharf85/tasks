import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution sequence = new Solution();
    //{5,-3,5,-3,5} -> true
    @Test
    public void testCheckSequence_seqOdd_true() {
        List<Integer> list = Arrays.asList(5, -3, 5, -3, 5);
        boolean actual = sequence.isSwitching(list);
        assertTrue(actual);
    }
    //{5,-3,5,-3,5,-3} -> true
    @Test
    public void testCheckSequence_seqEven_true() {
        List<Integer> list = Arrays.asList(5, -3, 5, -3, 5, -3);
        boolean actual = sequence.isSwitching(list);
        assertTrue(actual);
    }
    //{5,-3} -> true
    @Test
    public void testCheckSequence_seq2_true() {
        List<Integer> list = Arrays.asList(5, -3);
        boolean actual = sequence.isSwitching(list);
        assertTrue(actual);
    }
    //{5} -> true
    @Test
    public void testCheckSequence_seq1_true() {
        List<Integer> list = Arrays.asList(5);
        boolean actual = sequence.isSwitching(list);
        assertTrue(actual);
    }
    //{5,-3,1,-3,5} -> false
    @Test
    public void testCheckSequence_seq_false() {
        List<Integer> list = Arrays.asList(5, -3, 1, -3, 5);
        boolean actual = sequence.isSwitching(list);
        assertFalse(actual);
    }
    //{5,-3,1,1,5} -> false
    @Test
    public void testCheckSequence_seq2_false() {
        List<Integer> list = Arrays.asList(5, -3, 1, 1, 5);
        boolean actual = sequence.isSwitching(list);
        assertFalse(actual);
    }

    @Test
    void testSwitchArray_true(){
        Solution arr=new Solution();
        int[] array=new int[]{1,3,1,3,1,3};
        assertTrue(arr.isSwitching(array));
        int[] array1=new int[]{1,3,1,3,1,};
        assertTrue(arr.isSwitching(array1));
        int[] array2=new int[]{};
        assertTrue(arr.isSwitching(array1));
        int[] array3=new int[]{1};
        assertTrue(arr.isSwitching(array1));
    }
    @Test
    void testSwitchArray_false(){
        Solution arr=new Solution();
        int[] array2=new int[]{1,2,1,3};
        assertFalse(arr.isSwitching(array2));
        int[] array3=new int[]{2,6,1,6};
        assertFalse(arr.isSwitching(array3));
    }
}
