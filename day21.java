import java.util.*;

class ReverseStackRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of stack
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        // Input stack elements
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        // Reverse the stack
        reverseStack(stack);

        // Print reversed stack
        System.out.println("Reversed Stack (top -> bottom): " + stack);

        sc.close();
    }

    // Function to reverse stack recursively
    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, top);
        }
    }

    // Helper function: Insert element at bottom of stack
    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertAtBottom(stack, element);
            stack.push(top);
        }
    }
}
