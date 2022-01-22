package lab7;

public class Company {

    private String name;

    private String email;
    private boolean company;
    private Account account;
    private double companyOverdraftDiscount = 1;


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

        if (account.getMoney() < 0) {

            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount / 2);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    public void withdrawForCompany(double sum){

        if (account.getMoney() < 0) {

            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }


}
