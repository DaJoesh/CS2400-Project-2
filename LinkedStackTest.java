public class LinkedStackTest
{
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
        LinkedStack<String> postfix = new LinkedStack<String>();
        System.out.println("Infix: " + printOut(infix));
        System.out.println("Postfix: ");
    }

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
            }
        }
        return f;
    }
}
