package pathvisualizer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ControlPanel extends JPanel {

    public ControlPanel() {
        // Fixed width panel on the right
        setPreferredSize(new Dimension(230, 600));
        setBackground(new Color(15, 15, 15));

        // Vertical layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        JLabel title = new JLabel("Controls / Stats");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(LEFT_ALIGNMENT);

        add(title);
        // Later we will add buttons, labels, algorithm choices here

        JButton bfsBtn = new JButton("Run BFS");
        bfsBtn.setAlignmentX(LEFT_ALIGNMENT);

        bfsBtn.addActionListener(e -> {
        Main.gridPanel.runBFS();
        });

        JButton dfsBtn = new JButton("Run DFS");
        dfsBtn.setAlignmentX(LEFT_ALIGNMENT);

        dfsBtn.addActionListener(e -> {
        Main.gridPanel.runDFS();
        });

        JButton dijBtn = new JButton("Run Dijkstra");
        dijBtn.setAlignmentX(LEFT_ALIGNMENT);

        dijBtn.addActionListener(e -> {
        Main.gridPanel.runDijkstra();
        });

        JButton aStarBtn = new JButton("Run A*");
        aStarBtn.setAlignmentX(LEFT_ALIGNMENT);

        aStarBtn.addActionListener(e -> {
        Main.gridPanel.runAStar();
        });

        JButton resetBtn = new JButton("Reset");
        resetBtn.setAlignmentX(LEFT_ALIGNMENT);

        resetBtn.addActionListener(e -> {
        Main.gridPanel.resetGrid();
        });

add(Box.createRigidArea(new Dimension(0, 10)));
add(resetBtn);  

add(Box.createRigidArea(new Dimension(0, 10)));
add(aStarBtn);

add(Box.createRigidArea(new Dimension(0, 10)));
add(dijBtn);

add(Box.createRigidArea(new Dimension(0, 10)));
add(dfsBtn);

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(bfsBtn);
    }
}