package nodes;

public class ListNode <T>  {
        public ListNode(T x) {
            value = x;
        }

        public T value;
        public ListNode<T> next;
        private ListNode<T> last;

        public void addNode( ListNode<T> node){
            ListNode<T> current = this;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
}
