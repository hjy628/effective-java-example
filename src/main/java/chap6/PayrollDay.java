package chap6;

//Enum that switches on its value to share code - quesionabe
public enum  PayrollDay {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    private static final int HOURS_PER_SHIFT = 8;

    double pay(double hoursWorked, double payRate){
        double basePay = hoursWorked * payRate;

        double overtimePay; //Calculate overtime pay
        switch (this){
            case SATURDAY: case SUNDAY:
                    overtimePay = hoursWorked * payRate /2;
             default: //Weekdays
                 overtimePay = hoursWorked <= HOURS_PER_SHIFT?0:(hoursWorked-HOURS_PER_SHIFT)*payRate/2;
                 break;
        }
        return basePay + overtimePay;
    }

}
