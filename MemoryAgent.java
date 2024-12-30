import java.util.Random;

public class MemoryAgent implements Runnable{

    private String AgentID;
    private int iterations;
    private Memory memory;
    private boolean debug = false;

    public MemoryAgent(String AgentID, int iterations, Memory memory){ this.AgentID = AgentID; this.iterations = iterations; this.memory = memory; }

    @Override
    public void run() {
        System.out.println("Memory Agent, " + AgentID + ", has started its process.");
        for(int i = 0; i < iterations; i++){
            Random rand = new Random();
            int address = rand.nextInt(memory.size());
            int value = getRandomValue();
            memory.store(address, value);
            try{ Thread.sleep(10); } catch(InterruptedException e){ e.printStackTrace(); }
            if(debug){ System.out.println("Memory Agent, " + AgentID + ", has stored value " + value + " at address " + address + "."); }
        }
        System.out.println("Memory Agent, " + AgentID + ", has finished storing values in memory.");
    }


    private static int getRandomValue(){
        Random rand = new Random();
        return rand.nextInt(0, Integer.MAX_VALUE);
    }

    public void toogleDebug(){ this.debug = !this.debug; }
}