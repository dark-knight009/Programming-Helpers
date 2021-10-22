package GraphAlgorithms;
import java.util.*;
class Vertex
{
	public char label;
public Vertex(char lab)
{
	label=lab;	
}
}
class Graph
{
	private final int maxVertex=20;
	private Vertex vertexList[];
	private int adjmat[][];
	private  int nverts;
	private char sortedArray[];
	public Graph()
	{
		vertexList=new Vertex[maxVertex];
		adjmat=new int[maxVertex][maxVertex];
	    nverts=0;
	    for(int i=0;i<maxVertex;i++)
	    {
	    	for(int j=0;j<maxVertex;j++)
	    	{
	    		adjmat[i][j]=0;
	    	}
	    }
	    sortedArray=new char[maxVertex];
	}
	public void addVertex(char lab)
	{
		vertexList[nverts++]=new Vertex(lab);
	}
	public void addEdge(int start,int end)
	{
		adjmat[start][end]=1;
	}
	public void displayVertex(int v)
	{
		System.out.println(vertexList[v].label);
	}
	public void topo()
	{
		int ori_nverts=nverts;
		while(nverts>0)
		{
			int currentVertex=noSuccessor();
			if(currentVertex==-1)
			{	System.out.println("Error:Graph has cycles");
			return ;}
			sortedArray[nverts-1]=vertexList[currentVertex].label;
			deleteVertex(currentVertex);
		}
		System.out.println("Topological sorted order");
		for(int i=0;i<ori_nverts;i++)
	    System.out.print(sortedArray[i]+" ");
		System.out.println(" ");
	}
	public int noSuccessor()
	{
		boolean isEdge;
		for(int row=0;row<nverts;row++)
		{
			isEdge=false;
			for(int col=0;col<nverts;col++)
			{
				if(adjmat[row][col]>0)
				{
					isEdge=true;
					break;
				}
			}
			if(!isEdge)
			return row; 
		}
		return -1;
	}
	public void deleteVertex(int delVertex)
	{
		if(delVertex!=nverts-1)
		{
			for(int i=delVertex;i<nverts;i++)
				vertexList[i]=vertexList[i+1];
			for(int row=delVertex;row<nverts;row++)
				moverowUp(row,nverts);
			for(int col=delVertex;col<nverts;col++)
				moveColLeft(delVertex,nverts);
		}
		nverts--;
	}
	public void moverowUp(int row,int length)
	{
		for(int col=0;col<length;col++)
			adjmat[row][col]=adjmat[row+1][col];
	}
	public void moveColLeft(int col,int length)
	{
		for(int row=0;row<length;row++)
			adjmat[row][col]=adjmat[row][col+1];
	}
}
public class topologicalsort {
public static void main(String args[])
{
	Graph theGraph=new Graph();
	theGraph.addVertex('A');
	theGraph.addVertex('B');
	theGraph.addVertex('C');
	theGraph.addVertex('D');
	theGraph.addVertex('E');
	theGraph.addVertex('F');
	theGraph.addVertex('G');
	theGraph.addVertex('H');
    theGraph.addEdge(0, 3);
    theGraph.addEdge(0, 4);
    theGraph.addEdge(0, 3);
    theGraph.addEdge(1, 4);
    theGraph.addEdge(2, 5);
    theGraph.addEdge(3, 6);
    theGraph.addEdge(4, 6);
    theGraph.addEdge(5, 7);
    theGraph.addEdge(6, 7);
	theGraph.topo();
}

}
