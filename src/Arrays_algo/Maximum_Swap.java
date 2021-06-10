package Arrays_algo;

public class Maximum_Swap {
    public static void main(String[] args) {
        int num = 10909091;
        System.out.println(maximumSwap(num));
    }
    public static int maximumSwap(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int n = ch.length;
        int[] pos = new int[n];
        pos[n-1] = n-1;
        for (int i = n - 2; i >= 0; i--) {
            if (ch[i] > ch[i+1]) {
                if (ch[i] > ch[pos[i+1]]) pos[i] = i;
                else if (ch[i] == ch[pos[i+1]]) pos[i] = pos[i+1];
                else pos[i] = pos[i+1];
            }else pos[i] = pos[i+1];
        }
        for (int i = 0; i < n; i++) {
            if (i != pos[i] && ch[i] != ch[pos[i]]) {
                swap(i, pos[i], ch);
                break;
            }
        }
        //System.out.println(Arrays.toString(ch) + "\n" + Arrays.toString(pos));
        String s = new String(ch);
        return Integer.valueOf(s);
    }
    public static void swap(int i, int j, char[] ch) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
