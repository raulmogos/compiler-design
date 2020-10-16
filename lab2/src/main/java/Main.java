public class Main {
    public static void main(String[] args) {
        System.out.println("hello lab2");

        SymbolTable symbolTable = new SymbolTable(100);

        symbolTable.insert("hello");
        symbolTable.insert("lab");
        symbolTable.insert("2");
        symbolTable.insert("!");

        // should print their indexes
        System.out.println(symbolTable.getIndex("hello"));
        System.out.println(symbolTable.getIndex("lab"));
        System.out.println(symbolTable.getIndex("2"));
        System.out.println(symbolTable.getIndex("!"));

        // should print -1 every time
        System.out.println(symbolTable.getIndex("this"));
        System.out.println(symbolTable.getIndex("is"));
        System.out.println(symbolTable.getIndex("working"));
    }
}
