public class LinkedStackTest
{
    /*entering all characters used in infix equation */
    public static void main(String[] args)
    {
        LinkedStack<String> infix = new LinkedStack<String>();
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
    }//end main

    /**prints out the string 
    @param LinkedStack 
    */
    public static String printOut(LinkedStack<String> x)
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
            }//end if
        }//end while
        return f;
    }//end printOut

    /**checks operators and redices which one goes first
    @return the opperator
    @param op the operator in the infix equation
    */
    private static boolean checkOperator(char op)
    {
        return op== '+' || op== '-' || op== '*' || op== '/' || op=='^' || op== '(' || op== ')';
    }
    
    /** checks operators and redices which one goes first
    @return a value according to which opperator is found in the infix equation 
    @param op1 the operator in the infix equation 
    */
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
    
    /**checks to see if the letters in the infix equation is valid
    @return letters in infifrix quation
    @param char1 
    */
    private static boolean isOperand(char l) 
    {
        return (l >= 'a' && l <= 'z') || (l >= 'A' && l <= 'Z');
    }

    /**converts infix equation to postfix
    @return postfix equation
    @param infix 
    */
    public static String convertToPostfix(String infix) {
        LinkedStack<Character> stack = new LinkedStack<Character>();
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
            }//end if
        }//end for

        while (!stack.isEmpty()) 
        {
            postfix.append(stack.pop());
        }//end while
        return postfix.toString();
    }//end convertToPostfix
    
}//end LinkedStackTest