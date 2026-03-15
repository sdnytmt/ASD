public class Main {
    public static void main(String[] args) {
        CustomList customList = new CustomList(1);
        customList.print();

        int[] massiv = new int[] {1,2,3,4};
        CustomList customList1 = new CustomList(massiv);
        customList1.print();

        customList.deleteLast();
        customList.print();

        customList.deleteLast();
        customList1.deleteLast();
        customList1.print();
    }
}