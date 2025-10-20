import java.lang.reflect.Array;
import java.util.*;

class TreeNode{
    int data;
    TreeNode left, right;
    public TreeNode(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node,int row, int col)
    {
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Pair{
    TreeNode node;
    int hd;
    public Pair(TreeNode node, int hd)
    {
        this.node=node;
        this.hd=hd;
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
            TreeNode currNode=queue.poll();
           if(currNode!=null)
           {
            if(currNode.left!=null)
            {
                queue.offer(currNode.left);
            }
            if(currNode.right!=null)
            {
                queue.offer(currNode.right);
            }

            
            sublist.add(currNode.data);
          }
         }
         result.add(sublist);
       }
       return result;
    }
    public static List<List<Integer>> zigZag(TreeNode root)
    {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
         return result;
        queue.offer(root);
        
        boolean flag=false;
        while(!queue.isEmpty())
        { List<Integer> subList=new LinkedList<Integer>();
          int levelNum=queue.size();
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
                if(flag)
                {subList.add(queue.poll().data);}
                else{
                subList.add(0,queue.poll().data);}
            }
            result.add(subList);
            flag=!flag;
            
        }    
        return result;
    }
    public static boolean isLeaf(TreeNode node)
        {
            if(node.left==null && node.right==null)
              return true;
            return false;
        }
        public static void addLeftBoundary(TreeNode node,List<Integer> ans)
                {
                   TreeNode curr=node.left;
                   while(curr!=null)
                   {
                      if(!isLeaf(curr))ans.add(curr.data);
                      if(curr.left==null)
                      {
                        curr=curr.right;
                      }
                      else{
                      curr=curr.left;}
                   }
                }
                static void  addLeafNodes(TreeNode node, List<Integer> ans)
                        {
                            if(isLeaf(node)){
                                ans.add(node.data);
                                return;
                            }
                            if(node.left!=null)
                            {
                            addLeafNodes(node.left,ans);}
                            if(node.right!=null)
                            {
                            addLeafNodes(node.right, ans);
                            }        
                        }
                    static void addRightNodes(TreeNode node, List<Integer> res)
                         {
                                            TreeNode curr=node.right;
                                            ArrayList<Integer> res1=new ArrayList<Integer>();
                                            while(curr!=null)
                                            {
                                                if(!isLeaf(curr))
                                                {
                                                    res1.add(curr.data);
                                                }
                                                if(curr.right!=null)
                                                {
                                                   curr=curr.right;
                                                }
                                                else{
                                                    curr=curr.left;
                                                }
                                    
                                            }
                                            for(int i=res1.size()-1;i>=0;i--)
                                            {
                                                res.add(res1.get(i));
                                            }
                                    
                        }
                                        
                        static List<Integer> boundaryTraversal(TreeNode root)
                        {
                            List<Integer> ans=new ArrayList<Integer>();
                            if(isLeaf(root)==false)ans.add(root.data);
                            addLeftBoundary(root,ans);
                            addLeafNodes(root,ans);
                            addRightNodes(root,ans);
                            return ans;
    
                        }
            // static List<List<Integer>> verticalTraversal(TreeNode node)
            // {
            //      TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
            //      Queue<Tuple> q=new LinkedList<Tuple>();
            //      q.offer(new Tuple(node,0,0));
                 
                    
            // }
        public static ArrayList<Integer> topView(TreeNode root)
        {
             Map<Integer, Integer> map=new TreeMap<>();
             ArrayList<Integer> ans=new ArrayList<>();
             Queue<Pair> q=new LinkedList<Pair>();
             q.add(new Pair(root,0));
             while(!q.isEmpty())
             {
                Pair it=q.poll();
                int hd=it.hd;
                TreeNode curr=it.node;
                if(curr.left!=null)
                {
                    q.add(new Pair(curr.left,hd-1));
                }
                if(curr.right!=null)
                {
                    q.add(new Pair(curr.right,hd+1));
                }
                map.putIfAbsent(hd,curr.data);
             }
             for(Map.Entry<Integer, Integer> entry:map.entrySet())
             {
                ans.add(entry.getValue());
             }
             return ans;

        }
        public static ArrayList<Integer> bottomView(TreeNode node)
        {
            ArrayList<Integer> result=new ArrayList<Integer>();
            Queue<Pair> q=new LinkedList<Pair>();
            Map<Integer,Integer> map=new TreeMap<>();
            q.add(new Pair(node,0));
            while(!q.isEmpty())
            {
               Pair it=q.poll();
               int hd=it.hd;
               TreeNode curr=it.node;
               if(curr.left!=null)
               {
                   q.add(new Pair(curr.left,hd-1));
               }
               if(curr.right!=null)
               {
                   q.add(new Pair(curr.right,hd+1));
               }
               map.put(hd,curr.data);
            }
            for(Map.Entry<Integer, Integer> entry:map.entrySet())
             {
                result.add(entry.getValue());
             }
             return result;


        }
        private static boolean getPath(TreeNode node, ArrayList<Integer> arr,int x)
        {
              if(node==null)
                 return false;
              arr.add(node.data);
              if(node.data==x)
               return true;
             if(getPath(node.left,arr,x) || getPath(node.right,arr,x))
             {
                  return true;
             }
             arr.remove(arr.size()-1);
             return false;
        }
    
        public static void main(String[] args) {
            TreeNode root=new TreeNode(2);
            root.left=new TreeNode(3);
            root.right=new TreeNode(4);
            root.left.left=new TreeNode(5);
            root.left.right=new TreeNode(6);
            // System.out.print("In-order DFS: ");
            // inorder(root);
            // System.out.print("\nPre-order DFS: ");
            // preorder(root);
            // System.out.print("\nPost-order DFS: ");
            // postorder(root);
            System.out.println("\n\nBreadth-First Search (BFS):");
            List<List<Integer>> bfsResult = BFS(root);
            for (List<Integer> level : bfsResult) {
                for (int value : level) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Newline for each level
            }
            System.out.println("Zigzag:");
            List<List<Integer>> zigzagResult = zigZag(root);
            for (List<Integer> level : zigzagResult) {
                for (int value : level) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Newline for each level
            }
            System.out.println("BoundaryTraversal:");
            List<Integer> ans=boundaryTraversal(root);
        for(int i:ans)
        {
            System.out.println(i);
        }
        System.out.println("BottomView");
        ArrayList<Integer> ans1=bottomView(root);
    for(int i:ans1)
    {
        System.out.println(i);
    }
    ArrayList<Integer> nodesinPath=new ArrayList<>();
    getPath(root,nodesinPath,6);
    System.out.println("Root to Node path");
    for(int i:nodesinPath)
    {
        System.out.println(i);
    }
      
        
    }
}
