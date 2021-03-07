public class ArrayStackTest 
{    
    public static void main(String[] args)
    {
        ResizeableArrayStack<String> infix = new ResizeableArrayStack<String>();
        infix.push("e");
        infix.push("*");
        infix.push("d");
        infix.push("+");
        infix.push(")");
        infix.push("a");
        infix.push("-");
        infix.push("c");
        infix.push("(");
        infix.push("/");
        infix.push("b");
        infix.push("*");
        infix.push("a");
        String infixString = "a*b/(c-a)+d*e";
        String postfixString = "";
        postfixString = convertToPostfix(infixString);
        System.out.println("Infix: " + printOut(infix));
        System.out.println("Postfix: " + postfixString);
    }

    public static String printOut(ResizeableArrayStack<String> x)
    {
        String f = "";
        int i = 0;
        while(!(x.isEmpty()))
        {
            i++;
            if(i==0)
            {
                f += x.peek();
            }
            else
            {
                f += x.pop();
            }
        }
        return f;
    }

    private static boolean checkOperator(char op)
    {
        return op== '+' || op== '-' || op== '*' || op== '/' || op=='^' || op== '(' || op== ')';
    }
    
    //checks and decides the order of operations
    private static int compOperator(char op1)
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
    private static boolean isOperand(char l) 
    {
        return (l >= 'a' && l <= 'z') || (l >= 'A' && l <= 'Z');
    }

    public static String convertToPostfix(String infix)
    {
        ResizeableArrayStack<Character> stack = new ResizeableArrayStack<Character>();
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

    public static String evaluatePostfix(String input)
    {
        String postfix = convertToPostfix(input);
        
        
        
        return null;
    }
}
