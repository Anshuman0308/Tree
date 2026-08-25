class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
         int[] sol = new int[friends.length];
         int index =0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < order.length; i++){
            for(int j = 0; j < friends.length; j++){
                if(order[i] == friends[j]){
                    sol[index++] = friends[j];
            } 
        }
      
    }
      return sol;
}
}