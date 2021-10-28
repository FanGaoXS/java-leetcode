package subject155;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/28/14:25
 * @Description:
 */
public class MinStack2 {
    //主栈
    private Stack<Integer> stack;
    //辅助栈
    private Stack<Integer> minStack;
    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        //辅助栈中永远存储主栈当前顶端状态的最小数
        if (val<minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
