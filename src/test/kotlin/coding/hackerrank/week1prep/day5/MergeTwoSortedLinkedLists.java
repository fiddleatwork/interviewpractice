package coding.hackerrank.week1prep.day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// Not pretty but this is a cumbersome exercise especially in Java so leaving it as is.
public class MergeTwoSortedLinkedLists {

    @Test
    public void example1() {
        assertThat(
                mergeLists(
                        new SinglyLinkedListNode(
                                1,
                                new SinglyLinkedListNode(
                                        3,
                                        new SinglyLinkedListNode(
                                                7,
                                                null
                                        )
                                )
                        ),
                        new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, null))
                ).toString()
        ).isEqualTo(
                new SinglyLinkedListNode(
                        1,
                        new SinglyLinkedListNode(
                                1,
                                new SinglyLinkedListNode(
                                        2,
                                        new SinglyLinkedListNode(
                                                3,
                                                new SinglyLinkedListNode(
                                                        7,
                                                        null
                                                )
                                        )
                                )
                        )
                ).toString()
        );
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
        SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            StringBuilder result = new StringBuilder(String.valueOf(data));
            SinglyLinkedListNode pointer = this.next;
            while(pointer != null) {
                result.append(" ");
                result.append(String.valueOf(pointer.data));
                pointer = pointer.next;
            }
            return result.toString();
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode pointer1 = head1;
        SinglyLinkedListNode pointer2= head2;
        SinglyLinkedListNode result = null;
        SinglyLinkedListNode resultPointer = null;
        while(pointer1 != null && pointer2 != null) {
            if(pointer1.data < pointer2.data) {
                if(result == null) {
                    result = new SinglyLinkedListNode(pointer1.data);
                    resultPointer = result;
                } else {
                    resultPointer.next = new SinglyLinkedListNode(pointer1.data);
                    resultPointer = resultPointer.next;
                }
                pointer1 = pointer1.next;
            } else {
                if(result == null) {
                    result = new SinglyLinkedListNode(pointer2.data);
                    resultPointer = result;
                } else {
                    resultPointer.next = new SinglyLinkedListNode(pointer2.data);
                    resultPointer = resultPointer.next;
                }
                pointer2 = pointer2.next;
            }
        }
        while(pointer1 != null) {
            // copy paste from above
            if(result == null) {
                result = new SinglyLinkedListNode(pointer1.data);
                resultPointer = result;
            } else {
                resultPointer.next = new SinglyLinkedListNode(pointer1.data);
                resultPointer = resultPointer.next;
            }
            pointer1 = pointer1.next;
        }
        while(pointer2 != null) {
            // copy paste from above
            if(result == null) {
                result = new SinglyLinkedListNode(pointer2.data);
                resultPointer = result;
            } else {
                resultPointer.next = new SinglyLinkedListNode(pointer2.data);
                resultPointer = resultPointer.next;
            }
            pointer2 = pointer2.next;
        }
        return result;
    }

}
