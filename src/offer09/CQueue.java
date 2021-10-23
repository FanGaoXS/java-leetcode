package cn.fangaoxs.day20.offer09;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/07/12:49
 * @Description:
 */
class CQueue {

    Stack<Integer> stackInput;      //输入栈
    Stack<Integer> stackOutput;     //输出栈

    public CQueue() {
        stackInput = new Stack<>();
        stackOutput = new Stack<>();
    }

    //向队列尾添加元素
    public void appendTail(int value) {
        stackInput.push(value);
    }

    //从队列头部删除元素
    public int deleteHead() {
        if (stackOutput.empty()&&!stackInput.empty()){      //如果输出栈空，但输入栈不为空时
            //输入栈的元素全部赋给输出栈
            while (!stackInput.empty()){
                stackOutput.push(stackInput.pop());
            }
        } else if (stackOutput.empty()&&stackInput.empty()){//如果两个栈都空了
            return -1;
        }
        return stackOutput.pop();
    }
}
