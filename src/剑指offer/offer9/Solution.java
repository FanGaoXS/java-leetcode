package 剑指offer.offer9;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/09/17:29
 * @Description:    两个栈实现队列
 */
public class Solution {

}

class CQueue {

    //输入栈
    private Stack<Integer> inputStack;

    //输出栈
    private Stack<Integer> outputStack;

    public CQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    //入队
    public void appendTail(int value) {
        inputStack.push(value);
    }

    //出队（若队列中没有元素返回-1）
    public int deleteHead() {
        if (outputStack.empty()) {
            if (inputStack.empty()){
                //输出和输入栈都为空
                return -1;
            } else {
                //否则将输入栈的所有元素迭代到输出站
                while (!inputStack.empty()){
                    outputStack.push(inputStack.pop());
                }
            }
        }
        return outputStack.pop();
    }
}
