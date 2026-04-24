public class WrapperClassUtility {

    public static void main(String []args){

        Character ch = 'a';
        ch.compareTo('b');
        // important static methods of Character class
        Character.isLetterOrDigit(ch);
        Character.isUpperCase(ch);
        Character.isLowerCase(ch);
        Character.isWhitespace(ch);
        Character.toLowerCase(ch);
        Character.toUpperCase(ch);
        // below method Converts '5' directly to the integer 5
        Character.getNumericValue(ch);
        Character.compare('b', ch);


        //important static and instance methods of Integer class
        Integer x = 5;
        x =  Integer.MIN_VALUE;
        x =  Integer.MAX_VALUE;
        x.toString();
        x.compareTo(5);
        Integer.compare(x, 5);
        // below returns primitive int
        Integer.parseInt("1234");
        // below returns Integer class object
        Integer.valueOf("1234");
        Integer.max(x, 5);
        Integer.min(x, 5);

        //important static and instance methods of String class
        String s = new String("hello world");
        s = s.concat(" hi  there");
        s.length();
        s.toCharArray();
        s.charAt(0);
        s.compareTo("hey there");
        s.equals("hi there");
        s.equalsIgnoreCase("ksdfklsf");
        s.toLowerCase();
        s.toUpperCase();
        s.indexOf("there");
        s.lastIndexOf("the");
        s.startsWith("pref");
        s.substring(0, 5);
        // below has begin index to len of string
        s.substring(3);
        s.isEmpty();
        s.trim();
        // split by any number of whitespace or tabs
        s.split("\\s+");
        s.repeat(3);
        String.join("-", "2026", "04", "24");
        // below can be used for any primitive
        String.valueOf(4);

        //important static and instance methods of StringBuilder class
        StringBuilder sb = new StringBuilder();
        sb.append("dnfklsn");
        sb.append(4);
        sb.charAt(0);
        sb.deleteCharAt(0);
        // end isnt included
        sb.delete(0, 2);
        sb.length();
        sb.toString();
        sb.compareTo(new StringBuilder("jsdfk"));
        sb.insert(0, "dnkfa");
        sb.reverse();
        sb.isEmpty();
        sb.substring(2, 3);
        // first occurence
        sb.indexOf("hello");
        sb.setCharAt(1, 'a');
        sb.setLength(0);

    }
}
