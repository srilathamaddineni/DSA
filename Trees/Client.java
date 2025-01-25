public class Client {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.left.left=new TreeNode(5);
        root.right.left.left.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.right.right.right=new TreeNode(8);
        
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
        
    }
}
