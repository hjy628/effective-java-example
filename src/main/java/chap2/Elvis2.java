package chap2;

// Singleton with public final field
public class Elvis2 {

    private static final Elvis2 INSTANCE = new Elvis2();

    public Elvis2() {
    }

    public static Elvis2 getInstance(){
        return INSTANCE;
    }

    private void leaveTheBuilding(){

    }
}
