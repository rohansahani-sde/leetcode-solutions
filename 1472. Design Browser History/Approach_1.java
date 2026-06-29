class BrowserHistory {
    class Node{
        Node next;
        Node pre;
        String url;
        Node(String url){
            this.url = url;
        }

    }
    
    Node head;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);

    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        head.next = newNode;
        newNode.pre = head;
        head = newNode;
    }
    
    public String back(int steps) {
        while(steps >0 && head.pre != null){
            head = head.pre;
            steps--;
        }
        return head.url;

        
    }
    
    public String forward(int steps) {
        while(steps >0 && head.next != null){
            head = head.next;
            steps--;
        }
        return head.url;

        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */