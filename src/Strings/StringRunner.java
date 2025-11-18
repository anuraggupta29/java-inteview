package Strings;

public class StringRunner {
    public static void main(String[] args){
        String s = "anurag gupta";
        System.out.println(s);

        StringBuilder sb = new StringBuilder("anurag gupta");
        System.out.println(sb);

        StringBuffer sbf = new StringBuffer("anurag gupta");
        System.out.println(sbf);

        sb.toString();
        sbf.toString();

        s.charAt(0);
        sb.charAt(0);
        sbf.charAt(0);

        //s.setCharAt(0,'x');  // not possible string is immutable
        sb.setCharAt(0,'x');
        sbf.setCharAt(0,'x');

        sb.append('a');
        sb.append("abc");
        sb.append(1);  // append any object (calls their tostring method) or primitive
        sb.append(new char[]{'p'});

        sb.delete(0,5);  // delete characters  0,1,2,3,4
        sb.deleteCharAt(1);  // delete character as index 1

        sb.insert(0, 'c');
        sb.insert(2, "apple");
        sb.insert(2,7.2);  // insert works same ways as append and takes any object

        String x = sb.substring(1,6);  // index 1,2,3,4,5

        // StringBuffer has same methods as StringBuilder

        System.out.println(sb);
    }
}
