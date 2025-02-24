public class Bonus {
    public static void main(String[] args) {
        String[] strings = new String[]{"CSE1325", "NOT CSE1325"};
        for(String s : strings) {
            if(s.startsWith("CSE"))            System.out.println(s + " Algorithm 1");
            if(s.indexOf("CSE") == 0)          System.out.println(s + " Algorithm 2");
            if(s.substring(0,3).equals("CSE")) System.out.println(s + " Algorithm 3");
            if(s.charAt(0) == 'C' &&
               s.charAt(1) == 'S' &&
               s.charAt(2) == 'E')             System.out.println(s + " Algorithm 4");
        }
    }
}
