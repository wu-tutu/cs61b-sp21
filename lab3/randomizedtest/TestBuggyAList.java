package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeMove(){
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int[] nums = {4, 5, 6};
        for(int i = 0; i < 3; i++){
            aListNoResizing.addLast(nums[i]);
            buggyAList.addLast(nums[i]);
        }
        for(int j = 0; j < 3; j++){
            int a = aListNoResizing.removeLast();
            int b = buggyAList.removeLast();
            assertEquals(a,b);
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> A = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                A.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int aSize = A.size();
                int bSize = B.size();
                assertEquals(aSize,bSize);
                System.out.println("size: " + aSize);
            } else if (operationNumber == 2) {
                //getLast
                if(A.size() > 0 && B.size() > 0){
                    int aLast = A.getLast();
                    int bLast = B.getLast();
                    assertEquals(aLast,bLast);
                }
            } else if (operationNumber == 3) {
                if(A.size() > 0 && B.size() > 0){
                    int aLast = A.removeLast();
                    int bLast = B.removeLast();
                    assertEquals(aLast,bLast);
                }
            }
        }
    }
}
