class MyCircularQueue {
 private int [] d;
private int h, c, cap;
    public MyCircularQueue(int k) {
        d = new int[k];
        cap = k;
        h= 0;
        c =0;
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        d[(h + c) % cap] = value;
        c++;
        return true;

        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
       h = (h + 1) % cap ;
        c--;
        return true;
        
    }
    
    public int Front() {
        return isEmpty()? -1: d[h];
        
    }
    
    public int Rear() {

          return isEmpty()? -1: d[(h + c -1)%cap];
    }
    
    public boolean isEmpty() {
        return c == 0;
        
    }
    
    public boolean isFull() {
        return c == cap;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */