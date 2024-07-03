public class Test {
    public static void main(String[] args) {
       int x =  doTask();
        System.out.println(x);
    }

    private static int doTask() {
        try {
            int[] data = {3,6,2};
            return data[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
            return  100;
        } finally {
            return 99;
        }
    }
}
