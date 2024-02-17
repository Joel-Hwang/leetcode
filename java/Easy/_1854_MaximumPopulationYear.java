package Easy;

public class _1854_MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for(int[] log : logs){
            for(int year = log[0]; year<log[1]; year++){
                years[year-1950]++;
            }
        }

        int max = 0;
        int maxYear = 0;
        for(int i = 0; i<years.length; i++){
            if(years[i] > max){
                max = years[i];
                maxYear = i+1950;
            }
        }
        return maxYear;

    }
}
