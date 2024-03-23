package Hard;

import org.testng.annotations.Test;

public class _273_IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        sb.insert(0, getWordUnderBillion(num));
        if(num <1000000000) return sb.toString();
        
        num /=1000000000;
        int cur = num%1000;
        String temp =  getWordUnderBillion(cur);
        sb.insert(0, temp+(temp.isEmpty()?"":" Billion") + (temp.isEmpty() || sb.length()==0?"":" "));

        return sb.toString();
    }

    private String getWordUnderBillion(int num){
        StringBuilder sb = new StringBuilder();
        sb.insert(0, getWordUnderMillion(num));
        if(num <1000000) return sb.toString();
        
        num /=1000000;
        int cur = num%1000;
        String temp =  getWordUnderMillion(cur);
        sb.insert(0, temp+(temp.isEmpty()?"":" Million") + (temp.isEmpty() || sb.length()==0?"":" "));

        return sb.toString();
    }

    private String getWordUnderMillion(int num){
        StringBuilder sb = new StringBuilder();
        sb.insert(0, getWordUnderThousand(num));
        if(num <1000) return sb.toString();
        
        num /=1000;
        int cur = num%1000;
        String temp =  getWordUnderThousand(cur);
        sb.insert(0, temp+(temp.isEmpty()?"":" Thousand") + (temp.isEmpty() || sb.length()==0?"":" "));

        return sb.toString();
    }

    private String getWordUnderThousand(int num){
        StringBuilder sb = new StringBuilder();
        sb.insert(0, getWordUnderHundred(num));
        if(num <100) return sb.toString();

        num /=100;
        int cur = num%10;

        String temp = getWordUnderHundred(cur);
        sb.insert(0, temp+(temp.isEmpty()?"":" Hundred") + (temp.isEmpty() || sb.length()==0?"":" "));
        return sb.toString();
    }
    private String getWordUnderHundred(int num){
        StringBuilder sb = new StringBuilder();
        String[] words = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] words2 = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num <words.length) return words[num];

        int currentNum = num%100;
        num /=100;

        if(currentNum<words.length)
            sb.insert(0, words[currentNum]);
        else{
            int firstDigit = currentNum%10;
            int secontDigit = currentNum/10;
            sb.insert(0, words2[secontDigit] + (words[firstDigit].isEmpty()?"":" " + words[firstDigit]));
        }

        return sb.toString();
    }

    @Test
    public void test(){
        for(int i = 1001; i<=1001; i++){
            System.out.println(i+": ["+numberToWords(i)+"]");
        }
    }
}
