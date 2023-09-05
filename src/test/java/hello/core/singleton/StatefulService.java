package hello.core.singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
//        this.price = price;
        return price;
    } // 무상태로 해결해야 함!

//    public int getPrice() {
//        return price;
//    }
}
