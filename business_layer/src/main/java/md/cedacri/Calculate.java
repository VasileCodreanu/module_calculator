package md.cedacri;

import java.util.Stack;

class Calculate {
    private char[] arr;
    private int index = 0;
    boolean hasPassedOpenParenthesis = false;

    public double calculate(String expression) {
        arr = expression.toCharArray();
        return calcInner();
    }

    private double calcInner() {
        Stack<Double> stack = new Stack<>();
        char operator = '+';

        while (index < arr.length) {
            if (Character.isDigit(arr[index])) {

                int parsedNumber = parseNumber(arr, index);
                index += Integer.toString(parsedNumber).length() - 1;

                insertElement(stack, parsedNumber, operator);

                if (index < arr.length - 1 && Character.isDigit(arr[index]) && arr[index + 1] == '(')
                    operator = '*';//for  2(3)

            } else if (arr[index] == '(') {
                index++;
                double curNum = calcInner();

                insertElement(stack, curNum, operator);

                if (arr[index - 1] != '-' ||   //2+(3) 2(3)   //(1+1)(2+1)  //-(1+(2+2))
                        arr[index - 1] != '+' ||
                        arr[index - 1] != '*' ||
                        arr[index - 1] != '/'
                                && hasPassedOpenParenthesis) { //==> if(( arr[index-1] == ')') do * cu next paranth if exist
                    operator = '*';
                }
                hasPassedOpenParenthesis = true;

            } else if (arr[index] == ')') {
                    break;
            } else {
                operator = arr[index];
            }
            index++;
        }

        double total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    private int parseNumber(char[] arr, int index) {
        StringBuilder parsedNumber = new StringBuilder();
        while (index < arr.length && Character.isDigit(arr[index])) {
            parsedNumber.append(arr[index]);
            index++;
        }
        return Integer.parseInt(parsedNumber.toString());
    }

    private void insertElement(Stack<Double> stack, double number, char operator) {
        if (operator == '-') {
            number *= -1;
        } else if (operator == '*') {
            number *= stack.pop();
        } else if (operator == '/') {
            if (number == 0 ) throw new RuntimeException("Division by zero- not allowed!");
            number = stack.pop() / number;
        }
        stack.push(number);
    }
}
