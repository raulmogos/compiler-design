import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap {

    private List<LinkedList<String>> list;
    private int size;

    private static final int NO_INDEX = -1;


    public HashMap(int size) {
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

    public void add(String s) {
        int index = hash(s);
        if (list.get(index).contains(s)) {
            return;
        }
        list.get(index).add(s);
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
}
