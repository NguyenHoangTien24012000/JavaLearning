package JavaLoginSystem;

import java.util.HashMap;

public class IdAndPassword {
    HashMap<String, String> loginInfo= new HashMap<>();
    public IdAndPassword(){
        loginInfo.put("tien", "1234");
        loginInfo.put("thuong", "12345");
        loginInfo.put("son", "123456");
        loginInfo.put("hien", "1234567");
    }
    protected HashMap getLoginInfo(){
        return loginInfo;
    }
    public void printString(){
        System.out.println("test");
    }
}
