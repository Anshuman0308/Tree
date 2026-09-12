class MedianFinder {
    PriorityQueue<Integer> l;
        PriorityQueue<Integer> r;


    public MedianFinder() {
        l = new PriorityQueue<>(Collections.reverseOrder());
        r =  new   PriorityQueue<>();

    }
    
    public void addNum(int num) {
        
        l.offer(num);
        r.offer(l.poll());
        if(r.size() > l.size()) l.offer(r.poll());
    }
    
    public double findMedian() {
        if(l.size() > r.size()) return l.peek();
        return (l.peek()+ r.peek())/2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */