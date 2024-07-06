package Easy;

public class _1342_NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int result = 0;

        while(num>0){
            result++;
            if(num%2==1){
                num--;
                continue;
            }
            num /= 2;
        }
        return result;
    }
}
