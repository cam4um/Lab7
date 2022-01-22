package lab7;

public class Company {

    private String name;

    private String email;
    private boolean company;
    private Account account;
    private double companyOverdraftDiscount = 1;

    // use only to create companies
    public Company(String name, String email, boolean company, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }


    public void withdrawCompany(double sum, String currency) {
        currencyCheck(currency);
        if (account.isPremium()) {
                    withdrawForCompanyPremium(sum);
        } else {
                    withdrawForCompany(sum);
            }
        }


    public void currencyCheck(String currency){
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
    }


    public void withdrawForCompanyPremium(double sum){
        // we are in overdraft
        if (account.getMoney() < 0) {
            // 50 percent discount for overdraft for premium account
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount / 2);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    public void withdrawForCompany(double sum){
        // we are in overdraft
        if (account.getMoney() < 0) {
            // no discount for overdraft for not premium account
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }


}
