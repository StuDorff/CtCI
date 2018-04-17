public class Solution
{
    public static void main(String[] args)
    {
        String[] str = new String[]{"assal", "salsa", "lol", "lawl", "", "", "h ", "h "};

        System.out.println("-------------ASCII method-------------------");
        for (int i = 0; i < str.length; i += 2){
            System.out.println("Permutation?: " + isPermutation(str[i], str[i+1]));
        }
    }

    static boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        int[] chars = new int[128];             // ASCII is max 128 chars

        for(int i = 0; i < str1.length(); i++){
            chars[str1.charAt(i)]++;            //str1.charAt(i) gives char... char converts to int (0-128) in ascii
        }

        for(int i = 0; i < str1.length(); i++){
            chars[str2.charAt(i)]--;

            if (chars[str2.charAt(i)] < 0)
                return false;
        }

        return true;

    }

}
