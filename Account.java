package lab7;


public class Account {


    private String iban;

    public Account type;

    private int daysOverdrawn;

    private double money;

    private String currency;

    private Customer customer;

    private boolean premium;

    public Account(boolean premium, int daysOverdrawn) {
        super();

        this.premium = premium;
        this.daysOverdrawn = daysOverdrawn;

    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (isPremium()) {
            return 0.10;
        } else {
            return 0.20;
        }
    }


    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }





    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public boolean getType() {

        return premium;}

    public boolean isPremium() {

        return premium;
    }

    @Override
    public String toString() {
        return premium ? "premium" : "normal";
    }
}
