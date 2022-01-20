package lab7;

public class Customer {

    public enum CustomerType {
        COMPANY,
        PERSON
    }

    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
    }


    public void withdraw(double sum, String currency) {
        currencyCheck(currency);
        withdrawForPerson(sum);
        }


    public void currencyCheck(String currency){
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
    }



public void withdrawForPerson(double sum){
    // we are in overdraft
    if (account.getMoney() < 0) {
        account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee());
    } else {
      account.setMoney(account.getMoney() - sum);
    }

}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




public String fullName(){
    String fullName = name + " " + surname + " ";
    return fullName;
}

    public String printCustomerDaysOverdrawn() {
        String accountDescription = "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return fullName() + accountDescription;
    }

    public String printCustomerMoney() {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
        return fullName() + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", Account type: " + account.toString();
    }


    public String printCustomer() {
        return getName() + " " + getEmail();
    }
}
