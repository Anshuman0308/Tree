class Solution { 
    public String reversePrefix(String word, char ch) { 
        Stack<Character> st = new Stack<>(); 
        StringBuilder ans = new StringBuilder(); 
        boolean f = false; 

        for(char c : word.toCharArray()) { 

            if (!f) { 
                st.push(c); 

                if(c == ch) { 
                    while(!st.isEmpty()) { 
                        ans.append(st.pop()); 
                    } 
                    f = true; 
                } 
            } 
            else {  
                ans.append(c); 
            } 
        } 
         if (!f) {
            return word;
        }

        return ans.toString(); 
    } 
}