package VigenereCipher;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StringUtilClass {

    public static String rptString(String Str, int length) {
        if (Str == null || length <= 0) return "";
        if (Str.length() == length) return Str;
        if (Str.length() > length) return Str.substring(0, length);

        int keysInLen = length / Str.length();
        int rmd = length - (Str.length() * keysInLen);

        StringBuilder nKey = new StringBuilder();
        for (int i = 0; i < keysInLen; i++)
            nKey.append(Str);
        nKey.append(Str.substring(0, rmd));
        return nKey.toString();
    }
    
    public static String splStrInterval(String inStr, int inter, int off) {
        if (inter <= 0 || off < 0) return inStr;
        return IntStream.range(0, inStr.length())
                .filter(i -> i % inter == 0)
                .mapToObj(i -> i + off < inStr.length() ? inStr.charAt(i + off) + "" : "")
                .collect(Collectors.joining());
    }
    
    public static List<String> StrsAtInterval(String Str, int inter) {
        List<String> strings = new ArrayList<>();
        int len = Math.min(Str.length(), inter);
        for (int i = 0; i < len; i++)
            strings.add(splStrInterval(Str, inter, i));
        return strings;
    }
}