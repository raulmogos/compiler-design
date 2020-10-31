
public class SymbolTable {

    private static final int SIZE = 100;
    private final MyHashMap myHashMap;

    public SymbolTable(int size) {
        this.myHashMap = new MyHashMap(size);
    }

    public SymbolTable() {
        this.myHashMap = new MyHashMap(SIZE);
    }

    public int add(String s) {
        return myHashMap.add(s);
    }

    public int getIndex(String s) {
        return myHashMap.getIndex(s);
    }

    @Override
    public String toString() {
        return myHashMap.toString();
    }
}
