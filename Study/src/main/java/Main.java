import java.util.List;
import java.util.Random;

public class Main {
    int categoryID;
    List<String> nameList;
    String modelNumber;
    int number;
    Random random;

    String categoryName;
    int categoryNumber;

    public Main(int categoryID, List<String> nameList, String modelNumber, String categoryName) {
        this.categoryID = categoryID;
        this.nameList = nameList;
        this.modelNumber = modelNumber;
        this.random = new Random();
        this.number = 1;
        this.categoryName = categoryName;
        this.categoryNumber = 1;
    }

    public void a() {

        for (String name : this.nameList) {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(categoryID).append(",").append(makeModelNumber()).append(", ").append("\"").append(name).append("\"").append(", ").append(makeProductImage()).append(", ").append(makeCost()).append(", ").append(makeDescription(name)).append("),");
            System.out.println(sb.toString());
        }
    }

    public String makeModelNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(this.modelNumber).append(String.format("%03d", number)).append("\"");
        number++;
        return sb.toString();
    }

    public String makeProductImage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(categoryName).append(String.format("%03d", number - 1)).append(".png").append("\"");
        categoryNumber++;
        return sb.toString();
    }

    public int makeCost() {
        return (int) (Math.random() * 500) * 100;
    }

    public String makeDescription(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append("이 상품의 이름은 " + name + "이며 이 상품은 " + categoryName + "에 속합니다.").append("\"");
        return sb.toString();
    }


    public static void main(String[] args) {
        List<String> ramyeonList = List.of(
                "감자면", "강황 쌀국수 볶음면", "김치 사발면", "너구리", "냉라면", "도토리 쫄졸면", "드레싱누들 오리엔탈 소스 맛",
                "둥지냉면", "멸치칼국수", "마늘면복이", "마라고수 마라탕면", "맛짬뽕", "모둠 해물탕면", "무파마 탕면", "미니컵면",
                "보글보글 부대찌개면", "사리곰탕면", "사리면", "새우탕", "새우탕면", "생생우동", "신라면", "신라면 건면", "신라면 블랙",
                "쌀국수", "안성탕면", "야채라면", "양념치킨 큰사발면", "얼큰 장칼국수", "오징어짬뽕", "우육탕 큰사발", "우육탕면",
                "육개장", "집밥감성 고추장찌개면", "짜왕시리즈", "짜파게티", "간짬뽕", "김치찌개면", "까르보 불닭볶음면",
                "나가사끼 짬뽕", "된장라면", "라이트 불닭볶음면", "마라볶음면", "마라탕면", "맛있는 라면", "미트스파게티 불닭볶음면",
                "바지락 칼국수", "바지락 술찜면", "불닭볶음면", "불닭볶음탕면", "불타는 고추짜장", "불타는 고추짬뽕", "사리면",
                "삼양라면 오리지널", "손칼국수", "수타면", "쇠고기면", "열무비빔면", "김치라면", "메밀비빔면",
                "부대찌개라면", "북엇국라면", "쇠고기 미역국 라면", "열라면", "오라면", "오동통면", "오뚜기 카레면", "유부우동 컵", "육개장",
                "스낵면", "스파게티 봉지면", "진라면", "진짜장", "진짜쫄면", "진짬뽕", "꼬꼬면", "남자라면", "더왕뚜껑", "도시락", "맵시면",
                "봉희 설렁탕컵", "뽀로로", "볶음김치면", "사리면", "왕뚜껑", "일품 짜장면", "일품 해물라면", "쫄비빔면", "틈새라면", "팔도비빔면",
                "팔도왕짬뽕 봉지면", "팔도짜장면", "그렇다면 라면", "더매운맛라면", "도시어부 해물라면", "매운까르로볶이", "매콤야끼소바라면 대컵",
                "배터질라면 왕컵", "불타는 짜장", "버터볶음면");
        Main main = new Main(2, ramyeonList, "F", "라면");
        main.a();

        List<String> officeList = List.of("네임스티커 라벨프린터", "프리즈마 유성 색연필", "이고웰 무선 라벨프린터", "옴모 베이비 크레용", "천사점도 벌크",
                "펠로우즈 꽃가루형 문서 세단기", "파티 수술 은박 커튼", "드레텍 디지털 전자저울", "무림도화지 100개", "산리오캐릭터즈 다이어리 꾸미기", "우드웰 스토리 서랍형 받침대",
                "캐논 무한 잉크젯 복합기", "탐사 복사용지 5000매", "터치온리 저축다이어리", "네오체어 사무용 메쉬의자", "코멧 멀티책상", "에포크 위닛 게이밍 1200 책상", "라이브잇 클레이나라 아쿠아리움 만들기",
                "알파 제본용 스테플러", "천사점토 지점토", "시디즈 T20 탭플러스 화이트쉘 메쉬의자", "플라스틱 돌기단소 2개", "한글 회전 세계지구본", "코멧 컴퓨터 책상", "삼성전자 흑백 레이저 프린터",
                "카스 디지털 정밀 저울", "다용도 원형 의자", "문스타 타이탄 게이밍의자", "펜텔 그래프", "의류 택배봉투 속비닐", "핑크풋 3500 만능 단어장 4종 세트", "마그피아 대형고무자석 화이트보드",
                "써드라이프 논슬립 데스크 패드 베이직", "엡손 라벨테이프 SS18KW 호환 라벨지", "포포팬시 무지 크라프트", "파버카스텔 점보 연필 세트", "알파색체 모델링페이스트", "현대오피스 페이퍼프랜드 트리머 재단기",
                "청양토이 규격롤 칼라펠트", "종이백화점 크라프트지 120g", "리빙홈디테일 캐리어 노트북 여행 방수 스티커", "일상나눔 잘라쓰는 벨크로 찍찍이 케이블 타이", "탐사 전문가용 스케치북 200g", "열정문방구 문구용 커터칼",
                "로마네 라지 타포린백", "산리오 인기있는 문구세트 쿠로미", "탐사 소프트 화이트 점토", "플러스 손가락 골무 하니컴", "문구마을 NCR 거래명세표", "탐사 종이케이스 혼합 색종이", "쥬라기 공룡 파티 생일 풍선 세트",
                "쓰리엠 포스트잇 노트", "제일포장 크라프트 종이 롤 포장지", "핑크 풋 12000 캠퍼스 슬림케이스", "3M 스카치 논스틱 가위", "환영파티장식 풍선세트", "PP 정부화일", "금홍팬시 홀로그램 하트스티커", "유로엔젤 제도용 캠퍼스 룰러 9종",
                "피스코리아 평화 스테플러 침", "글라스데코", "지구화학 투명이 색연필", "금박 결혼식 이중 경조사봉투", "모트모트 텐미닛 플래너", "블루마토 30cm 자", "포스트잇 플래스 분류용", "톰보우 모노 연필 4B", "EXCELL 테이프 커터기",
                "빌럽어스 결혼고사 시험지 테스트", "올페이퍼 드레싱지", "포포팬시 캠퍼스 노트", "뮤니드 It spring 좌철 4분할 컬러노트", "플러스 수정 테이프", "제일 투명무지 비닐포장지", "문교 오일 파스텔 지함", "펜탈 그래프기어", "핑크풋 봉주르 탁상 달력",
                "탐사 심플 종합장", "몰랑이 두툼 종합장", "글로스바니쉬", "영오산업 창문형 결재판", "와이드 가죽 데스크 매트", "유니 시그노 스타일핏트 젤잉크 리필심", "파티해 생일 파티접시", "슈퍼쌤에듀 모양 4종 점착메모지 스티커노트", "피스코리아 철불독크립",
                "제나몰 산리오 스퀴시 팬케이스 필통", "인디케이 봉주르 곰들이 지퍼백", "공무원 수험생 타이머 뽀모도로 알람시계", "젠젠선물가게 도무송 랜덤박스", "마그피아 칼라원형 자석홀더");
        Main main2 = new Main(4, officeList, "O", "문구/오피스");
        main2.a();
    }


}
