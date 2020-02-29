/**
 * @author jiofeng
 * @date 2020/2/28
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {2};
        new MergeSolution().merge(nums1, 0, nums2, 1);
        for (int i : nums1) {
            System.out.print(i);
        }
    }

}

class MergeSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = 0;
        for (int i = 0; i < nums2.length; i++) {
            int num2 = nums2[i];
            for (int j = insertIndex; j < m + n; j++) {
                if (nums1[j] == 0 && j >= m + i) {
                    insertIndex = j;
                    nums1[j] = num2;
                    break;
                }
                if (nums1[j] <= num2) {
                    continue;
                }
                insertIndex = j;
                move(nums1, insertIndex, m + i);
                nums1[j] = num2;
                break;
            }
        }
    }

    private void move(int[] nums1, int insetIndex, int end) {
        for (int i = end; i > insetIndex; i--) {
            nums1[i] = nums1[i - 1];
        }
    }
}

class OthersMergeSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}
