package bai11_dsa_stack_queue.thuc_hanh.ex_1_trien_khai_stack;

public class GenericStackClient {
    private static void stackOfStrings() {
        MyGenericStack<String> stack = new MyGenericStack();
        stack.push("five");
        stack.push("four");
        stack.push("three");
        stack.push("two");
        stack.push("one");
        System.out.println("1.1 Size of stack after push operations: "+stack.size());
        System.out.println("1.2 Pop elements from stack: ");
        while(!stack.isEmpty()){
            System.out.printf("%s",stack.pop());
        }
        System.out.println("\n 3. Size of stack after pop operations: "+ stack.size());
    }

    private static void stackOfIntegers(){
        MyGenericStack<Integer> stack = new MyGenericStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("1.1 Size of stack after push operations: "+stack.size());
        System.out.println("1.2 Pop elements from stack: ");
        while(!stack.isEmpty()){
            System.out.printf("%s",stack.pop());
        }
        System.out.println("\n 3. Size of stack after pop operations: "+ stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of integers: ");
        stackOfIntegers();
        System.out.println("2. Stack of String: ");
        stackOfStrings();
    }

}

