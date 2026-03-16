import LinkedNode.CustomList;

public class Main {
    public static void main(String[] args) {
        CustomList customList = new CustomList(1);
        customList.print();

        int[] massiv = new int[] {1,2,3,4};
        CustomList customList1 = new CustomList(massiv);
        customList1.print();

        customList.print();

        customList1.deleteLast();
        customList1.print();

        customList.addByIndex(5, 2);
        customList.print();

        customList1.print();
        customList1.swap(1, 2); //не работает(
        customList1.print();
    }
}