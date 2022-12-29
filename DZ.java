import java.util.LinkedList;
import java.util.Queue;

public class DZ
{
    static int M = 5;
    static int N = 5;

    static boolean isValid(int mat[][], boolean visited[][], int row, int col)
    {
        return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) && (mat[row][col] == 1) && (!visited[row][col]);
    }

    private static void mat(int rix[][], int i, int j, int x, int y)
    {
        int row[] =
        { -1, 0, 0, 1 };
        int col[] =
        { 0, -1, 1, 0 };

        boolean[][] visited = new boolean[M][N];
        Queue<Node> q = new LinkedList<Node>();
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
        int mindistance = Integer.MAX_VALUE;
        while (!q.isEmpty())
        {
            Node Node = q.poll();
            i = Node.x;
            j = Node.y;
            int dist = Node.distance;
            if (i == x && j == y)
            {
                mindistance = dist;
                break;
            }

            for (int k = 0; k < 4; k++)
            {
                if (isValid(rix, visited, i + row[k], j + col[k]))
                {
                    visited[i + row[k]][j + col[k]] = true;
                    Node n = new Node(i + row[k], j + col[k], dist + 1);
                    q.add(n);
                }
            }
        }

        if (mindistance == Integer.MAX_VALUE)
        {
            System.out.print("Конечная точка недостижима.");
        }
        else
        {
            System.out.print("Кратчайший до точки путь имеет длину " + mindistance);
        }
    }

    public static void main(String[] args)
    {
        int[][] rix =
        {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 1, 1, 0, 0, 0 } };
        mat(rix, 0, 0, 3, 4);
    }
}