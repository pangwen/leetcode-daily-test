package rotateArray;

/**
 * <p>
 * Description: 旋转数组： 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *      [3,4,5,1,2],
 * <p>
 * <strong>特别注意： 重复元素问题！！！
 * [1,0,1,1,1,1]
 * </strong>

 * <p>
 * Created on 2021/5/21.
 *
 * @author pangwen
 * @version 0.1
 */
public class RotateArraySolution {

    public static void main(String[] args) {

    }

    public static int minArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        //二分查找：如果中间位置数据大于末尾数据，则最小元素一定在右边， 否则在左边
        int left = 0, right = array.length - 1;
        while(left < right){
            if(array[left] < array[right]){
                return array[left];
            }
            int mid = (left + right) >> 1;
            if(array[mid] < array[right]){
                right = mid;
            }else if(array[mid] > array[left]){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return array[left];
    }

}
