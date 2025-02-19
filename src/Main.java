import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isSuccess = false;
        while(!isSuccess) {
            try {
                int int1 = getInt();
                double double1 = getDouble();
                String string1 = getString();
                System.out.println(int1);
                System.out.println(double1);
                System.out.println(string1);
                isSuccess = true;
            } catch (ImpostorStringException e) {
                System.out.println("This so-called 'string' is an impostor!!! Start over >:(");
            } catch(InputMismatchException e) {
                System.out.println("Input is wrong type!!! Start over >:(");
                input.nextLine();

            } catch(Exception e) {
                input.nextLine();
                System.out.println("Something went wrong :o");
                System.out.println(e);
            }
        }
    }
    static int getInt() {
        System.out.println("Gimme an int");
        int val = input.nextInt();
        input.nextLine();
        return val;
    }
    static double getDouble() {
        System.out.println("Gimme a double");
        double val = input.nextDouble();
        input.nextLine();
        return val;
    }
    static String getString() throws ImpostorStringException{
        System.out.println("Gimme a string");
        String val = input.nextLine();
        String[] chars = val.split("");
        String[] invalidChars = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."};
        boolean valid = false;
        for(String x : chars) {
            boolean isCharValid = true;
            for(String y : invalidChars) {
                if (y.equals(x)) {
                    isCharValid = false;
                    break;
                }
            }
            if (isCharValid) {
                valid = true;
                break;
            }
        }
        if(!valid) {
            throw new ImpostorStringException("This is custom. My Goodness!");
        }
        return val;
    }
}

class ImpostorStringException extends Exception {
    public ImpostorStringException(String m) {
        super(m);
    }
}