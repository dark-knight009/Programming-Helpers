class Solution {
    int totalTilt;
    public int findTilt(TreeNode root) {
        totalTilt = 0;
        
        getSumOfSubtree(root);
        
        return totalTilt;
    }
    
    private int getSumOfSubtree(TreeNode node){
        if(node == null) return 0;
        
        int leftSubtreeSum = getSumOfSubtree(node.left);
        int rightSubtreeSum = getSumOfSubtree(node.right);
        
        totalTilt += Math.abs(leftSubtreeSum - rightSubtreeSum);
        
        return node.val + leftSubtreeSum + rightSubtreeSum;
    }
}
