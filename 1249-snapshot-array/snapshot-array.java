class SnapshotArray {

    SnapNode[] arr;
    int snapId;
    public SnapshotArray(int length) {
        arr = new SnapNode[length];      
    }
    
    public void set(int index, int val) {
        if(arr[index] == null) {
            arr[index] = new SnapNode(index);
        }
        arr[index].map.put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        if(arr[index] == null) {
            arr[index] = new SnapNode(index);
        }
        Integer floor = arr[index].map.floorKey(snap_id);
        if(floor == null) {
            return 0;
        }
        return arr[index].map.get(floor);
    }
}

class SnapNode {
    int index;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    SnapNode(int index) {
        this.index = index;
    }
}

class Snap {
    int value;
    int snapId;

    Snap(int value, int snapId) {
        this.value = value;
        this.snapId = snapId;
    }

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */