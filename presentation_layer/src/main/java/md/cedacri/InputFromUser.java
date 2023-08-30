package md.cedacri;

class InputFromUser {

    private final String input;

    public InputFromUser(){
        this.input=expression;
    }

    public String getInput(){
        return input;
    }

    String expression = "12*2-4/2-1/2";

    String example =
            "(1+2*3+1" +//8-ok
                    "(1+2*3+1)" +//8-ok
                    "(1+2*3)/2" +//8-ok
                    "-(1+(2+2))\n" +//-5-ok
                    "-(-1)\n" +    //1-ok
                    "12*2-4/2-1/2" +//21.5-ok
                    "2(3)\n" +//6---no
                    "(1+1)*(2+1)" +//ok
                    "((1+2)2)(2+1)" +//18 -- ok
                    "(11 + 18) * 20 - 2" +
                    "*12/6"+//not valid expr
                    "(1+1)(2+1)";//6 --ok;
}

