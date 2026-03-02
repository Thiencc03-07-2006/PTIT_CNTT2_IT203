import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Stack
        Stack<Integer> stack = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        printStack(stack);
        String str = "Hello World";
        for (String e : str.split(" ")) {
            stackStr.push(e);
        }
        ;
        printStack(stackStr);
        //Queue
        Queue<String> queue = new ArrayDeque<>();
        queue.add("Apple");
        queue.offer("Banana");
        queue.remove();
        queue.poll();
        queue.peek();
        queue.element();
        //LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("ahaha");
        linkedList.getFirst();
        linkedList.addLast("ehe");
        linkedList.getLast();
    }

    private static <T> void printStack(Stack<T> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}