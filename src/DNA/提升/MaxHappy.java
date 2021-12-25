package DNA.提升;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/10 19:09
 */
public class MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;
    }

    public static int maxHappy(Employee boss) {
        Info headInfo = process(boss);
        return Math.max(headInfo.noMaxHappy, headInfo.yesMaxHappy);
    }
    public static class Info {
        public int yesMaxHappy;
        public int noMaxHappy;
        public Info(int yesMaxHappy, int noMaxHappy) {
            this.yesMaxHappy = yesMaxHappy;
            this.noMaxHappy = noMaxHappy;
        }
    }
    private static Info process(Employee x) {
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int yes = x.happy;
        int no = 0;
        for (Employee employee : x.nexts) {
            Info nextInfo = process(employee);
            yes += nextInfo.noMaxHappy;
            no += Math.max(nextInfo.noMaxHappy, nextInfo.yesMaxHappy);
        }
        return new Info(yes, no);
    }
}
