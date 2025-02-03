public class Setting {
    public static void main(String[] args) {
        Spoon spoon = new Spoon(Pattern.Rattail);
        spoon.use();
        spoon.wash();
        spoon.use();
        try {
            spoon.use();
        } catch(UnhygienicException e) {
            System.err.println("Yikes! " + spoon + " is dirty!");
            spoon.wash();
            spoon.use();
        }
    }
}

