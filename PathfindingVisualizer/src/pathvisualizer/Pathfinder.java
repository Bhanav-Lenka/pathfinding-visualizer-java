package pathvisualizer;

import java.util.*;

public class Pathfinder {

    public static List<int[]> bfs(int[][] grid, int startR, int startC, int endR, int endC) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] parentR = new int[rows][cols];
        int[][] parentC = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            Arrays.fill(parentR[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int[][] dirs = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == endR && c == endC) {
                return rebuildPath(parentR, parentC, endR, endC);
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (valid(nr, nc, grid) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    parentR[nr][nc] = r;
                    parentC[nr][nc] = c;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return null;
    }
    
    public static List<int[]> dfs(int[][] grid, int startR, int startC, int endR, int endC) {

    int rows = grid.length;
    int cols = grid[0].length;

    boolean[][] visited = new boolean[rows][cols];
    int[][] parentR = new int[rows][cols];
    int[][] parentC = new int[rows][cols];

    for (int i = 0; i < rows; i++)
        Arrays.fill(parentR[i], -1);

    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{startR, startC});
    visited[startR][startC] = true;

    int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    while (!stack.isEmpty()) {
        int[] cur = stack.pop();
        int r = cur[0];
        int c = cur[1];

        if (r == endR && c == endC) {
            return rebuildPath(parentR, parentC, endR, endC);
        }

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (valid(nr, nc, grid) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                parentR[nr][nc] = r;
                parentC[nr][nc] = c;
                stack.push(new int[]{nr, nc});
            }
        }
    }

    return null;
}

public static List<int[]> dijkstra(int[][] grid, int startR, int startC, int endR, int endC) {

    int rows = grid.length;
    int cols = grid[0].length;

    int[][] dist = new int[rows][cols];
    int[][] parentR = new int[rows][cols];
    int[][] parentC = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
        Arrays.fill(dist[i], Integer.MAX_VALUE);
        Arrays.fill(parentR[i], -1);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

    dist[startR][startC] = 0;
    pq.add(new int[]{startR, startC, 0});

    int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int r = cur[0];
        int c = cur[1];
        int curDist = cur[2];

        if (r == endR && c == endC) {
            return rebuildPath(parentR, parentC, endR, endC);
        }

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (valid(nr, nc, grid)) {
                int newDist = curDist + 1;

                if (newDist < dist[nr][nc]) {
                    dist[nr][nc] = newDist;

                    parentR[nr][nc] = r;
                    parentC[nr][nc] = c;

                    pq.add(new int[]{nr, nc, newDist});
                }
            }
        }
    }

    return null;
}
   public static List<int[]> astar(int[][] grid, int startR, int startC, int endR, int endC) {

    int rows = grid.length;
    int cols = grid[0].length;

    int[][] gCost = new int[rows][cols];  // cost from start
    int[][] parentR = new int[rows][cols];
    int[][] parentC = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
        Arrays.fill(gCost[i], Integer.MAX_VALUE);
        Arrays.fill(parentR[i], -1);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

    gCost[startR][startC] = 0;
    int h = Math.abs(startR - endR) + Math.abs(startC - endC);

    pq.add(new int[]{startR, startC, h}); // f = g + h

    int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int r = cur[0];
        int c = cur[1];

        if (r == endR && c == endC) {
            return rebuildPath(parentR, parentC, endR, endC);
        }

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (valid(nr, nc, grid)) {

                int g = gCost[r][c] + 1;  // cost to move
                int hCost = Math.abs(nr - endR) + Math.abs(nc - endC);  // heuristic
                int f = g + hCost;

                if (g < gCost[nr][nc]) {
                    gCost[nr][nc] = g;

                    parentR[nr][nc] = r;
                    parentC[nr][nc] = c;

                    pq.add(new int[]{nr, nc, f});
                }
            }
        }
    }

    return null;
}

    private static boolean valid(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length &&
                c >= 0 && c < grid[0].length &&
                grid[r][c] != GridPanel.WALL;
    }

    private static List<int[]> rebuildPath(int[][] parentR, int[][] parentC, int endR, int endC) {

        List<int[]> path = new ArrayList<>();
        int r = endR;
        int c = endC;

        while (r != -1 && c != -1) {
            path.add(new int[]{r, c});
            int pr = parentR[r][c];
            int pc = parentC[r][c];
            r = pr;
            c = pc;
        }

        Collections.reverse(path);
        return path;
    }
}