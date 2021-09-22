// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//using HashMap & stacks
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0) return -1;
        
        int n = tops.length;
        int max = -1;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        //update frequencies in the map
        for(int i=0; i<n; i++){
            int top = tops[i];
            int bottom = bottoms[i];
            
            countMap.put(top, countMap.getOrDefault(top, 0)+1);
            if(countMap.get(top) >= n)
                max = top;
            countMap.put(bottom, countMap.getOrDefault(bottom, 0)+1);
            if(countMap.get(bottom) >= n)
                max = bottom;
        }
        
        if(max == -1) return -1;
        //calculate rotations on top & bottom
        int tRot = 0, bRot = 0;
        for(int i=0; i<n; i++){
            if(tops[i] != max && bottoms[i] !=  max)
                return -1;
            else if(tops[i] != max)
                tRot++;
            else if(bottoms[i] != max)
                bRot++;
            
        }
        
        return Math.min(tRot, bRot);
    }
}