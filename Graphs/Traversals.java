import java.sql.Time;
import java.util.*;
public class Traversals {
    public List<Integer> bfsOfGraph(List<List<Integer>> adjList)
    {
        Queue<Integer> q=new LinkedList<>();
        int n=adjList.size();
        boolean visited[]=new boolean[n];
        List<Integer> bfs=new ArrayList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int node=q.poll();
            bfs.add(node);
            for(int it:adjList.get(node))
            {
                if(!visited[it])
                {
                    q.add(it);
                    visited[it]=true;
                }

            }
        }
        return bfs;
// Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

// Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
}
public static void dfs(int node,boolean vis[],List<List<Integer>> adjList, List<Integer> dfsList)
{
     vis[node]=true;
     dfsList.add(node);
     for(int it:adjList.get(node))
     {
        if(!vis[it])
        {
            dfs(it,vis,adjList,dfsList);
        }
     }
}
// Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

// Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.
public List<Integer> dfsOfGraph(int V, List<List<Integer>> adjList)
{
    boolean vis[]=new boolean[V+1];
    vis[0]=true;
    List<Integer> ls=new ArrayList<>();
    dfs(0,vis,adjList,ls);
    return ls;
}

    public static void main(String[] args) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);
        Traversals traversals=new Traversals();
        List<Integer> bfsTraversal=traversals.bfsOfGraph(adjList);
        boolean vis[]=new boolean[5];
        
        int n=bfsTraversal.size();  
        System.out.println("BFS TRAVERSAL");
        for(int i=0;i<n;i++)
        {
            System.out.print(bfsTraversal.get(i));
        }
        System.out.println("DFS Traversal");
        List<Integer> dfsTraversal=traversals.dfsOfGraph(5,adjList);

        for(int i=0;i<5;i++)
        {
            System.out.print(dfsTraversal.get(i));
        }
    }
}

