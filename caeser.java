public class caeser{

    public String encrypt(String text , int shift){
        int n = text.length();
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            
            if(Character.isLetter(ch)){
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char)((ch + base -shift)% 26 +base);
            }
            result.append(ch);

        }
        System.err.println(result);
        return result.toString();
}

    public String decrypt(String text , int shift ){
      String answer =encrypt(text , 26-shift);
        return  answer;
    }

    public static void main(String[] args) {
        caeser c1 = new caeser();

        c1.encrypt("Mediterranean" , 5);
        c1.decrypt("Hlkpalyyhulhu", 5);

    

    }
   
}
