/**
 * @author jiofeng
 * @date 2020/3/1
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
        int[] data1 = {1, 4, 5};
        ListNode l1 = getListNode(data1);
        int[] data2 = {2, 3, 5};
        ListNode l2 = getListNode(data2);
        ListNode resultNode = solution.addTwoNumbers(l1, l2);
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


class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, null, false);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode resultNode, boolean carryFlag) {
        if (l1 == null && l2 == null) {
            if (carryFlag) {
                setResultNodeNext(resultNode, 1);
            }
            return resultNode;
        }

        if(l1 == null) {
            l1 = new ListNode(0);
        }

        if(l2 == null) {
            l2 = new ListNode(0);
        }

        int decade = 10;
        int sum = l1.val + l2.val;
        if (carryFlag) {
            sum++;
            carryFlag = false;
        }
        int resultVal = sum;
        if (sum >= decade) {
            resultVal = sum % decade;
            carryFlag = true;
        }

        if (resultNode == null) {
            resultNode = new ListNode(resultVal);
        } else {
            setResultNodeNext(resultNode, resultVal);
        }

        return addTwoNumbers(l1.next, l2.next, resultNode, carryFlag);
    }

    private static void setResultNodeNext(ListNode resultNode, int resultVal) {
        ListNode targetNode = resultNode;
        while (targetNode.next != null) {
            targetNode = targetNode.next;
        }
        targetNode.next = new ListNode(resultVal);
    }
}