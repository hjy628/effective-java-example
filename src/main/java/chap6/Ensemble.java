package chap6;

public enum Ensemble {
/*

    //Abuse of ordinal to derive an associated value -DON'T DO THIS
    SOLO, DUET,TRIO, QUARTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians(){
        return ordinal() + 1;
    }
    */

//good

    SOLO(1), DUET(2),TRIO(3), QUARTET(4),QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10);

    private final int numberOfMusicians;
    Ensemble(int size){this.numberOfMusicians = size; }


}
