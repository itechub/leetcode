/**
 * @author jiofeng
 * @date 2020/2/27
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        OthersSolution solution = new OthersSolution();
        int[] data1 = {-2, 5};
//        int[] data1 = {1, 4, 5};
        ListNode l1 = getListNode(data1);
        int[] data2 = {-9, -3, 1};
//        int[] data2 = {2, 3, 4};
        ListNode l2 = getListNode(data2);
        ListNode resultNode = solution.mergeTwoLists(l1, l2);
        do {
            System.out.print(String.format("%s ", resultNode.val));
            resultNode = resultNode.next;
        } while (resultNode != null);
    }

    private static ListNode getListNode(int[] data) {
        ListNode first = new ListNode(data[0]);
        ListNode index = first;
        for (int i = 0; i < data.length - 1; i++) {
            index.next = new ListNode(data[i + 1]);
            index = index.next;
        }
        return first;
    }
}

/**
 * 还是别人的好
 */
class OthersSolution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/**
 * 屎特, 我的方法太吃屎了
 */
class MySolution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return merge(l1, l2, null);
    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode startNode) {
        if (l2 == null) {
            listNodeToEnd(l1, startNode);
            return startNode;
        }
        if (l1 == null) {
            listNodeToEnd(l2, startNode);
            return startNode;
        }
        ListNode targetNodeNext;
        ListNode offset;
        if (l1.val < l2.val) {
            ListNode targetNode = findNodeLoe(l1, l2.val);
            targetNodeNext = targetNode.next;
            targetNode.next = l2;
            if (startNode == null) {
                startNode = l1;
            }
            offset = l2;
        } else {
            ListNode targetNode = findNodeLoe(l2, l1.val);
            targetNodeNext = targetNode.next;
            targetNode.next = l1;
            if (startNode == null) {
                startNode = l2;
            }
            offset = l1;
        }
        if (targetNodeNext == null) {
            return startNode;
        }
        return merge(offset, targetNodeNext, startNode);
    }

    private void listNodeToEnd(ListNode l, ListNode startNode) {
        ListNode end = startNode;
        while (end.next != null) {
            end = end.next;
        }
        end.next = l;
    }

    private ListNode findNodeLoe(ListNode l, int val) {
        if (l.next == null) {
            return l;
        }
        if (l.next.val > val) {
            return l;
        }
        return findNodeLoe(l.next, val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
