package String_algo.Constructive_Problems;
//Given two strings S and T, return if they are equal when both are typed into
// empty text editors. # means a backspace character.
//Note that after backspacing an empty text, the text will continue empty.
//Example 1:
//Input: S = "ab#c", T = "ad#c"
//Output: true
//Explanation: Both S and T become "ac".

//Example 2:
//Input: S = "ab##", T = "c#d#"
//Output: true
//Explanation: Both S and T become "".

//Example 3:
//Input: S = "a##c", T = "#a#c"
//Output: true
//Explanation: Both S and T become "c".

//Example 4:
//Input: S = "a#c", T = "b"
//Output: false
//Explanation: S becomes "c" while T becomes "b".


public class Backspace_String_cmp {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }
    public static boolean backspaceCompare(String S, String T) {
        int skipS = 0, skipT = 0;
        for (int i = S.length()-1, j = T.length()-1; i >= 0 || j >= 0; i--, j--) {
            while(i >= 0) {
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while(j >= 0) {
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false;
        }
        return true;
    }
}
