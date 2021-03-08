public class ArrayStackTest 
{    
    public static void main(String[] args)
    {
        String postfix = "43*2-3*";
        int evaluatedPostfix = evaluatePostfix(postfix);
        System.out.println("Postfix Evaluated: " + evaluatedPostfix);
    }

    public static String printOut(ResizeableArrayStack<Integer> x)
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
    /**
     * Evaluates a SINGLE DIGIT postfix expression that only contains numbers and operators.
     * @param input a postfix expression in the form of a String to evaluate.
     * @return integer value of the postfix equation.
     */
    public static int evaluatePostfix(String input)
    {
        int size = 20;
        String postfix = input;
        char nextCharacter;
        ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>(size);
        int operandTwo,operandOne;
        int result;
        for(int i = 0; i<postfix.length();i++)
        {
            System.out.println("for loop working");
            nextCharacter = postfix.charAt(i);
            switch (nextCharacter)
            {
                case '+':
                operandOne = valueStack.pop();
                operandTwo = valueStack.pop();
                result = operandOne+operandTwo;
                valueStack.push(result);
                System.out.println("Case + working");
                break;

                case'-':
                operandOne = valueStack.pop();
                operandTwo = valueStack.pop();
                result = operandTwo-operandOne;
                valueStack.push(result);
                System.out.println("case - working");
                break;

                case'*':
                operandOne = valueStack.pop();
                operandTwo = valueStack.pop();
                result = operandOne*operandTwo;
                valueStack.push(result);
                System.out.println("case * working");
                break;

                case'/':
                operandOne = valueStack.pop();
                operandTwo = valueStack.pop();
                result = operandOne/operandTwo;
                valueStack.push(result);
                System.out.println("case / working");
                break;

                case'^':
                operandOne = valueStack.pop();
                operandTwo = valueStack.pop();
                result = operandOne^operandTwo;
                valueStack.push(result);
                System.out.println("case ^ working");
                break;

                default:
                if('0' <= nextCharacter && nextCharacter <= '9')
                {
                valueStack.push(nextCharacter - '0');
                }
                break;
            }
        }
        return valueStack.peek();
    }
}
