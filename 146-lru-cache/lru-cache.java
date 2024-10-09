class LRUCache {
    class DoubleLL{
        int key;
        int value;
        DoubleLL prev;
        DoubleLL next;
        DoubleLL(int key,int val){
            this.key=key;
            this.value=val;
        }

    }
    
    public int capacity;
    // for counting the no.of Elements present in the doubleLL
    public int count;
    public DoubleLL map[];
    public DoubleLL head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        count=0;
        map=new DoubleLL[10000+1];
        head=new DoubleLL(0,0);
        tail=new DoubleLL(0,0);

        head.next=tail;
        tail.prev=head;

        head.prev=null;
        tail.next=null;
            
    }
    public void addNode(DoubleLL node){
        node.next=head.next;
        node.next.prev=node;
        node.prev=head;
        head.next=node;
        return;
    }
    public void deleteNode(DoubleLL node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return;
    }
    public int get(int key) {
        if(map[key]!=null){
            DoubleLL node=map[key];
            int val=node.value;
            deleteNode(node);
            addNode(node);
            return val;
        }
        return -1;
             
    }
    public void put(int key, int value) {
        if(map[key]!=null){
            DoubleLL node=map[key];
            node.value=value;
            deleteNode(node);
            addNode(node);
        }
        else{
            DoubleLL node=new DoubleLL(key,value);
            map[key]=node;
            if(count<capacity){
                count++;
                addNode(node);
            }
            else{
            map[tail.prev.key]=null;
            deleteNode(tail.prev);
            addNode(node);

        }
        }
        
        return;
        
        
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */