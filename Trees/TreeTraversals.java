import java.util.*;

class TreeNode{
    int data;
    TreeNode left, right;
    public TreeNode(int item)
    {
        this.data=item;
        this.left=null;
        this.right=null;
    }
}
public class TreeTraversals{
    static void inorder(TreeNode TreeNode)
    {
       if(TreeNode==null)
         return;
       inorder(TreeNode.left);
       System.out.println(TreeNode.data+" ");
       inorder(TreeNode.right);
    }
    static void preorder(TreeNode TreeNode)
    {
        if(TreeNode==null)
         return;
         System.out.println(TreeNode.data+" ");
        preorder(TreeNode.left);
        preorder(TreeNode.right);

    }
    static void postorder(TreeNode TreeNode)
    {
        if(TreeNode==null)
         return;
        postorder(TreeNode.left);
        postorder(TreeNode.right);
        System.out.println(TreeNode.data+" ");
    }
    public static List<List<Integer>> BFS(TreeNode root)
    {
       Queue<TreeNode> queue=new LinkedList<>();
       List<List<Integer>> result=new LinkedList<List<Integer>>();
       if(root==null)
       {
        return result;
       }
       queue.offer(root);
       while(!queue.isEmpty())
       {
         int levelNum=queue.size();
         List<Integer> sublist=new LinkedList<Integer>();
         for(int i=0;i<levelNum;i++)
         {
            if(queue.peek().left!=null)
            {
                queue.offer(queue.peek().left);
            }
            if(queue.peek().right!=null)
            {
                queue.offer(queue.peek().right);
            }
            sublist.add(queue.poll().data);
         }
         result.add(sublist);
       }
       return result;
    }




    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        System.out.print("In-order DFS: ");
        inorder(root);
        System.out.print("\nPre-order DFS: ");
        preorder(root);
        System.out.print("\nPost-order DFS: ");
        postorder(root);
        System.out.println("\n\nBreadth-First Search (BFS):");
        List<List<Integer>> bfsResult = BFS(root);
        for (List<Integer> level : bfsResult) {
            for (int value : level) {
                System.out.print(value + " ");
            }
            System.out.println(); // Newline for each level
        }
        
    }
}
