class BrowserHistory {
    Stack<String> s = new Stack<>();
    Stack<String> s2 = new Stack<>();
    public BrowserHistory(String homepage) {
        s.push(homepage);
    }
    
    public void visit(String url) {
        s.push(url);
        while(!s2.isEmpty()){
            s2.pop();
        }

        
    }
    
    public String back(int steps) {
        while(steps-- > 0 && s.size() >1){
            s2.push(s.pop());
        }
        return s.peek();
        
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && s2.size()>0 ){
            s.push(s2.pop());
        }
        return s.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */