package pathvisualizer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Main{
    public static GridPanel gridPanel;
    public static void main (String[] args){
        SwingUtilities.invokeLater(()->{
            JFrame frame=new JFrame ("Pathfinding Visualizer-Java");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gridPanel= new GridPanel();
            ControlPanel controlPanel=new ControlPanel();

            frame.setLayout(new BorderLayout());
            frame.add(gridPanel,BorderLayout.CENTER);
            frame.add(controlPanel,BorderLayout.EAST);

            frame.setSize(900,600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        }
}
