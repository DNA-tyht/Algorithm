package Study.蓝桥;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/23 22:04
 */
public class 直线 {

    static class Line {
        double k;
        double f;

        public Line(double k, double f) {
            this.k = k;
            this.f = f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.k, k) == 0 && Double.compare(line.f, f) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, f);
        }
    }

    public static void main(String[] args) {
        Set<Line> set = new HashSet<>();
        int count = 0;
        for (double i = 0; i < 20; i++)
            for (double j = 0; j < 21; j++)
                for (double a = 0; a < 20; a++)
                    for (double b = 0; b < 21; b++) {
                        if (b == j && a == i)
                            break;
                        if (a != i && b != j) {
                            double k = (b - j) / (a - i);
                            double f = b - k*a;
                            set.add(new Line(k, f));
                        }
                        if (a == i && b != j) {
                            double k = Double.MAX_VALUE;
                            double f = a;
                            set.add(new Line(k, f));
                        }
                        if (b == j && a != i) {
                            double k = 0;
                            double f = b;
                            set.add(new Line(k, f));
                        }

                    }
        System.out.println(set.size());
    }


}
