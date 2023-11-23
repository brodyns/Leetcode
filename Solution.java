import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); // 升序
        List<int[]> merged = new LinkedList<>();
        for(int i = 0; i < intervals.length; i++){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < L){
                merged.add(new int[]{L, R});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[0][2]);
    }
}
