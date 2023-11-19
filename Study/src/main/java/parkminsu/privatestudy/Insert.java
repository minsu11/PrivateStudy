package parkminsu.privatestudy;

import java.util.*;

public class Insert {

    List<String> comments;
    List<String> productIDList;
    int categoryID;
    List<String> nameList;
    String modelNumber;
    int number;
    Random random;

    String categoryName;
    int categoryNumber;

    Map<String, Integer> commmentMap;

    public Insert(int categoryID, List<String> nameList, String modelNumber, String categoryName) {
        this.categoryID = categoryID;
        this.nameList = nameList;
        this.modelNumber = modelNumber;
        this.random = new Random();
        this.number = 1;
        this.categoryName = categoryName;
        this.categoryNumber = 1;
        this.commmentMap = new HashMap<>();
        reviews();
        this.productIDList = new ArrayList<>();
    }

    public void a() {

        for (String name : this.nameList) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO Products VALUES(").append(categoryID).append(",").append(makeModelNumber())
                    .append(", ").append("\"").append(name).append("\"").append(", ").append(makeProductImage())
                    .append(", ").append(makeCost()).append(", ").append(makeDescription(name)).append(")").append(";");
            System.out.println(sb.toString());
        }
    }

    public void hi() {
        for (int i = 1; i <= 500; i++) {
            for (int j = 0; j < 10; j++) {
                StringBuilder sb = new StringBuilder();
                int customer = (int) (Math.random() * 50) + 1;
                int commentNumber = (int) (Math.random() * comments.size());

                String str = this.comments.get(commentNumber);
                sb.append("(").append(i).append(",").append(customer).append(",")
                        .append(this.commmentMap.get(str))
                        .append(",\"").append(str).append("\"").append(")").append(",");
                System.out.println(sb.toString());
            }

        }
    }

    private void reviews() {


        this.comments = new ArrayList<>();
        comments.add("이거 굿입니당");
        comments.add("이거 굿이긴 한데 아쉽네요");
        comments.add("이거 비추 할게요");
        comments.add("이거 강력 추천할게요 ");
        comments.add("이거 흠 쏘쏘 합니다");
        comments.add("이거 가성비가 좋은듯");
        comments.add("이거 가성비가 좋은가 같네여");
        comments.add("이거 가성비 개 구려요");
        comments.add("이거 좋은지 모르겠네요");
        comments.add("이거 뭐가 좋은거죠?");
        comments.add("이거 한 마디만 할게요 사지마세요");
        comments.add("이거 무조건 사야해여");
        comments.add("이건 아닌것 같아요");
        comments.add("이정도면 괜찮은거 같네여");
        comments.add("가성비 괜칞아여");

        commmentMap.put("이거 굿입니당", 5);
        commmentMap.put("이거 굿이긴 한데 아쉽네요", 4);
        commmentMap.put("이거 비추 할게요", 1);
        commmentMap.put("이거 강력 추천할게요 ", 5);
        commmentMap.put("이거 흠 쏘쏘 합니다", 3);
        commmentMap.put("이거 가성비가 좋은듯", 4);
        commmentMap.put("이거 가성비가 좋은가 같네여", 4);
        commmentMap.put("이거 가성비 개 구려요", 1);
        commmentMap.put("이거 좋은지 모르겠네요", 2);
        commmentMap.put("이거 뭐가 좋은거죠?", 1);
        commmentMap.put("이거 한 마디만 할게요 사지마세요", 1);
        commmentMap.put("이거 무조건 사야해여", 5);
        commmentMap.put("이건 아닌것 같아요", 2);
        commmentMap.put("이정도면 괜찮은거 같네여", 4);
        commmentMap.put("가성비 괜칞아여", 3);


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
        List<String> s = new ArrayList<>();
        Insert insert = new Insert(1, s, "B", "뷰티");
        insert.hi();


    }
}