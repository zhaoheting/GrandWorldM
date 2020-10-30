package web.services.learn;
//第一轮面试
public class Interview {
    private static class myLinkedList {
        private int theSize;
        private Node head;

        public myLinkedList() {
            this.head = new Node();
        }

        //delete
        private void deleteKthElement(int index) {
            //the size - index.
            if (index > theSize || index <= 0) {
                return;
            }
            int forwardIndex = theSize - index + 1;
            Node current = head;
            Node previous = null;
            for (int i = 1; i <= forwardIndex; i++) {
                previous = current;
                current = current.next;
            }
            //current is the kth.
            previous.next = current.next;
        }

        private void insert(int x) {
            Node node = new Node();
            node.val = x;
            Node current = getLast();
            current.next = node;
            this.theSize++;
        }

        private Node getLast() {
            Node current = head;
            if (theSize != 0) {
                for (int i = 1; i <= this.theSize; i++) {
                    current = current.next;
                }
            }
            return current;
        }

        private static class Node {
            int val;
            Node next;

            public Node() {
            }

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
