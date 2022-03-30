package 中等;

/**
 * @Description 2043
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/18 9:55
 */
public class 简易银行系统 {

    class Bank {

        int count;
        long[] balance;

        public Bank(long[] balance) {
            count = balance.length;
            this.balance = new long[count];
            for (int i = 0; i < count; i++) {
                this.balance[i] = balance[i];
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 < 1 || account1 > count || account2 < 1 || account2 > count || balance[account1 - 1] < money)
                return false;
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if(account < 1 || account > count)
                return false;
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account < 1 || account > count || balance[account - 1] < money)
                return false;
            balance[account - 1] -= money;
            return true;
        }
    }
}
