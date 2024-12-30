public class Memory {
    private int[] memory = new int[1000];

    public Memory(int size) { memory = new int[size]; }

    public void initialize() { for(int i = 0; i < memory.length; i++) { memory[i] = 0; } }
    public void store(int address, int value) { memory[address] = value; }
    public int load(int address) { return memory[address]; }
    public void print() { for(int i : memory) { System.out.println("[" + i + "]"); } }
    public int size() { return memory.length; }

    public String stringify() {
        String str = "";
        for(int i : memory) {
            if(i == 0) { str += " ";}
            else { str += (char) i; }
        }
        return str;
    }
}
