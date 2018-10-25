package chap6;

//Bit field enumeration constants - OBSOLETE!
public class Text {

    public static final int STYLE_BOLD = 1 << 0; //1
    public static final int STYLE_ITALIC = 1 << 1; //2
    public static final int STYLE_UNDERLINE = 1 << 2; //4
    public static final int STYLE_STRIKETHROUGH = 1 << 3; //8

    //Parameter is bitwise OrR of zero or more STYLE_ constants
    public void applyStyles(int styles){

    }

}
