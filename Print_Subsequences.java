import java.util.*;
public class Print_Subsequences
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        printSS(str,"");
    }
    public static void printSS(String str, String ans)
    {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String rem =str.substring(1);
        printSS(rem,ans+ch);
        printSS(rem,ans);
    }
}