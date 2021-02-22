package Medium;
public class LongestPalindromic {

    public LongestPalindromic() {
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bbbbb"));
        System.out.println(longestPalindrome("bbbb"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("aaabbb"));
        System.out.println(longestPalindrome("abccba"));
    }

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String palin = getPalindrome(s, i);
            result = result.length() < palin.length() ? palin : result;
        }
        return result;
    }

    public String getPalindrome(String s, int i) {
        int dis = 1;
        String r1="", r2="";
        if (s.length() - 1 == i)
            return s.substring(i,i+1);

        if (i>0 && s.charAt(i - 1) == s.charAt(i + 1)) {
            while (i - dis >= 0 && i + dis < s.length() && s.charAt(i - dis) == s.charAt(i + dis)) {
                dis++;
            }
            r1 = i - dis + 1 >= 0 && i + dis - 1 < s.length() ? s.substring(i - dis + 1, i + dis) : "";
        }
        dis = 1;
        if (s.charAt(i) == s.charAt(i + 1)) {
            while (i - dis >= 0 && i + 1 + dis < s.length() && s.charAt(i - dis) == s.charAt(i + 1 + dis)) {
                dis++;
            }
            r2 = i - dis + 1 >= 0 && i + dis - 1 < s.length() ? s.substring(i - dis + 1, i + dis + 1) : "";
        } 
        if("".equals(r1) && "".equals(r2)) return s.substring(i,i+1);
        else return r1.length() > r2.length()? r1:r2;
    }
}


/*
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}


*/