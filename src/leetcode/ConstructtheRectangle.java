package leetcode;

/**
 * Author ： Martin
 * Date : 17/4/23
 * Description :
 * Version : 2.0
 */
public class ConstructtheRectangle {

    public int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        int w = (int) Math.sqrt(area);
        while((l * w) != area) {
            if (l * w < area) {
                l++;
            } else {
                w--;
            }
        }
        int[] result = new int[2];
        result[0] = l;
        result[1] = w;
        return result;
    }
}
