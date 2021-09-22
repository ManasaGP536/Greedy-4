// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//using only stacks

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0) return -1;
        
        int n = tops.length;
        int result = checkRotations(tops, bottoms, tops[0]);
        
        if(result != -1) return result;
        
        return checkRotations(tops, bottoms, bottoms[0]);
    
    }
    
    private int checkRotations(int[] tops, int[] bottoms, int target){
        int tRot = 0, bRot = 0;
        int n = tops.length;
        for(int i=0; i<n; i++){
            if(tops[i] != target && bottoms[i] !=  target)
                return -1;
            else if(tops[i] != target)
                tRot++;
            else if(bottoms[i] != target)
                bRot++;
            
        }
        
        return Math.min(tRot, bRot);
    }
    
}
       