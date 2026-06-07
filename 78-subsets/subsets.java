import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    void dfs(int i, int[] nums, List<Integer> curr) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        // take
        curr.add(nums[i]);
        dfs(i + 1, nums, curr);
        curr.remove(curr.size() - 1);
        
        // not take
        dfs(i + 1, nums, curr);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        
        // lexicographical order
        // Collections.sort(res, (a, b) -> {
        //     int i = 0;
        //     while (i < a.size() && i < b.size()) {
        //         if (!a.get(i).equals(b.get(i)))
        //             return a.get(i) - b.get(i);
        //         i++;
        //     }
        //     return a.size() - b.size();
        // });
        
        return res;
    }
}