package Hard;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class _1622_FancySequence {
    class Fancy {
        
        ArrayList<Data> opList;
        ArrayList<Integer> nums;
        public Fancy() {
            opList = new ArrayList<>();
            nums = new ArrayList<>();
        }
        
        public void append(int val) {
            nums.add(val);
        }
        
        public void addAll(int inc) {
            opList.add(new Data('+',inc,nums.size()));
        }
        
        public void multAll(int m) {
            opList.add(new Data('*',m,nums.size()));
            
        }
        
        public int getIndex(int idx) {
            if(idx >= nums.size()) return -1;

            int initVal = nums.get(idx);
            for(Data dt : opList){
                if(dt.length > idx){
                    initVal = cal(dt.op, dt.number, initVal);        
                }
            }
            return initVal;
        }

        private int cal(char op, int number, long value){
            if(op == '+'){
                long val = value + number;
                return (int)((val)%(int)(1e9 + 7));
            } 
            if(op == '*') {
                long val = value * number;
                return (int)((val)%(int)(1e9 + 7));
            }
            return 0;
        }
    }

    class Data{
        char op;
        int number;
        int length;
        public Data(char op, int number, int length){
            this.op = op;
            this.number = number;
            this.length = length;
        }
    }


    @Test
    public void test(){
        String[] cmd = 
        {"Fancy","append","append","getIndex","append","getIndex","addAll","append","getIndex","getIndex","append","append","getIndex","append","getIndex","append","getIndex","append","getIndex","multAll","addAll","getIndex","append","addAll","getIndex","multAll","getIndex","multAll","addAll","addAll","append","multAll","append","append","append","multAll","getIndex","multAll","multAll","multAll","getIndex","addAll","append","multAll","addAll","addAll","multAll","addAll","addAll","append","append","getIndex"};
        int[][] arg = {{},{12},{8},{1},{12},{0},{12},{8},{2},{2},{4},{13},{4},{12},{6},{11},{1},{10},{2},{3},{1},{6},{14},{5},{6},{12},{3},{12},{15},{6},{7},{8},{13},{15},{15},{10},{9},{12},{12},{9},{9},{9},{9},{4},{8},{11},{15},{9},{1},{4},{10},{9}};
        
        Fancy dt = null;
        for(int i = 0; i<cmd.length; i++){
            if("Fancy".equals(cmd[i])){
                dt = new Fancy();
            }else if("append".equals(cmd[i])){
                dt.append(arg[i][0]);
            }else if("addAll".equals(cmd[i])){
                dt.addAll(arg[i][0]);
            }else if("multAll".equals(cmd[i])){
                dt.multAll(arg[i][0]);
            }else{ //getIndex
                System.out.println(dt.getIndex(arg[i][0]));
            }
        }
    }
}
