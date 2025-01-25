import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class TreeOperations{
    
    //this function is find maxDepth or height of the tree 
    public int maxDepth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    //this function involves finding the balanced tree

    public boolean isBalanced(TreeNode node)
    {
        return dfsHeight(node)!=-1;
    }
    public int dfsHeight(TreeNode node)
    {
        if(node==null)
          return 0;
        int lh=dfsHeight(node.left);
        int rh=dfsHeight(node.right);
        if(lh==-1 || rh==-1)
        {
            return -1;
        }
        if(Math.abs(lh-rh)>1)
        {
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
    public int diameterofBianryTree(TreeNode root)
    {
        int diameter[]=new int[1];
        height(root,diameter);
        return diameter[0];
    }
    public int height(TreeNode root, int diameter[])
    {
        if(root==null)
          return 0;
        int lh=height(root.left,diameter);
        int rh=height(root.right,diameter);
        diameter[0]=Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    

}
