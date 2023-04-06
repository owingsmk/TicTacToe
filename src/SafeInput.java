import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt)
{
    String retString = "";  // Set this to zero length. Loop runs until it isn’t
    do
    {
        System.out.print("\n" +prompt + ": "); // show prompt add space
        retString = pipe.nextLine();
    }while(retString.length() == 0);

    return retString;
}
    public static int getInt(Scanner pipe, String prompt){ //this is setting the int steps for any main that uses getInt

    int retVal = 0;
    String trash = ""; //trash incorrect variables
    boolean done = false;

    do{
        System.out.println(prompt);
        if(pipe.hasNextInt()){
            retVal = pipe.nextInt();
            pipe.nextLine();
            done = true;
        }
        else{
            trash = pipe.nextLine();
            System.out.println("Not correct type: "+ trash); //when varible is incorrect like "acvef" instead of 1,2,3
        }
    }while(!done); //not done it will loop back

    return retVal;
    }
    public static double getDouble(Scanner pipe, String prompt){ //this is setting the double variable

        double retVal = 0;
        String trash = "";
        boolean done = false;

        do{
            System.out.println(prompt);
            if(pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("Not correct type: "+ trash);
            }
        }while(!done);

        return retVal;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){ //this is setting the range variable

        int retVal = 0;
        String trash = "";
        boolean done = false;

        do{
            System.out.println(prompt);
            if(pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextInt();
                if (retVal >= low && retVal <= high)
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("Not correct type: "+ trash);
            }
        }while(!done);

        return retVal;
    }
    public static int getRangedDouble(Scanner pipe, String prompt, double low, double high){ //this is setting the range variable

        double retVal = 0;
        String trash = "";
        boolean done = false;

        do{
            System.out.println(prompt);
            if(pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("Not correct type: "+ trash); //shows what was typed as tells them it is incorrect
            }
        }while(!done);

        return (int) retVal;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt){ //this is for Yes or No variable

        String retVal = "y/n";
        String trash = "";
        boolean done = false;

        do{
            System.out.println(prompt);
            if(pipe.hasNextBoolean()){
                retVal = String.valueOf(pipe.nextBoolean());
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("Not correct type: "+ trash);
            }
        }while(!done);

        return retVal.isEmpty();
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern){

        String retVal = "";
        boolean gotAValue = false;

        do{
            System.out.print(prompt + ": "); //show the prompt
                retVal= pipe.nextLine(); //input the data
            if(retVal.matches(regExPattern)){ //this test and references String regExPattern
                gotAValue = true;
            }
            else {
                System.out.println("\nInvalid input: " + retVal); //Output incorrect variable
            }

        }while(!gotAValue);

        return retVal;
    }

}
