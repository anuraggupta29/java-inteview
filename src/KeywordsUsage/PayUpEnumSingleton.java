package KeywordsUsage;

public enum PayUpEnumSingleton {
    INSTANCE;

    int amount = 0;

    static PayUpEnumSingleton getInstance(){
        return INSTANCE;
    }

    void setAmount(int amount){
        this.amount = amount;
    }
}
