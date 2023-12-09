package helper;

import core.BaseTest;

import java.io.File;
import java.util.Date;

public class BaseTestHelper extends BaseTest {

    public static void createFolder(String path){
        //File is class inside the Java.io Package
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();// mkdir is used to crate a folder

        }else{
            System.out.println("File Already exists");
        }

    }
    public static String TimeStamp() {
        Date now =new Date();
        String TimeStamp=now.toString().replace(":","-");
        return TimeStamp;


    }
}