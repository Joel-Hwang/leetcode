package Easy;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums){
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}
