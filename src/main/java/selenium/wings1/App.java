package selenium.wings1;

public class App {
    public static void main(String[] args) {
        String s = "Please use temporary password 'rahulshettyacademy' to Login."; 
        String[] passArray = s.split("'");
        // for(String  str : passArray){
        //     System.out.println("Text:" + str);
        // }
        //System.out.println(passArray[1]);
        String password = passArray[1];
        System.out.println(password);
    }
}
