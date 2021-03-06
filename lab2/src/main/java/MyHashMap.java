import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private List<LinkedList<String>> list;
    private int size;

    private static final int NO_INDEX = -1;


    public MyHashMap(int size) {
        this.size = size;
        this.list = new ArrayList<LinkedList<String>>();
        for (int i = 0; i < this.size; i++) {
            this.list.add(new LinkedList<>());
        }
    }

    public int getIndex(String s) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(s)) {
                return i;
            }
        }
        return NO_INDEX;
    }

    public int add(String s) {
        int index = hash(s);
        if (list.get(index).contains(s)) {
            return index;
        }
        list.get(index).add(s);
        return index;
    }

    private int hash(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }
        return sum % size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() != 0 ) {
                sb.append(i).append("   -    ").append(list.get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
