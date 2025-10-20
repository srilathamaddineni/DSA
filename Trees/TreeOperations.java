import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.val=val;
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
    public int maxPathSum(TreeNode root)
    {
        int max[]=new int[1];
        max[0]=Integer.MIN_VALUE;
        maxPathDown(root, max);
        return max[0];
    }

    public int maxPathDown(TreeNode node, int max[])
    {
      if(node==null)
        return 0;
      int leftSum=Math.max(0,maxPathDown(node.left, max));
      int rightSum=Math.max(0,maxPathDown(node.right, max));
      max[0]=Math.max(max[0], node.val+leftSum+rightSum);
      return node.val+Math.max(leftSum,rightSum);

    }
    public boolean isSameTree(TreeNode a, TreeNode b)
    {
        if(a==null || b==null)
        {
            return a==b;
        }
        return a.val==b.val && isSameTree(a.left,b.left) && isSameTree(a.right,b.right);
    }


}
