public class Client {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(5);
        // root.right.left.left.left=new TreeNode(6);
        // root.right.right=new TreeNode(7);
        // root.right.right.right=new TreeNode(8);
        
        TreeOperations treeoperations=new TreeOperations();
        System.out.println(treeoperations.maxDepth(root));
        if(treeoperations.isBalanced(root))
        {
            System.out.println("isBalanced");
        }
        else{
            System.out.println("NotBalanced");
        }
        System.out.println(treeoperations.diameterofBianryTree(root));
        System.out.println(treeoperations.maxPathSum(root));
        
    }
}
