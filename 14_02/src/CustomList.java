public class CustomList {
    private Node start;

    public CustomList() {
        start = null;
    }

    public CustomList(int info) {
        start = new Node(info);
    }

    public CustomList(int[] massiv) {
        for (int i = massiv.length - 1; i >= 0; i--) {
            add(massiv[i]);
        }
    }

    public void add(int info) {
        Node node = new Node(info);
        node.nextNode = start;
        start = node;
    }

    public void print() {
        if (start == null) {
            System.out.println("Список пуст.");
            return;
        }

        Node pointer = start;

        while (pointer != null) {
            if (pointer.nextNode == null) {
                System.out.print(pointer.info);
            } else {
                System.out.print(pointer.info + ", ");
            }
            pointer = pointer.nextNode;
        }
        System.out.println();
    }

    public void deleteLast() {

        if (start == null) {
            System.out.println("Список пуст. Удаление невозможно.");
            return;
        }

        if (start.nextNode == null) {
            start = null;
            return;
        }

        Node pointer = start;
        while (pointer.nextNode.nextNode != null) {
            pointer = pointer.nextNode;
        }
        pointer.nextNode = null;
    }

    public void reverse() {
        Node pointer = start;
        Node prev = null;
        Node next;
        while (pointer != null) {
            next = pointer.nextNode;
            pointer.nextNode = prev;
            prev = pointer;
            pointer = next;
        }
        start = prev;
    }

    public int length() {
        Node pointer = start;
        int count = 0;
        while (pointer != null) {
            count += 1;
            pointer = pointer.nextNode;
        }
        return count;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public boolean isInList(int element) {
        Node pointer = start;
        while (pointer != null) {
            if (pointer.info == element) {
                return true;
            }
            pointer = pointer.nextNode;
        }
        return false;
    }

    public int getIndex(int element) {
        Node pointer = start;
        int counter = 0;

        while (pointer != null) {
            if (pointer.info == element) {
                return counter;
            }
            pointer = pointer.nextNode;
            counter += 1;
        }
        return -1;
    }

    public int getValue(int index){
        Node pointer = start;
        int counter = 0;

        if(index == 0){
            return start.info;
        }
        while (counter < index) {
            pointer = pointer.nextNode;
            counter += 1;
        } if (counter == index){
            return pointer.info;
        }
        return -1;
    }

    public void addByIndex(int index, int value) {
        Node pointer = start;
        Node newNode = new Node(value);

        if (index < 0) {
            System.out.println("введите положительный индекс");
            return;
        }

        if (index == 0) {
            add(value);
            return;
        }

        if (index > length() + 1) {
            System.out.println("слишком большой индекс");
            return;
        }

        int counter = 0;
        while (counter < index - 1) {
            pointer = pointer.nextNode;
            counter++;
        }

        if (counter == index - 1) {
            Node temp = pointer.nextNode;
            pointer.nextNode = newNode;
            newNode.nextNode = temp;
        }
    }

    public void swap(int index1, int index2) {
        Node first = new Node(getValue(index1));
        Node second = new Node(getValue(index2));
        Node prev = new Node(0);
        Node cont = new Node(0);
        Node pointer = start;
        Node temp = new Node(0);

        if (start == null || start.nextNode == null) {
            return;
        }

        if (index2 == index1){
            return;
        }

        if (index1 == 0){
            int counter = 0;
            while(counter < index2 -1){
                pointer = pointer.nextNode;
                counter++;
            }if (counter == index2 - 1){
                prev = pointer;
                cont = pointer.nextNode.nextNode;
            }

            prev.nextNode = first;
            first.nextNode = cont;

            second.nextNode = start.nextNode;
            start = second;
        }
        int counter = 0;
        while(counter < index1){
            if (counter == index1 - 1){
                prev = pointer;
            }
            pointer = pointer.nextNode;
            counter++;

        } if (counter == index1){
            cont = pointer.nextNode;
        }

        counter = 0;
        pointer = start;
        while(counter < index2 -1) {
            pointer = pointer.nextNode;
            counter++;
        }

        second.nextNode = cont;
        prev.nextNode = second;

        temp = pointer.nextNode;
        pointer.nextNode = first;
        first.nextNode = pointer.nextNode;

    }
}

//
//        if (index2 == index1){
//            return;
//        }
//
//        int counter = 0;
//        Node pointer = start;
//        Node prev1 = new Node(0);
//        Node our1 = new Node(0);
//        Node next1 = new Node(0);
//        Node prev2 = new Node(0);
//        Node our2 = new Node(0);
//        Node next2 = new Node(0);
//
//        if (index1 == 0){
//            while (counter != index2 - 1) {
//                pointer = pointer.nextNode;
//                counter++;
//            }if (counter == index2 - 1) {
//                prev2 = pointer;
//                our2 = pointer.nextNode;
//                next2 = pointer.nextNode.nextNode;
//            }
//
//            prev2.nextNode = start;
//            our2.nextNode = start.nextNode;
//
//            start = pointer.nextNode;
//            start.nextNode = next2;
//
//            return;
//        }
//
//        if (index2 == 0){
//            while (counter != index1 - 1) {
//                pointer = pointer.nextNode;
//                counter++;
//            }if (counter == index1 - 1) {
//                prev2 = pointer;
//                our2 = pointer.nextNode;
//                next2 = pointer.nextNode.nextNode;
//            }
//
//            prev2.nextNode = start;
//            our2.nextNode = start.nextNode;
//
//            start = pointer.nextNode;
//            start.nextNode = next2;
//
//            return;
//        }
//
//        while (counter != index1 - 1) {
//            pointer = pointer.nextNode;
//            counter++;
//        }
//
//        if (counter == index1 - 1) {
//            prev1 = pointer;
//            our1 = pointer.nextNode;
//            next1 = pointer.nextNode.nextNode;
//        }
//
//        counter = 0;
//        pointer = start;
//
//        while (counter != index2 - 1) {
//            pointer = pointer.nextNode;
//            counter++;
//        }
//
//        if (counter == index2 - 1) {
//            prev2 = pointer;
//            our2 = pointer.nextNode;
//            next2 = pointer.nextNode.nextNode;
//        }
//
//        prev1.nextNode = our2;
//        prev2.nextNode = our1;
//
//        our2.nextNode = next1;
//        our1.nextNode = next2;
//
//    }
//}
//        int counter = 0;
//        Node pointer = start;
//        Node first = new Node(0);
//        Node second = new Node(0);
//        Node temp = new Node(0);
//        Node temp1 = new Node(0);
//
//        while (counter <= index1 | counter <= index2) {
//            if (counter == index1 - 1) {
//                first = pointer;
//            }
//            if (counter == index2 - 1) {
//                second = pointer;
//            }
//
//            pointer = pointer.nextNode;
//            counter++;
//        }
//
//        if((first.nextNode.nextNode == null) | (second.nextNode.nextNode == null)){
//            temp = first.nextNode;
//            first.nextNode
//        }
//        temp = first.nextNode;
//        first.nextNode = second.nextNode;
//        second.nextNode = temp.nextNode;
//
//        temp1 = second.nextNode.nextNode;
//        second.nextNode = temp;
//        temp.nextNode = temp1;
//
//    }
