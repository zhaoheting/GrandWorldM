package web.services.learn.lessons;

class Solution {

    public static void main(String[] args) {
        ListNode root = initList();
        ListNode node = insertionSortList(root);
        System.out.println(node.val);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = head;
        //从第二个节点开始比较
        ListNode current = head.next;
        ListNode nextNode = null;
        root.next = null;
        while (current != null) {
            nextNode = current.next;
            root = insert(root, current);
            current = nextNode;
        }
        return root;
    }

    //将node节点插入到以root为根节点的list中,保持list升序。
    private static ListNode insert(ListNode root, ListNode node) {
        if (root.val > node.val) {
            node.next = root;
            root = node;
        } else {
            ListNode current = root.next;
            ListNode previous = root;
            while (current != null && current.val < node.val) {
                previous = current;
                current = current.next;
            }
            previous.next = node;
            node.next = current;
        }
        return root;
    }

    private static ListNode initList() {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        return root;
    }
//    public static ListNode sortList(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        int length = 0;
//        ListNode node = head;
//        while (node != null) {
//            length++;
//            node = node.next;
//        }
//        ListNode dummyHead = new ListNode(0, head);
//        for (int subLength = 1; subLength < length; subLength <<= 1) {
//            ListNode prev = dummyHead, curr = dummyHead.next;
//            while (curr != null) {
//                ListNode head1 = curr;
//                for (int i = 1; i < subLength && curr.next != null; i++) {
//                    curr = curr.next;
//                }
//                ListNode head2 = curr.next;
//                curr.next = null;
//                curr = head2;
//                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
//                    curr = curr.next;
//                }
//                ListNode next = null;
//                if (curr != null) {
//                    next = curr.next;
//                    curr.next = null;
//                }
//                ListNode merged = merge(head1, head2);
//                prev.next = merged;
//                while (prev.next != null) {
//                    prev = prev.next;
//                }
//                curr = next;
//            }
//        }
//        return dummyHead.next;
//    }
//
//    public static ListNode merge(ListNode head1, ListNode head2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
//        while (temp1 != null && temp2 != null) {
//            if (temp1.val <= temp2.val) {
//                temp.next = temp1;
//                temp1 = temp1.next;
//            } else {
//                temp.next = temp2;
//                temp2 = temp2.next;
//            }
//            temp = temp.next;
//        }
//        if (temp1 != null) {
//            temp.next = temp1;
//        } else if (temp2 != null) {
//            temp.next = temp2;
//        }
//        return dummyHead.next;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
