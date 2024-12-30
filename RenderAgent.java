import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class RenderAgent implements Runnable{
    private String AgentID;
    private int iterations;
    private Memory memory;
    private boolean initialized = false;

    public RenderAgent(String AgentID, int iterations, Memory memory){ this.AgentID = AgentID; this.iterations = iterations; this.memory = memory; }

    @Override
    public void run() {
        JFrame frame = new JFrame("Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        JPanel  panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                for(int i = 0; i < memory.size(); i++){
                    int value = memory.load(i);
                    int[] coords = mapTo2D(i);
                    Color c = new Color(value);
                    g.setColor(c);
                    g.drawRect(coords[0], coords[1], 1, 1);
                }
            }
        };

        frame.add(panel);

        this.initialized = true;
        System.out.println("Render Agent, " + AgentID + ", has finished initializing.");

        try{ Thread.sleep(100); } catch(InterruptedException e){ e.printStackTrace(); }

        for(int i = 0; i < iterations; i++){
            frame.repaint();
            try{ Thread.sleep(5); } catch(InterruptedException e){ e.printStackTrace(); }
        }

        System.out.println("Render Agent, " + AgentID + ", has finished rendering.");
    }
    
    public boolean isInitialized(){ return this.initialized; }

    private int[] mapTo2D(int index){
        int x = index % 800;
        int y = index / 800;
        return new int[]{x, y};
    }
}
