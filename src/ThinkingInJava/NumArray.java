package ThinkingInJava;

/**
 * Created by rarshion on 16/9/11.
 */
public class NumArray {

    private int[] temp;
    private int[] ret;
    private int len;

    public NumArray(int[] nums) {
        this.len = nums.length;
        this.temp = nums;
        ret = new int[len+1];

        for(int index = 1; index <= len; index++){
            int sum = 0;
            int count = 1;
            int counter = lowBits(index);

            while(count <= counter){
                sum += temp[index - count];
                count++;
            }

            ret[index] = sum;
        }
    }


    private int lowBits(int pos){
        return pos & (-pos);
    }


    void update(int i, int value) {
        int gap = value - temp[i];
        temp[i] = value;
        int index = i + 1;

        while(index <= len){
            ret[index] += gap;
            index += lowBits(index);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }

    private int sum(int index){
        int sum = 0;
        while(index > 0){
            sum += ret[index];
            index -= lowBits(index);
        }
        return sum;
    }

    public static void main(String[] args){
        int[] temp = {1,2,3,4};
        NumArray test= new NumArray(temp);
        int hello = test.sumRange(0,3);
    }
}
