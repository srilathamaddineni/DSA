import java.util.*;

public class Graph{
    class Pair{
        int node;
        int weight;
        Pair(int n, int w){
            node=n;
            weight=w;
        }
    public String toString(){
       
      return "(" +node+","+weight+ ")";
    }
}
    int adjMatrix[][];
    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWeight;
    Graph(int nodes)
    {
        adjMatrix=new int[nodes][nodes];
        adjList=new ArrayList<>();
        adjListWithWeight=new ArrayList<>();
        for(int i=0;i<nodes;i++)
        {
            adjList.add(new ArrayList<>()); //initializing empty list for every node
            adjListWithWeight.add(new ArrayList<>()); 
        }
    }
    public void addEdgesInMatrix(int edges[][], boolean isDirected)
    {
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            if(isDirected){
                adjMatrix[u][v]=1;
            }
            else{
                adjMatrix[u][v]=1;
                adjMatrix[v][u]=1;
            }

        }
    }
    public void addEdgesWithWieghtInMatrix(int edges[][], boolean isDirected){
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(isDirected){
                adjMatrix[u][v]=w;
            }
            else{
                adjMatrix[u][v]=w;
                adjMatrix[v][u]=w;
            }

        }
    }
    public void addEdgesInList(int edges[][], boolean isDirected)
    {
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            if(isDirected){
                adjList.get(u).add(v);
            }
            else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

        }
    }
    public void addEdgesWithWeightInList(int edges[][], boolean isDirected)
    {
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(isDirected){
                Pair pair=new Pair(v,w);
                adjListWithWeight.get(u).add(pair);
            }
            else{
                Pair pair1=new Pair(v,w);
                Pair pair2=new Pair(u,w);
                adjListWithWeight.get(u).add(pair1);
                adjListWithWeight.get(v).add(pair2);
            }

        }
    }
    public void printMatrix(){
        for(int i=0;i<adjMatrix.length;i++)
        {   System.out.print("row "+i + "-> ");
            for(int j=0;j<adjMatrix[0].length;j++)
            {
                System.out.print(adjMatrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public void printList(){
        for(int i=0;i<adjList.size();i++)
        {
            System.out.print(i+"-> [");
            for(int j=0;j<adjList.get(i).size();j++)
            {
                System.out.print(adjList.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
    public void printListWithWeight(){
        for(int i=0;i<adjListWithWeight.size();i++)
        {
            System.out.print(i+"-> [");
            for(int j=0;j<adjListWithWeight.get(i).size();j++)
            {
                System.out.print(adjListWithWeight.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
    public void degreeInUndirectedGraph(int edges[][], int nodes)
    {
        int degree[]=new int[nodes];
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            degree[u]++;
            degree[v]++;
        }
        
    }
    public void degreeIndirectedGraph(int edges[][], int nodes)
    {
        int inDegree[]=new int[nodes];
        int outDegree[]=new int[nodes];
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            outDegree[u]++;
            inDegree[v]++;
        }
        
    }
    public static void main(String args[])
    {
        /*int edges[][]={{0,2},{0,1},{1,3}};
        int nodes=4;
        System.out.println("undirected graph-->");
        Graph graph =new Graph(nodes);
        graph.addEdgesInMatrix(edges,false);
        graph.printMatrix();
        Graph graph1=new Graph(nodes);
        System.out.println("directed graph-->");
        graph1.addEdgesInMatrix(edges,true);
        graph1.printMatrix();

        int edges[][]={{0,2,10},{0,1,20},{1,3,30}};
        int nodes=4;
        System.out.println("Weighted undirected graph-->");
        Graph graph =new Graph(nodes);
        graph.addEdgesWithWieghtInMatrix(edges,false);
        graph.printMatrix();
        Graph graph1=new Graph(nodes);
        System.out.println("Weighted directed graph-->");
        graph1.addEdgesWithWieghtInMatrix(edges,true);
        graph1.printMatrix();*/

        /*int edges[][]={{0,2},{0,1},{1,3}};
        int nodes=4;
        System.out.println("undirected graph-->");
        Graph graph2 =new Graph(nodes);
        graph2.addEdgesInList(edges,false);
        graph2.printList();
        Graph graph3=new Graph(nodes);
        System.out.println("directed graph-->");
        graph3.addEdgesInList(edges,true);
        graph3.printList();*/

        int edges[][]={{0,2,10},{0,1,20},{1,3,30}};
        int nodes=4;
        System.out.println("undirected graph-->");
        Graph graph2 =new Graph(nodes);
        graph2.addEdgesWithWeightInList(edges,false);
        graph2.printListWithWeight();
        Graph graph3=new Graph(nodes);
        System.out.println("directed graph-->");
        graph3.addEdgesWithWeightInList(edges,true);
        graph3.printListWithWeight();


    }
}