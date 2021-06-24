package leetcode;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMaxWater {

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        int rightPointer = height.length - 1, leftPointer = 0;

        while (leftPointer < rightPointer && leftPointer < height.length && rightPointer > 0) {
            int leftRod = height[leftPointer];
            int rightRod = height[rightPointer];

            // Current Area
            int area = Math.min(leftRod, rightRod) * (rightPointer - leftPointer);

            // Get Max Area
            maxArea = Math.max(maxArea, area);

            // move forward if the next rod height is more than minimum rod length
            if ((leftPointer + 1) < height.length && height[leftPointer] < height[leftPointer + 1]) {
                ++leftPointer;
            } else if ((rightPointer - 1) > 0 && height[rightPointer] < height[rightPointer - 1]) {
                --rightPointer;
            } else {
                break;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMaxWater maxWater = new ContainerWithMaxWater();
        System.out.println(maxWater.maxArea(new int[]{2,3,4,5,18,17,6}));
        System.out.println(maxWater.maxArea(new int[]{1,3,2,5,25,24,5}));
    }
}
