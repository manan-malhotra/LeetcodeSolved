class SnapshotArray {
    int snapId=0;
    List<SnapObj>[] arr;
    public SnapshotArray(int length) {
        this.arr = new ArrayList[length];
        for(int i=0; i<length; i++) {
            this.arr[i] = new ArrayList<>();
            this.arr[i].add(new SnapObj(0,0));
        }
    }
    
    public void set(int index, int val) {
            SnapObj snapObj = new SnapObj(snapId, val);
            arr[index].add(snapObj);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        List<SnapObj> iterList = arr[index];
        int left=0, res=0, right = iterList.size()-1;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            SnapObj tempObj = iterList.get(mid);
            if(tempObj.id <= snap_id) {
                res = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return iterList.get(res).val;
    }

    public class SnapObj {
        int id;
        int val;
        public SnapObj(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */