class Solution {
    public String decodeString(String s) {
        Deque<Integer> cS = new ArrayDeque<>();
        Deque<StringBuilder> sS= new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
          int k =0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
             
               k = k* 10 + (c - '0');
            }else if(c =='['){

            
               cS.push(k);
               sS.push(curr);
               curr = new StringBuilder();
               k=0;

            }
            else if( c == ']'){

            
               StringBuilder decoded = sS.pop();
               int r = cS.pop();
               for( int i=0; i < r;i++) decoded.append(curr);
               curr = decoded;

            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}