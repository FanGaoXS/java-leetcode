package cn.fangaoxs.day16.subject155;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/03/17:13
 * @Description:
 */
class MinStack {
    private final Stack<Integer> intStack;  //数据栈（存放int类型数据）

    private final Stack<Integer> minStack;  //辅助栈（存放当前栈的最小值）

    /** initialize your data structure here. */
    public MinStack() {
        intStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        intStack.push(val);
        //利用当前辅助栈顶的元素与当前准备存入的数据取最小然后push进去
        minStack.push(Integer.min(val,minStack.peek()));
    }

    public void pop() {
        //存放的数据和当前栈的最小值都弹出
        intStack.pop();
        minStack.pop();
    }

    public int top() {
        return intStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
