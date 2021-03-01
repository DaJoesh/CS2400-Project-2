public class LinkedStackTest 
{
    public static void main(String[] args)
    {
        String infix = "𝑎∗ 𝑏 / (𝑐−𝑎)+𝑑∗𝑒";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + convertToPostfix(infix));
    }
}
