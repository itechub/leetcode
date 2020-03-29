/**
 * @author jiofeng
 * @date 2020/3/29
 */
public class MaxArea {
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = new MaxAreaSolution().maxArea(height);
        System.out.println(maxArea);
    }
}

class MaxAreaSolution {
    public int maxArea(int height[]) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int width = j - i;
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max(maxArea, width * minHeight);
        }
        return maxArea;
    }
}
