package pathvisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GridPanel extends JPanel implements MouseListener, MouseMotionListener {

    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int END = 3;

    private final int rows = 20;
    private final int cols = 30;
    private final int cellSize = 25;

    private int[][] grid = new int[rows][cols];

    private int startR = 5, startC = 5;
    private int endR = 10, endC = 20;

    public GridPanel() {
        int width = cols * cellSize;
        int height = rows * cellSize;
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(25, 25, 25));

        grid[startR][startC] = START;
        grid[endR][endC] = END;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                int x = c * cellSize;
                int y = r * cellSize;

                switch (grid[r][c]) {
                    case EMPTY:
                        g.setColor(new Color(40, 40, 40));
                        break;
                    case WALL:
                        g.setColor(Color.DARK_GRAY);
                        break;
                    case START:
                        g.setColor(Color.GREEN);
                        break;
                    case END:
                        g.setColor(Color.RED);
                        break;
                    case 5:
                        g.setColor(Color.YELLOW);
                        break;
                }

                g.fillRect(x, y, cellSize, cellSize);
                g.setColor(new Color(70, 70, 70));
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
    }

    // --- Mouse Logic (Make Walls) ---
    @Override
    public void mousePressed(MouseEvent e) {
        int c = e.getX() / cellSize;
        int r = e.getY() / cellSize;

        if (valid(r, c) && grid[r][c] == EMPTY)
            grid[r][c] = WALL;

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int c = e.getX() / cellSize;
        int r = e.getY() / cellSize;

        if (valid(r, c) && grid[r][c] == EMPTY)
            grid[r][c] = WALL;

        repaint();
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
    @Override
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void runBFS() {
    List<int[]> path = Pathfinder.bfs(grid, startR, startC, endR, endC);

    if (path == null) {
        System.out.println("No path found!");
        return;
    }

    // Mark path in yellow
    for (int[] p : path) {
        int r = p[0];
        int c = p[1];
        if (grid[r][c] != START && grid[r][c] != END)
            grid[r][c] = 5; // PATH color
    }

    repaint();
}
   public void runDFS() {
    List<int[]> path = Pathfinder.dfs(grid, startR, startC, endR, endC);

    if (path == null) {
        System.out.println("No path (DFS)!");
        return;
    }

    for (int[] p : path) {
        int r = p[0];
        int c = p[1];
        if (grid[r][c] != START && grid[r][c] != END)
            grid[r][c] = 5; // PATH
    }

    repaint();
}
public void runDijkstra() {
    List<int[]> path = Pathfinder.dijkstra(grid, startR, startC, endR, endC);

    if (path == null) {
        System.out.println("No path (Dijkstra)!");
        return;
    }

    for (int[] p : path) {
        int r = p[0];
        int c = p[1];
        if (grid[r][c] != START && grid[r][c] != END)
            grid[r][c] = 5;
    }

    repaint();
}
public void runAStar() {
    List<int[]> path = Pathfinder.astar(grid, startR, startC, endR, endC);

    if (path == null) {
        System.out.println("No path (A*)!");
        return;
    }

    for (int[] p : path) {
        int r = p[0];
        int c = p[1];
        if (grid[r][c] != START && grid[r][c] != END)
            grid[r][c] = 5;
    }

    repaint();
}
public void resetGrid() {
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            grid[r][c] = EMPTY;
        }
    }

    // Restore start + end
    grid[startR][startC] = START;
    grid[endR][endC] = END;

    repaint();
}

}