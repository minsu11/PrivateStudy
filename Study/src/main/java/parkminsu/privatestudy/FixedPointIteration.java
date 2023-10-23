package parkminsu.privatestudy;

import java.util.Iterator;

public class FixedPointIteration {
    public static void main(String[] args) {
        double initialGuess = 2.0; // 초기 추측값
        double tolerance = 1e-6; // 수렴 조건 (허용 오차)

        // 고정점 반복법을 사용하여 고정점을 찾는 Iterator 생성
        FixedPointIterator iterator = new FixedPointIterator(initialGuess, tolerance);

        int maxIterations = 1000; // 최대 반복 횟수

        // 고정점 반복법 실행
        double fixedPoint = iterator.findFixedPoint(maxIterations);

        if (!Double.isNaN(fixedPoint)) {
            System.out.println("고정점: " + fixedPoint);
        } else {
            System.out.println("수렴하지 않음.");
        }
    }

    // 주어진 함수 f(x)
    public static double f(double x) {
        return x * x - 4;
    }

    // 주어진 함수 f(x)의 도함수 f'(x)
    public static double fPrime(double x) {
        return 2 * x;
    }
}

class FixedPointIterator implements Iterator<Double> {
    private double x; // 현재 추측값
    private double tolerance; // 수렴 조건 (허용 오차)

    public FixedPointIterator(double initialGuess, double tolerance) {
        this.x = initialGuess;
        this.tolerance = tolerance;
    }

    // 다음 추측값을 계산하는 메서드
    private double getNextGuess() {
        return x - FixedPointIteration.f(x) / FixedPointIteration.fPrime(x);
    }

    @Override
    public boolean hasNext() {
        double nextGuess = getNextGuess();
        return Math.abs(nextGuess - x) >= tolerance;
    }

    @Override
    public Double next() {
        x = getNextGuess();
        return x;
    }

    // 고정점 반복법을 실행하여 고정점을 찾는 메서드
    public double findFixedPoint(int maxIterations) {
        int iteration = 0;
        while (hasNext() && iteration < maxIterations) {
            next();
            iteration++;
        }
        if (iteration >= maxIterations) {
            return Double.NaN; // 수렴하지 않는 경우
        }
        return x;
    }
}
