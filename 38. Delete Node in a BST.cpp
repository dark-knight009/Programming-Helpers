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
private:
    TreeNode* helper(TreeNode* root) {
        if(root->left == NULL) { // no left subtree
            return root->right;
        }
        else if(root->right == NULL) {  // no right subtree
            return root->left;
        }
        
        TreeNode* rchild = root->right;
        TreeNode* lastRightofLeft = findLastRight(root->left);
        lastRightofLeft->right = rchild;
        
        return root->left;
    }
    
    TreeNode* findLastRight(TreeNode* root) {
        while(root->right != NULL) root = root->right;
        
        return root;
    }
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) return NULL;
        else if(key == root->val) {
            return helper(root);
        }
        
        TreeNode* tmp = root;
        
        while(root != NULL) {
            if(root->val > key) {
                if(root->left != NULL && root->left->val == key) {
                    root->left = helper(root->left);
                    break;
                }
                else root = root->left;
            }
            
            else {
                if(root->right != NULL && root->right->val == key) {
                    root->right = helper(root->right);
                    break;
                }
                else root = root->right;
            }
        }
        
        return tmp;
    }
};