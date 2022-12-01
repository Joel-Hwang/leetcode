package Easy;

public class _1534_CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for(int i = 0; i<arr.length-2; i++)
            for(int j = i+1; j<arr.length-1; j++)
                for(int k = j+1; k<arr.length; k++)
                    if(isGoodTriplets(arr[i], arr[j], arr[k], a, b, c)) res++;
        return res;
    }

    private boolean isGoodTriplets(int elem1, int elem2, int elem3, int a, int b, int c){
        return Math.abs(elem1-elem2) <= a && Math.abs(elem2-elem3) <= b && Math.abs(elem1-elem3) <= c;
    }
}
