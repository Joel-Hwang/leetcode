package CS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class FileBlock {
    public void seperateBlock(String path){
        try(FileReader fr = new FileReader(path);)
        {
            int read;
            char[] buf = new char[100];
            while((read = fr.read(buf)) != -1  ){
                String data = new String(buf,0,read);
                System.out.println(data.hashCode());  
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void test(){
        String downloadPath = "C:\\Users\\hwang\\Downloads\\";
        String oriFilePath = downloadPath+"test.txt";
        seperateBlock(oriFilePath);
    }
}
