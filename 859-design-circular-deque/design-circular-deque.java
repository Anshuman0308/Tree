class MyCircularDeque {
  private  int[] d;
  private  int h, c , cap;


    public MyCircularDeque(int k) {
        d = new int[k];
        cap = k;
        h =0;
        c =0;


    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        h = (h - 1 + cap) %  cap;
        d[h] = value;
        c++;
        return true;
        
    }
    
    public boolean insertLast(int value) {

          if(isFull()) return false;
          d[(h + c) % cap] = value;
          c++;
          return true;

    }
    
    public boolean deleteFront() {
        
          if(isEmpty()) return false;
           h = (h +1 ) %  cap;
          c--;
          return true;

        
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
            c--;
            return true;
        
    }
    
    public int getFront() {
        return isEmpty() ? -1:d[h]; 
    }
    
    public int getRear() {

        return isEmpty() ? -1 : d[(h + c - 1) % cap];

    }
    
    public boolean isEmpty() {
        return c  == 0;
    }
    
    public boolean isFull() {
        return c == cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */