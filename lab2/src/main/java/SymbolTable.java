public class SymbolTable {

    private static final int SIZE = 100;
    private final HashMap hashMap;

    public SymbolTable(int size) {
        this.hashMap = new HashMap(size);
    }

    public SymbolTable() {
        this.hashMap = new HashMap(SIZE);
    }

    public void insert(String s) {
        hashMap.add(s);
    }

    public int getIndex(String s) {
        return hashMap.getIndex(s);
    }

}
