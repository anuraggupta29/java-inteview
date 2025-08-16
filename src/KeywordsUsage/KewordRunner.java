package KeywordsUsage;

public class KewordRunner {
    public static void main(String[] args){
        CarTypeEnum car = CarTypeEnum.BMW;
        System.out.println(car + " " + CarTypeEnum.Mercedes.ordinal());

        PayUpEnumSingleton s1 = PayUpEnumSingleton.getInstance();
        PayUpEnumSingleton s2 = PayUpEnumSingleton.getInstance();

        s1.setAmount(100);
        s2.setAmount(500);

        System.out.println(s1.amount);  // s1 amount also gets updated to 500 as its singleton
    }
}
