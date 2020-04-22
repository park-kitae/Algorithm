package algorithm.study.stack;

public class 링크드리스트로_스택만들기 {

    public static void main(String[] args) {
        Object[] items = {"one", "투", 3, 4f, "five", 6d};
        //stackCall(items);
        queueCall(items);
    }

    public static void stackCall(Object[] items){
        LinkedListStack stack = new LinkedListStack();
        for (Object item : items) {
            stack.push(item);
        }

        System.out.println("====================");
        stack.peek();
        System.out.println("====================");
        stack.pop();
        stack.pop();
        System.out.println("====================");
        stack.search(4f);
    }

    public static void queueCall(Object[] items){
        LinkedListQueue queue = new LinkedListQueue();
        for (Object item : items) {
            queue.offer(item);
        }

        System.out.println("====================");
        queue.peek();
        System.out.println("====================");
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println("====================");
        queue.offer(items[2]);
        queue.offer(items[3]);
        queue.offer(items[4]);
        System.out.println("====================");
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
    }

    public static class Node{
        private Object value;
        private Node nextNode;
        public Node(Object value, Node nextNode){
            this.value = value;
            this.nextNode = nextNode;
        }

        public Node getNext(){
            return this.nextNode;
        }

        public Object getValue(){
            return this.value;
        }

        public void setNextNode(Node node){
            this.nextNode = node;
        }
    }

    public static class LinkedListStack{
        Node top = null;
        int size = -1;

        public void push(Object value){
            top = new Node(value, top);
            size++;
            System.out.println(String.format("push ==> %s", String.valueOf(top.getValue())));
        }

        public void pop(){
            System.out.println(String.format("pop ==> %s", String.valueOf(top.getValue())));
            size--;
            top = top.nextNode;
        }

        public void peek(){
            System.out.println(String.format("peek ==> %s", String.valueOf(top.getValue())));
        }

        public int search(Object value){
            Node searchNode = top;
            int index = size;
            do {
                if(searchNode.getValue().equals(value)){
                    System.out.println(String.format("search ==> %s, location[%d]", String.valueOf(value), index));
                    return index;
                }

                index--;
                searchNode = searchNode.getNext();
            } while (searchNode != null);

            System.out.println(String.format("search ==> not found"));
            return -1;
        }
    }

    public static class LinkedListQueue{
        private Node first;
        private Node last;
        private int size = -1;

        public void offer(Object value){
            if(first == null){
                first = new Node(value, null);
                last = first;
            }else{
                Node newNode = new Node(value, null);
                last.setNextNode(newNode);
                last = newNode;
            }
            System.out.println(String.format("offer ==> %s", String.valueOf(value)));
            size++;
        }

        public void peek(){
            System.out.println(String.format("peek ==> %s", String.valueOf(first.getValue())));
        }

        public void poll(){
            if(size == -1){
                System.out.println(String.format("poll ==> %s", "is empty!"));
                return;
            }

            size--;
            Node returnNode = first;
            first = returnNode.nextNode;
            System.out.println(String.format("poll ==> %s", String.valueOf(returnNode.getValue())));
        }
    }

}
