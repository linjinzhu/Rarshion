package leetcode;

/**
 * Author ： Martin
 * Date : 17/8/27
 * Description :
 * Version : 2.0
 */
public class CanPlaceFlowers {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int oNum = 0, zNum = 0;
        for (int i : flowerbed) {
            if (i == 0) {
                zNum++;
            } else if (i == 1) {
                oNum++;
            }
        }
        return (oNum + n - 1) <= zNum;
    }
}
