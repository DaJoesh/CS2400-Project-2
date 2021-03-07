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
        char evaluatedPostfix = evaluatePostfix(postfixString);
        System.out.println("Infix: " + printOutString(infix));
        System.out.println("Postfix: " + postfixString);
        System.out.println("Postfix Evaluated: " + evaluatedPostfix);
    }

    public static String printOutString(ResizeableArrayStack<String> x)
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

    public static char evaluatePostfix(String input)
    {
        int size = 20;
        String postfix = convertToPostfix(input);
        char nextCharacter;
        ResizeableArrayStack<Character> valueStack = new ResizeableArrayStack<Character>(size);
        char operandTwo,operandOne;
        int result, a=2, b =3, c=4, d=5, e=6;
        for(int i = 0; i<postfix.length();i++)
        {
            nextCharacter = postfix.charAt(i);
            switch (nextCharacter)
            {
                case '+':
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result = operandOne+operandTwo;
                valueStack.push((char)result);
                break;

                case'-':
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result = operandTwo-operandOne;
                valueStack.push((char)result);
                break;

                case'*':
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result = operandOne*operandTwo;
                valueStack.push((char)result);
                break;

                case'/':
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result = operandOne/operandTwo;
                valueStack.push((char)result);
                break;

                case'^':
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result = operandOne^operandTwo;
                valueStack.push((char)result);
                break;

                default: if(nextCharacter=='a')
                valueStack.push((char)a);
                else if(nextCharacter == 'b')
                valueStack.push((char)b);
                else if(nextCharacter == 'c')
                valueStack.push((char)c);
                else if(nextCharacter == 'd')
                valueStack.push((char)d);
                else if(nextCharacter == 'e')
                valueStack.push((char)e);
                break;
            }
        }
        return valueStack.peek();
    }
}
