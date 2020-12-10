package bai11_dsa_stack_queue.bai_tap.ex_1_dao_nguoc_mang_so_nguyen;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackList<T> {
    private LinkedList<T> stack;

    StackList(){
        stack =new LinkedList();
    }

    public void push(T e){
        stack.addFirst(e);
    }

    public T pop (){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public boolean isEmpty(){
        if(stack.size()== 0){
            return true;
        }
        return false;
    }

    public int size(){
        return stack.size();
    }



}
