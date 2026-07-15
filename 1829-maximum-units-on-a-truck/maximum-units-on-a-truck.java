class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> b[1] - a[1]);
        int a =0;
        for(int[] i : boxTypes){
            int take = Math.min(truckSize, i[0]);
            a += take * i[1];
            truckSize -= take;
            if(truckSize == 0 ) break;
        }
        return a;
        
        
    }
}