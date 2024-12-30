public class Main{
    public static void main(String[] args){
        
        int size = 800*600;
        System.out.println(size);

        Memory mem = new Memory(size);
        mem.initialize();

        int iterations = 480000;

        RenderAgent R = new RenderAgent("R", iterations, mem);
        MemoryAgent A = new MemoryAgent("A", iterations, mem);
        MemoryAgent B = new MemoryAgent("B", iterations, mem);

        Thread t0 = new Thread(R); t0.start();
        Thread t1 = new Thread(A); t1.start();
        Thread t2 = new Thread(B); t2.start();
    }
}