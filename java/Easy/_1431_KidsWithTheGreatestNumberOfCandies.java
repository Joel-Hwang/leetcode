package Easy;
import java.util.*;
public class _1431_KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for(int candy : candies) max = Math.max(max,candy);
        for(int candy : candies) res.add(candy+extraCandies >= max);
        return res;
    }
}
