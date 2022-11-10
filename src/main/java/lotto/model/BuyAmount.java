package lotto.model;

public class BuyAmount {

    private final int MONEY;

    public BuyAmount(int money) {
        notDivideValidate(money);
        this.MONEY = money;
    }

    private void notDivideValidate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


}
