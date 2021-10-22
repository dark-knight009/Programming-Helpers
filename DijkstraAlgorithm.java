package GraphAlgorithms;
import java.util.*;
class Distpar
{
	public int distance;
	public int parentVert;
	public Distpar(int pv,int d)
	{
		distance=d;
		parentVert=pv;
	}
}
class Vertex2
{
	public char label;
	public boolean isinTree;
	public Vertex2(char lab)
	{
		label=lab;
		isinTree=false;
	}
}
class Graph2
{
	private final int maxVerts=20;
	private final int Infinity=100000;
	private Vertex2 []vertexList;
	private int [][]adjMat;
	private int nverts;
	private int nTree;
	private int currentVert;
	private Distpar sPath[];
	private int startToCurrent;
	public Graph2()
	{
		vertexList=new Vertex2[maxVerts];
		adjMat=new int[maxVerts][maxVerts];
		nverts=0;
		for(int i=0;i<maxVerts;i++)
		{
			for(int j=0;j<maxVerts;j++)
			{
				adjMat[i][j]=Infinity;
			}
		}
	sPath=new Distpar[maxVerts];
	}
    public void addVertex(char lab)
    {
    	vertexList[nverts++]=new Vertex2(lab);
    }
    public void addEdge(int start,int end,int weight)
    {
    	adjMat[start][end]=weight;
    }
    public void path()
    {
    	int startTree=0;
    	vertexList[startTree].isinTree=false;
    	nTree++;
    	for(int i=0;i<nverts;i++)
    	{
    	int temp=adjMat[startTree][i];
    	sPath[i]=new Distpar(startTree,temp);
    	}
    	while(nTree<nverts)
    	{
    		currentVert=startTree;
    		int indexMin=getMin();
    		int mindis=sPath[indexMin].distance;
    		if(mindis==Infinity)
    		{
    			System.out.println("Unreacheable vertices");
              break;
    		}
    		else
    		{
    			currentVert=indexMin;
    			startToCurrent=sPath[indexMin].distance;
    		}
    		vertexList[currentVert].isinTree=true;
    		nTree++;
    		adjustpath();
    	}
    	displaypath();
    	nTree=0;
    	for(int i=0;i<nverts;i++)
    		vertexList[i].isinTree=false;
    }
    public int getMin()
    {
    	int minDist =Infinity;
    	int indexMin=0;
    	for(int i=1;i<nverts;i++)
    	{
    		if(!vertexList[i].isinTree&&sPath[i].distance<minDist)
    		{
    			minDist=sPath[i].distance;
    			indexMin=i;
    		}
    }
    	return indexMin;
    }
    	public void adjustpath()
    	{
    	int column=1;
    	while(column<nverts)
    	{
    		if(vertexList[column].isinTree)
    		{
    			column++;
    			continue;
    		}
    		int currentToFringe=adjMat[currentVert][column];
    		int startToFringe=currentToFringe+startToCurrent;
    		int sPathDist=sPath[column].distance;
    		if(startToFringe<sPathDist)
    		{
    			sPath[column].parentVert=currentVert;
    			sPath[column].distance=startToFringe;
    		}
    	   column++;
    	}
    	}
        public void displaypath()
        {
        	for(int i=0;i<nverts;i++)
        	{
        		System.out.print(vertexList[i].label+"=");
        		if(sPath[i].distance==Infinity)
            	    System.out.print("Invalid");
            		else
            	    System.out.print(sPath[i].distance);
            		char parent=vertexList[sPath[i].parentVert].label;
            		System.out.print("("+parent+")");
}
        	System.out.println("");
}
}
public class DijkstraAlgorithm 
{
	public static void main(String args[])
	{
		Graph2 theGraph=new Graph2();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addEdge(0,1,50);
		theGraph.addEdge(0,3,80);
		theGraph.addEdge(1,2,60);
		theGraph.addEdge(1,3,90);
		theGraph.addEdge(2,4,40);
		theGraph.addEdge(3,2,20);
		theGraph.addEdge(3,4,70);
		theGraph.addEdge(4,1,50);
		System.out.println("Minimum spanning tree");
		theGraph.path();
		System.out.println();
		
	}
}
