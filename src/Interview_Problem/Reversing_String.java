package Interview_Problem;

public class Reversing_String {
    public static void main(String[] args) {
        String name = "Tamoghna";
        System.out.println(reverse(name));
    }
    public static String reverse(String s){
        char[] ch = s.toCharArray();
        int lastIndex = ch.length - 1;
        for (int i = 0; i < ch.length / 2; i++){
            char temp = ch[i];
            ch[i] = ch[lastIndex - i];
            ch[lastIndex - i] = temp;
        }

        return new String(ch);
    }
}
