package simulateQueueWithStack;

import java.util.Stack;

/**
 * <p>
 * Description: 用两个栈模拟队列的 push 和 pop 操作
 * <p>
 * Created on 2021/5/21.
 *
 * @author pangwen
 * @version 0.1
 */
public class SimulateQueueSolution {

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
