import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jiofeng
 * @date 2020/3/3
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, -1};
        int[] res = new MaxSlidingWindowSolution().maxSlidingWindow(nums, 3);
        for (int num : res) {
            System.out.println(num);
        }
    }
}

class MaxSlidingWindowSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        // init deque
        for (int i = 0; i < k; i++) {
            putInDeque(deque, nums, i, k);
        }
        int[] resIndexes = new int[nums.length - k + 1];
        for (int i = k; i < nums.length; i++) {
            resIndexes[i - k] = deque.peekFirst();
            putInDeque(deque, nums, i, k);
        }
        // last one
        resIndexes[resIndexes.length - 1] = deque.peekFirst();
        // construct result
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < resIndexes.length; i++) {
            res[i] = nums[resIndexes[i]];
        }
        return res;
    }

    private void putInDeque(Deque<Integer> deque, int[] nums, int i, int k) {
        if (deque.isEmpty()) {
            deque.add(i);
            return;
        }
        // window is full
        if (i - deque.peekFirst() == k) {
            deque.pollFirst();
        }
        if (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]) {
            deque.clear();
        }
        // poll the num in deque of loe num
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();
        }
        deque.add(i);
    }
}
