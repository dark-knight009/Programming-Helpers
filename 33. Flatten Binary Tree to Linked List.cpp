/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    TreeNode* prev = NULL;
    
public:
    void flatten(TreeNode* root) {
        
        /*
        // Recursive Aproach:
        
        if(root == NULL) return;
        
        flatten(root->right);
        flatten(root->left);
        
        root->right = prev;
        root->left = NULL;
        
        prev = root;
        */
        
        /*
        // Iterative Approach
        
        if(root == NULL) return;
        
        stack<TreeNode*> st;
        st.push(root);
        
        while(!st.empty()) {
            
            TreeNode* curr = st.top();
            st.pop();
            
            if(curr->right) st.push(curr->right);
            if(curr->left) st.push(curr->left);
            
            if(st.empty() == false) {
                curr->right = st.top();
            }
            
            curr->left = NULL;
            
        }
        */
        
        
        // Morris Traversal Approach
        
        if(root == NULL) return;
        
        TreeNode* curr = root;
        
        while(curr != NULL) {
            
            if(curr->left) {
                TreeNode* prev = curr->left;
                
                while(prev->right) {
                    prev = prev->right;
                }
                
                prev->right = curr->right;
                curr->right = curr->left;
                curr->left = NULL;
                
            }
            
            curr = curr->right;
            
        }
        
        
        
    }
};