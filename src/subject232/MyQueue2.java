package subject232;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/28/13:17
 * @Description:
 */
public class MyQueue2 {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;
    public MyQueue2() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        ensureOutputStack();
        return outputStack.pop();
    }

    public int peek() {
        ensureOutputStack();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty()&&outputStack.isEmpty();
    }

    private void ensureOutputStack(){
        if (outputStack.isEmpty()){
            while (!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
    }
}
