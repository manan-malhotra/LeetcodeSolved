class Pair{
    int growTime, plantTime;
    Pair(int growTime, int plantTime)
    {
        this.growTime = growTime;
        this.plantTime = plantTime;
    }
}
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime)
    {
        List<Pair>flowers = new ArrayList();
        int n = plantTime.length;
        for (int i = 0; i < n; i++) flowers.add(new Pair(growTime[i], plantTime[i]));
    
        Collections.sort(flowers, (Pair a, Pair b)->{  return (b.growTime - a.growTime);});
        
        int currTime = 0, mxBloomTime = 0;
        for (Pair flower : flowers)
        {
            currTime += flower.plantTime; 
            int bloomTime = currTime + flower.growTime; 
            mxBloomTime = Math.max(mxBloomTime, bloomTime);
        }
        return mxBloomTime;
        
    }
}