package chap6;

public enum  BasicOperation implements Operation{
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x+y;
        }},
        MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x-y;
        }},
        TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x*y;
        }},
    REMAINDER("%"){
        @Override
        public double apply(double x, double y) {
            return x % y;
        }},
    EXP("^"){
        @Override
        public double apply(double x, double y) {
            return Math.pow(x,y);
        }},
        DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x/y;
        }};


    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public double apply(double x, double y) {
        return 0;
    }


    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(BasicOperation.class,x,y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet,double x,double y){
        for (Operation op :
                opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x, y));
        }
    }
}
