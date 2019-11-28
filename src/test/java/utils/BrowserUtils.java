package utils;

public class BrowserUtils {
    public static void wait(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void verifyEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }
}
