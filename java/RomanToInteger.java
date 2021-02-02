public class RomanToInteger {
    public RomanToInteger(){
        romanToInt("IV");
    }

    public int romanToInt(String s) {
        int[] arS = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'I':
                    arS[i] = 1;
                break;
                case 'V':
                    arS[i] = 5;
                break;
                case 'X':
                    arS[i] = 10;
                break;
                case 'L':
                    arS[i] = 50;
                break;
                case 'C':
                    arS[i] = 100;
                break;
                case 'D':
                    arS[i] = 500;
                break;
                case 'M':
                    arS[i] = 1000;
                break;
            }
        }

        int result = 0;
        for(int i = 0; i<arS.length-1; i++){
            if(arS[i] < arS[i+1]){
                result -= arS[i];
            }else{
                result += arS[i];
            }
        }
        return result + arS[arS.length-1];
    }
}
