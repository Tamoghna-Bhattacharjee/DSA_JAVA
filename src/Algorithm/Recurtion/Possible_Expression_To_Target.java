package Algorithm.Recurtion;

public class Possible_Expression_To_Target {
    public static void main(String[] args) {
        String str = "125";
        int target = 7;
        printExpressionForTarget(str , Character.MIN_VALUE , target , "" , 0 , 0 , str.length());

    }
    private static void printExpressionForTarget(String str, char operation , int target , String expression , int res , int start , int len){

        if(start >= len) {
            if (res == target) {
//                StringBuilder stringBuilder = new StringBuilder(expression);
//                stringBuilder.setCharAt(0 , Character.MIN_VALUE);
                System.out.println(expression);
            }
            return;
        }

        for(int i = start ; i < str.length() ; i++){
            String s1 = str.substring(start , i + 1);
            int n1 = Integer.valueOf(s1);

            switch (operation){
                case '+':
                    res += n1;
                    break;
                case '-':
                    res -= n1;
                    break;
                case '*':
                    res *= n1;
                    break;
                default:
                    res = n1;
                    break;
            }

            printExpressionForTarget(str , '+' , target ,expression + operation + n1 , res , i+1 , len);
            printExpressionForTarget(str , '-' , target ,expression + operation + n1 , res , i+1 , len);
            printExpressionForTarget(str , '*' , target ,expression + operation + n1 , res , i+1 , len);

        }

    }
}
