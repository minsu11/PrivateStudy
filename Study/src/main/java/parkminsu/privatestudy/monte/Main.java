package parkminsu.privatestudy.monte;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberOfSimulations = 1000;
        double totalPredictedPrice = 0;

        Random random = new Random();

        for (int i = 0; i < numberOfSimulations; i++) {
            // 무작위로 온도와 강우량 설정
            double temperature = random.nextDouble() * 5 + 30; // 30°C에서 35°C 사이의 난수
            double rainfall = random.nextDouble() * 20; // 0에서 20 밀리미터 사이의 난수

            // 무작위로 주말 여부 결정
            boolean isWeekend = random.nextBoolean();
            double discount = isWeekend ? 0.9 : 1.0; // 주말이면 10% 할인, 그렇지 않으면 할인 없음

            // 기본 가격
            double basePrice = 50;

            // 환경 요소에 따른 온도 및 강우량 요인 추가 또는 감소
            double temperatureFactor = (temperature - 30) * 2; // 1°C당 2달러 추가 또는 감소
            double rainfallFactor = (20 - rainfall) * 1; // 1 밀리미터당 1달러 추가 또는 감소

            // 최종 가격 계산
            double predictedPrice = basePrice + temperatureFactor + rainfallFactor;
            predictedPrice *= discount; // 주말 할인 적용

            // 예측된 가격 누적
            totalPredictedPrice += predictedPrice;
        }

        // 평균 예측 가격 계산
        double averagePredictedPrice = totalPredictedPrice / numberOfSimulations;

        System.out.println("주말 할인 포함 예측 평균 가격: $" + averagePredictedPrice);
    }
}
