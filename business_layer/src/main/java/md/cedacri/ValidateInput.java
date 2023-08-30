package md.cedacri;


import java.util.Stack;

class ValidateInput {

    public static String validateExpression(String input) {
        String expression = removeWhitespaces(input).replaceAll("\\(\\)", "");

        if (expression.isEmpty())// || expression.isBlank()
            throw new EmptyInputException("Please enter non-empty expression!");

        if (!isOnlyAllowedCharacters(expression))
            throw new NotAllowedCharactersException("\tAn allowed expression can contain: '[0-9], +,-,*,/,(,)'\n\tThis expression is not valid: '" + expression);

        if (!isParenthesesBalanced(expression))
            throw new ParenthesesNotBalancedException("Unbalanced parentheses expression! Please input valid expression!");

        return removeWhitespaces(expression);
    }

    private static boolean isParenthesesBalanced(String sequence) {
        Stack<Character> parantheseStack = new Stack<>();
        for (int i = 0; i < sequence.length(); i++) {
            char character = sequence.charAt(i);
            if (character == '(') {
                parantheseStack.push(character);
            } else if (character == ')' && !parantheseStack.isEmpty() && parantheseStack.peek() == '(') {
                parantheseStack.pop();
            } else if (character == ')') {
                parantheseStack.push(character);
            }
        }
        //pot sa returnez ce este in staack in caz ca staku nu este gol , apoi sa arat ce nu e corect in exprsie
        return parantheseStack.isEmpty();
    }

    private static boolean isOnlyAllowedCharacters(String expression) {
        String regex = "^[\\d\\(\\-]+[\\d\\+\\/\\*\\- \\(\\)]*$";
        return expression.matches(regex);
    }

    private static String removeWhitespaces(String expression) {
        return expression.replaceAll("\\s", "");
    }
}
