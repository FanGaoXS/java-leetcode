package cn.fangaoxs.day16.subject232;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/03/16:00
 * @Description:        leetcode232-利用两个栈实现队列
 */
class MyQueue {

    
    private final Stack<Integer> stackInput;  //输入栈
    private final Stack<Integer> stackOutput;  //输出栈

    /** 初始化队列 */
    public MyQueue() {
        stackInput = new Stack<>();
        stackOutput = new Stack<>();
    }

    /** 向队列后端添加元素 */
    public void push(int x) {
        stackInput.push(x);
    }

    /** 从队列前端移除元素，并且返回移除的元素 */
    public int pop() {
        //如果输出栈为空，但输入栈不为空，则输入栈pop出所有元素，并且push进输出栈
        if (stackOutput.empty()&&!stackInput.empty()){
            while (!stackInput.empty()){
                stackOutput.push(stackInput.pop());
            }
        }
        return stackOutput.pop();
    }

    /** 获得位于前端的元素 */
    public int peek() {
        //如果输出栈为空，但输入栈不为空，则输入栈pop出所有元素，并且push进输出栈
        if (stackOutput.empty()&&!stackInput.empty()){
            while (!stackInput.empty()){
                stackOutput.push(stackInput.pop());
            }
        }
        return stackOutput.peek();
    }

    /** 返回队列是否为空 */
    public boolean empty() {
        //如果两个栈都为空说明队列中已没有元素
        return stackInput.empty()&& stackOutput.empty();
    }
}
