package Medium;
public class ZigZagConversion {
    public ZigZagConversion(){
        //System.out.println(convert("PAYPALISHIRING",3));
        //System.out.println(convert("PAYPALISHIRING",4));
        //System.out.println(convert("a",1));
        //System.out.println(convert("AB",1));
        System.out.println(convert("AB",3));
    }

    public String convert(String s, int numRows) {
        if("".equals(s) || s.length()==1 || numRows == 1) return s;
        String result = "";
        for(int i = 0; i<numRows; i++){
            int gap1 = (2*numRows-2*(i+1));
            int gap2 = 2*i;
            int cnt = 0;
            int j = i;
            if(j >= s.length()) break;
            result += s.charAt(j);
            while( j<s.length()){
                cnt++;
                if(cnt %2==0){
                    if(gap2 == 0) continue;
                    if(j + gap2 >=s.length()) break;
                    result += s.charAt(j + gap2);
                    j += gap2;
                }else{
                    if(gap1 == 0) continue;
                    if(j + gap1 >=s.length()) break;
                    result += s.charAt(j + gap1);
                    j += gap1;
                }
                
            }
        }
        return result;
    }


    /*
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    
    */
}