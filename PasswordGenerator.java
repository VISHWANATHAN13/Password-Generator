import java.util.*;
/**
 * PasswordGenerator
 * @author vishwanathan
 */





 /*
  * OptionException is a user Defined Exception with user defined Statements
  */
class OptionException extends Exception{
    /**
     * @param s
     */
    OptionException(String s)
    {
        super(s);
    }
}
/*
 * @main class
 * do not change the class name
 */

public class PasswordGenerator {
    /**
     * @param n
     * @param isnumbers
     * @param issymbols
     * @return
     */
    public static String getPassword(int n,int isnumbers,int issymbols) {
        /*
         * variable declarations 
         * 
         */
        int i,rn;
        String password="";
        boolean iscontainsletter=true,iscontainsnumber=false,iscontainsspecialsymbol=false;
        if(isnumbers==1){
            iscontainsnumber=true;
        }
        if(issymbols==1)
        {
            iscontainsspecialsymbol=true;
        }
        String letters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers="1234567890";
        String specialsymbols="!@#$%^&*_?";
        Random r1 = new Random();
        
        /*
         * Password Generation part
         * don't change anything inside conditions
         */


         /*
          * n - specified size limit for the password
          *  user defined value
          */
        for(i=0;i<n;i++){
            do{
                rn=r1.nextInt(4);
                if(rn>0)
                {
                    break;
                }
            }while(rn<=0);
        switch(rn){
            case 1:
            /*
             * when user wants letters in their password.
             * basically this is true in default because letters are mandatory in a password
             * 
             */
            if(iscontainsletter){
                int p=r1.nextInt(52);
                char l=letters.charAt(p);
                String l1=String.valueOf(l);
                password+=l1;
            }
            break;
            case 2:
            /*
             * when user wants number in their password.
             * if yes,then bool=1
             * if No,then bool=0
             * 
             */
            if(iscontainsnumber){
                int q=r1.nextInt(10);
                char num=numbers.charAt(q);
                String l2=String.valueOf(num);
                password+=l2;
    
            }
            break;
            case 3:
            /*
             * if user wants special characters in their password.
             * if yes,then bool=1
             * if No,then bool=0
             */
            if(iscontainsspecialsymbol){
                int r=r1.nextInt(11);
                char sym=specialsymbols.charAt(r);
                String l3=String.valueOf(sym);
                password+=l3;
    
            }
            break;

        }

    }
      /*
       * returning the concluded password
       */
    return password; 

        
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        int n,isnumbers,issymbols;
        Scanner sc=new Scanner(System.in);
        try
        {
        System.out.print("Enter the length for your password(minimun size:8):");
        n=sc.nextInt();
        if(n<8) throw new OptionException("minimum length must be 8 characters!");
            
        System.out.print("do you want to include numbers?\n1.Yes\t2.No\n");
        isnumbers=sc.nextInt();
        if(!(isnumbers==1 || isnumbers==2)) throw new OptionException("please select either 1 or 2!");
        System.out.print("Do you want to include special symbols?\n1.Yes\t2.No\n");
        issymbols=sc.nextInt();
        if(!(issymbols==1 || issymbols==2)) throw new OptionException("please select either 1 or 2!");
    
        System.out.print("Your new password:"+ getPassword(n,isnumbers,issymbols));

      }
        catch(OptionException o)
        {
            System.out.println(o.getMessage());
            main(args);
        }
        sc.close();
    }
    

    
}