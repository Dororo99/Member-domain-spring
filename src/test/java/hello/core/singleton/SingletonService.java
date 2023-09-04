package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // static 영역에 하나만 생성됨

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
