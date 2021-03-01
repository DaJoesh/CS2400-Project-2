import java.util.*;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode;

    public LinkedStack()
    {
        topNode = null;
    }
    
    private class Node
    {
        private T data;
        private Node next;
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        /** creates a node 
            @param T dataPortion the information inside of the node
            @param nextNode the node following the previous node */
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }//end Node

        /** retieved data in T node */
        private T getData()
        {
            return data;
        }// end getData

        /** sets the data in the new node
            @param newData gets data from note and sets it in data */
        /*
        private void setData(T newData)
        {
            data = newData;
        }//end setData
        */

        /** finds the next node In the bag */
        private Node getNextNode()
        {
            return next;
        }//end getNextNode
    }//end class Node

    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    public T pop()
    {
         T top  = peek();
         topNode = topNode.getNextNode();
         return top;
    }

    public T peek()
    {
        if(isEmpty())
        throw new EmptyStackException();
        else
        return topNode.getData();
    }
    
    public boolean isEmpty()
    {
        return topNode == null;
    }

    public void clear()
    {
        topNode = null;
    }

    /*//checks to see that operations are in the stack
    public boolean checkOperator(char op)
    {
        return op== '+' || op== '-' || op== '*' || op== '/' || op=='^' || op== '(' || op== ')';
    }
    
    //checks and decides the order of operations
    public int compOperator(char op1)
    {
        switch (op1)
        {
            case '+':
                return 1;
            
            case '-':
                return 1;
                
            case '*':
                return 2;
                
            case '/':
                return 2;
                
            case '^':
                return 3;
        }
        return -1;
    }
    
    //checks to see if values are valid
    public boolean isOperand(char l) 
    {
        return (l >= 'a' && l <= 'z') || (l >= 'A' && l <= 'Z');
    }
    
    //turns infix entry into postfix
    public String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(infix.length());
        char c;

        for (int i = 0; i < infix.length(); i++) {
            c = infix.charAt(i);
            if (isOperand(c)) 
                postfix.append(c);
            else if (c == '(') 
                stack.push(c);
            
            else if (c == ')') 
            {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (checkOperator(c))
            {
                if (!stack.isEmpty() && compOperator(c) <= compOperator(stack.peek())) 
                    postfix.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) 
        {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    */
    
}
