public class Solution
{
    public static void main(String[] args ){
        String str = "Hello Mr Dorff";
    }

    void URLify(char[] str){

        int spaces = 0;
        for(int i = 0; i < str.length; i++){
            if (str[i] == ' ')
                spaces++;
        }

        int trueLength = str.length + 2 * spaces;

        for (int i = 0; i < trueLength; i++){

        }
    }

}
