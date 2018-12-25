package com.chess.kostas.sonidchessriddle;

import java.util.*;

// queue node used in BFS
class Node
{
    // (x, y) represents chess board coordinates
    // dist represent its minimum distance from the source
    int x, y, dist;


    public Node(int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
    public int Node_getx() {
        return x;
    }

    public int Node_gety() {
        return y;
    }



    // Check if (x, y) is valid chess board coordinates
    // Note that a knight cannot go out of the chessboard
    static boolean ValidBoardBounds(int x, int y, int N)
    {
        int nx = x-1;
        int ny = y-1;

        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
            return false;

        return true;
    }


    // As we are using class object as a key in a HashMap
    // we need to implement hashCode() and equals()

    // -- below methods are generated by IntelliJ IDEA (Alt + Insert) --
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (x != node.x) return false;
        if (y != node.y) return false;
        return dist == node.dist;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + dist;
        return result;
    }
};

class ChessKnight
{
    // Below arrays details all 8 possible movements
    // for a knight
    private static int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };


    // Find minimum number of steps taken by the knight
    // from source to reach destination using BFS
    // I leave it here just for fun!
    public static int BFS(Node src, Node dest, int N)
    {
        // map to check if matrix cell is visited before or not
        Map<Node, Boolean> visited = new HashMap<>();



        // create a queue and enqueue first node
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);

        // run till queue is not empty
        while (!q.isEmpty())
        {
            // pop front node from queue and process it
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int dist = node.dist;
           // String letter = node.route;

            System.out.println("Queu: (" + x + "," + y + ")-->Distance:" + (dist)+"Generates->");

            // if destination is reached, return distance
            if (x == dest.x && y == dest.y) {
                System.out.println(" x Number of steps required is " +dist);
                return dist;
            }

            // Skip if location is visited before
            if (visited.get(node) == null)
            {
                // mark current node as visited
                visited.put(node, true);


                // check for all 8 possible movements for a knight
                // and enqueue each valid movement into the queue
                for (int i = 0; i < 8; ++i)
                {
                    // Get the new valid position of Knight from current
                    // position on chessboard and enqueue it in the
                    // queue with +1 distance
                    int x1 = x + row[i];
                    int y1 = y + col[i];

                    if (Node.ValidBoardBounds(x1, y1, N)) {
                        q.add(new Node(x1, y1, dist + 1));
                        System.out.println("Queu: (" + x + "," + y + ")->(" + x1 + "," + y1 + ")-->turn:" + (dist + 1));
                    }
                }

            }
        }



        // return INFINITY if path is not possible
        return Integer.MAX_VALUE;
    }


    private ArrayList<Node> getCloseMoves(Node node) {

        ArrayList<Node> nextNodeList = new ArrayList<>();

        for (int i = 0; i < 8; i++) { // Board size = 8x8

            Node nextnode = new Node(node.Node_getx() + row[i], node.Node_gety() + col[i]);

            if (nextnode.ValidBoardBounds(nextnode.Node_getx(),nextnode.Node_gety(),8))
            {
                nextNodeList.add(nextnode);
            }
        }
        return nextNodeList;
    }

    //Check all possible moves for target
    public ArrayList<ArrayList<Node>> getAllRoutes(Node start, Node end) {

        ArrayList<ArrayList<Node>> routes = new ArrayList<>();

        for (Node nodeA : getCloseMoves(start)) {
            for (Node nodeB : getCloseMoves(nodeA)) {
                for (Node nodeC : getCloseMoves(nodeB)) { // Check until 3rd depth

                    if (nodeC.equals(end)) {

                        ArrayList<Node> tmp = new ArrayList<>();
                        tmp.add(start);
                        tmp.add(nodeA);
                        tmp.add(nodeB);
                        tmp.add(end);
                        routes.add(tmp);
                    }
                }
            }
        }
        return routes;
    }

    public static void main(String[] args)
    {
        int N = 8;

        // source coordinates
        Node src = new Node(1, 1);

        // destination coordinates
        Node dest = new Node(4, 4);

        System.out.println("Minimum number of steps required is " +
                BFS(src, dest, N));
    }
}