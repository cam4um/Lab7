package lab7;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @org.testng.annotations.Test
    public void testBankchargePremiumLessThanAWeek() {
        Account account = getPremiumAccount(5);
        assertThat(account.bankcharge(), is(14.5));
    }

    @Test
    public void testBankchargePremiumMoreThanAWeek() {
        Account account = getPremiumAccount(9);
        assertThat(account.bankcharge(), is(16.5));
    }

    @Test
    public void testOverdraftFeePremium() {
        Account account = getPremiumAccount(9);
        assertThat(account.overdraftFee(), is(0.10));
    }

    @Test
    public void testOverdraftFeeNotPremium() {
        Account account = getNormalAccount();
        assertThat(account.overdraftFee(), is(0.20));
    }

    @Test
    public void testPrintCustomer() {
        Account account = getNormalAccount();
        Customer customer = new Customer("xxx", "xxx", "xxx@mail.com", true, account);
        account.setCustomer(customer);
        assertThat(customer.printCustomer(), is("xxx xxx@mail.com"));
    }

    private Account getNormalAccount() {
        return new Account(false, 9);
    }

    private Account getPremiumAccount(int daysOverdrawn) {
        return new Account(true, daysOverdrawn);
    }



}
