package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class _1239_MaximumLengthConcatenatedStringwithUniqueCharacters {
    int res = 0;

    // 4C1, 4C2, 4C3, 4C4를 다 계산하다 보니까 중복이 발생. 4C1에서 다 계산한걸 4C2에서 다시 계산
    public int maxLength(List<String> arr) {
        for (int i = 1; i <= arr.size(); i++) {
            rec(arr, new StringBuilder(), 0, i);
        }

        return res;
    }

    private void rec(List<String> arr, StringBuilder p, int start, int c) {
        if (c == 0) {
            if (isUniqueChars(p.toString()))
                res = Math.max(res, p.length());
            return;
        }

        for (int i = start; i < arr.size() - c + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(p);
            sb.append(arr.get(i));
            rec(arr, sb, i + 1, c - 1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    int res2 = 0;

    public int maxLength2(List<String> arr) {
        rec2(arr, new StringBuilder(), 0);
        return res2;
    }

    private void rec2(List<String> arr, StringBuilder path, int start) {
        boolean isUniq = isUniqueChars(path.toString());
        if (isUniq)
            res2 = Math.max(path.length(), res2);
        if (start >= arr.size() || !isUniq)
            return;

        for (int i = start; i < arr.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append(arr.get(i));
            rec2(arr, sb, i + 1);
        }

    }

    @Test
    public void test() {
        ArrayList<String> a = new ArrayList<>();
        a.add("cha");
        a.add("r");
        a.add("act");
        a.add("ers");
        int ans = maxLength2(a);
        System.out.println(ans);
    }
}
