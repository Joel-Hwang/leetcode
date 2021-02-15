package Medium;
public class IntegerToRoman {
    public IntegerToRoman(){
        System.out.println(intToRoman(3));
    }

    public String intToRoman(int num){
        String[] sym = {"I","X","C","M"};
        String[] sym5 = {"V","L","D"};
        String result = "";

        int pow = 0;
        while(num>0){
            int rem = num%10;
            if(rem < 4){
                for(int i = 0; i<rem; i++){
                    result = sym[pow] + result;
                }
            }else if(rem == 4){
                result =  sym[pow] + sym5[pow] + result;
            }else if(rem == 5){
                result = sym5[pow] + result;
            }else if(rem == 9){
                result = sym[pow] + sym[pow+1] + result;
            }else{
                String sub = sym5[pow];
                for(int i = 0; i<rem-5; i++){
                    sub+= sym[pow];
                }
                result = sub + result;
            }
            num /= 10;
            pow++;
        }
        
        
        return result;
    }
    
    /*
int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
    
    for(int i=0;i<values.length;i++) {
        while(num >= values[i]) {
            num -= values[i];
            sb.append(strs[i]);
        }
    }
    return sb.toString();
}
    
    */
}
