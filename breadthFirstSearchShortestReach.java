package demos;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class breadthFirstSearchShortestReach {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for(int c = 0; c < cases; c++)
        {
            int nodes = sc.nextInt();
            int edges = sc.nextInt();

            
            boolean[][] graph = new boolean[nodes][nodes];
            boolean[] visited = new boolean[nodes];
            
            int[] answer = new int[nodes];
            // Mark the traversable edges on the graph array
            for(int e = 0; e < edges; e++)
            {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                graph[x][y] = true;
                graph[y][x] = true;
            }

            Queue<Integer> q = new LinkedList<Integer>();
            //Queue up the starting point
            q.add(sc.nextInt() - 1);
            visited[(int)q.peek()] = true;
            answer[(int)q.peek()] = -2;
            
            //visit adjacent nodes
            while(!q.isEmpty())
            {
                int currentNode = (int)q.remove();
                for(int adjNode = 0; adjNode < graph.length; adjNode++)
                {
                    if(graph[currentNode][adjNode] == true && visited[adjNode] == false)
                    {
                    	//if this is the first time touching this node, give the step number to answer
                        if(visited[adjNode] == false)
                        {
                        	if(answer[currentNode] == -2)
                        	{
                        		answer[adjNode] = 1;
                        	}
                        	else
                        	{
                                answer[adjNode] = answer[currentNode] + 1;
                        	}
                        }
                        visited[adjNode] = true;
                        q.add(adjNode);
                    }
                }
            }
            for(int i = 0; i < answer.length; i++)
            {
                if(answer[i] == 0)
                {
                    System.out.print(-1 + " ");
                }
                else if(answer[i] == -2)
                {
                    //Do nothing
                }
                else
                {
                    System.out.print(answer[i] * 6 + " ");
                }
            }
            System.out.println();
        }
    }
}