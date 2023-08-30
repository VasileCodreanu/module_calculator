package md.cedacri;

public class Calculator {
    public double getResult( String expression ){
        String validatedExpression = ValidateInput.validateExpression(expression);

        return new Calculate().calculate(validatedExpression );
    }

}
