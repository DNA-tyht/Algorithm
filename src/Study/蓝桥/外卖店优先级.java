package Study.蓝桥;

import java.util.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 18:32
 */
public class 外卖店优先级 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> message = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++)
            message.put(i, new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int ts = scanner.nextInt();
            int id = scanner.nextInt();
            if (ts <= T) {
                ArrayList<Integer> list = message.get(id);
                list.add(ts);
                message.put(id, list);
            }
        }

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = message.get(i);
            Collections.sort(list);
            int cur = 0;
            for (int j = 0; j < list.size(); j++) {
                System.out.println("第" + list.get(j) + "时" + i + "店");
                if (j == 0)
                    cur += 2 - (list.get(j) - 1);
                else if (j == list.size() - 1)
                    cur -= T - list.get(j - 1) + 2 - (list.get(j) - list.get(j - 1) - 1);
                else
                    cur += 2 - (list.get(j) - list.get(j - 1) - 1);

                if (cur > 5 && !set.contains(i)) {
                    set.add(i);
                    System.out.println(i + "加入");
                }
                if (cur <= 3 && set.contains(i)) {
                    set.remove(i);
                    System.out.println(i + "退出");
                }
            }
        }
        System.out.println(set.size());
    }
}
