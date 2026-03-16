public class CustomList {
    private Node start;

    public CustomList(){
        start = null;
    }

    public CustomList(int info){
        start = new Node(info);
    }

    public CustomList(int[] massiv){
        for (int i = massiv.length-1; i>=0; i--){
            add(massiv[i]);
        }
    }

    public void add(int info){
        Node node = new Node(info);
        node.nextNode = start;
        start = node;
    }

    public void print(){
        if (start == null){
            System.out.println("Список пуст.");
            return;
        }

        Node pointer = start;

        while (pointer != null){
            if (pointer.nextNode == null){
                System.out.print(pointer.info);
            }
            else{
                System.out.print(pointer.info + ", ");
            }
            pointer = pointer.nextNode;
        }
        System.out.println();
    }

    public void deleteLast(){

        if (start == null){
            System.out.println("Список пуст. Удаление невозможно.");
            return;
        }

        if (start.nextNode == null){
            start = null;
            return;
        }

        Node pointer = start;
        while (pointer.nextNode.nextNode != null){
            pointer = pointer.nextNode;
        }
        pointer.nextNode = null;
    }

    public void reverse(){
        Node pointer = start;
        Node prev = null;
        Node next;
        while (pointer != null){
            next = pointer.nextNode;
            pointer.nextNode = prev;
            prev = pointer;
            pointer = next;
        }
        start = prev;
    }

    public int length(){
        Node pointer = start;
        int count = 0;
        while (pointer!=null){
            count+=1;
            pointer = pointer.nextNode;
        }
        return count;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public boolean isInList(int element){
        Node pointer = start;
        while (pointer != null){
            if (pointer.info == element){
                return true;
            }
            pointer = pointer.nextNode;
        }
        return false;
    }

    public void getIndex(int element){
        Node pointer = start;
        int counter = 0;

        while (pointer != null){
            if (pointer.info == element){
                System.out.print(counter + ", ");
            }
            pointer = pointer.nextNode;
            counter += 1;
        }
        System.out.println();
    }
}