package common;

public class Common {

    public static void println() {
        System.out.println();
    }

    public static void println(String name, Object value) {
        System.out.println( name + " : " + value);
    }

    /**
     * @param values
     * Object[][] obj = { { "key", value } };
     */
    public static void println(Object[][] values) {
        StringBuffer buffer = new StringBuffer();
        for(Object[] value : values) {
            buffer.append( value[0] ).append(" : ")
                    .append(value[1]).append(" / ");
        }

        System.out.println( buffer.toString() );
    }

    public static void printlnDash() {
        System.out.println( "---------------------------------------" );
    }
}
