class Solution {

    public Set<String> tilePossiblity(Set<String> result, StringBuilder ds, String tiles, boolean[] used){
        if(!ds.isEmpty()){
            result.add(new String(ds.toString()));
        }

        for(int i=0; i< tiles.length(); i++){
            if(used[i]) continue;

            used[i] = true;
            ds.append(tiles.charAt(i));
            result = tilePossiblity(result, ds, tiles, used);            
            ds.deleteCharAt(ds.length()-1);
            used[i] = false;
        }

        return result;
    }

    public int numTilePossibilities(String tiles) {
        
        var res = tilePossiblity(new HashSet<>(), new StringBuilder(), tiles, new boolean[tiles.length()]);
        return res.size();
    }
}