package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coco-xsj on 2017/12/16.
 */
public class FindAllDuplicatesinanArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rr = new ArrayList<Integer>();
        int len = nums.length;
        for (int m:nums) {
            if (nums[Math.abs(m)-1]>0){
                nums[Math.abs(m)-1]*=-1;

            }else {
                rr.add(Integer.valueOf(Math.abs(m)));
            }
        }

        return rr;
    }
}
