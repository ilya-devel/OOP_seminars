package sem2.tsk2;

public class IcountD implements Icount{
    public static void main(String[] args) {
        int[] nums = new int[MAX];
        for (int i = 0; i < 11; i++) {
            if (i >= MAX) {
                System.out.println(ERROR);
            } else {
                nums[i] = i;
                System.out.println(nums[i] + " ");
            }
        }
    }
}
