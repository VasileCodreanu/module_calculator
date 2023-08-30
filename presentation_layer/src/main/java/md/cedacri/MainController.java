package md.cedacri;

public class MainController {
    public static void main(String[] args) {

        String expression = new InputFromUser().getInput();

        double result  = new Calculator().getResult( expression );
        System.out.println(result);
    }
}