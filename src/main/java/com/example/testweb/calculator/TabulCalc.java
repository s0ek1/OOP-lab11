package com.example.testweb.calculator;

import com.example.testweb.data.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabulCalc {
    private double start;
    private double finish;
    private double step;

    public static final double a = 20.3;
    private double f(double x) {
        if (x > 1.2 + 1e-9) return Math.log10(x + 1);
        else {
            double sin = Math.sin(Math.sqrt(a * x));
            return sin * sin;
        }
    }
    public List<Point> tabulating(double start, double finish, double step) {
        List<Point> points = new ArrayList<>();
        int n = (int) Math.round((finish - start) / step + 1);
        for (int i = 0; i < n; i++) {
            double x = start + i * step;
            double y = f(x);
            points.add(new Point(x,y));
        }
        return points;
    }
    public double countStep() {
        if (start==finish) return 0;
        return Math.round((finish - start) / step + 1);
    }

    public Point getMax(List<Point> points) {
        Point maxPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).y() > maxPoint.y()) {
                maxPoint = points.get(i);
            }
        }
        return maxPoint;
    }
    public Point getMin(List<Point> points) {
        Point minPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).y() < minPoint.y()) {
                minPoint = points.get(i);
            }
        }
        return minPoint;
    }
    public double getSum(List<Point> points) {
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum += points.get(i).y();
        }
        return sum;
    }
    public double getAverage(List<Point> points) {
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum += points.get(i).y();
        }
        return sum / points.size();
    }
}
