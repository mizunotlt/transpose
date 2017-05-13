import org.junit.Assert;
import org.junit.Test;
import transpose.cmdLine;
import transpose.transpose;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public  transpose transpose1 = new  transpose(0, false, false);
    public  transpose transpose2 = new  transpose(2, false, true);


    @Test
    public void transpose() throws IOException {

        transpose1.transpose(new FileInputStream("file/input.txt"), new FileOutputStream("file/output.txt"));
        FileInputStream in1 = new FileInputStream("file/output.txt");
        Scanner file1 = new Scanner(in1);
        StringBuilder result1 = new StringBuilder();
        List< String > resList1 = new ArrayList<>();
        while (file1.hasNextLine()){
            resList1.add(file1.nextLine());
        }
        for( int i = 0; i < resList1.size(); i++){
            result1.append(resList1.get(i));
            if (i != resList1.size() - 1){
                result1.append("\n");
            }
        }
        file1.close();
        Assert.assertEquals("A D\n" +
                "B E\n" +
                "C" , result1.toString());


        transpose2.transpose(new FileInputStream("file/input1.txt"), new FileOutputStream("file/output2.txt"));
        FileInputStream in2 = new FileInputStream("file/output2.txt");
        Scanner file2 = new Scanner(in2);
        StringBuilder result2 = new StringBuilder();
        List< String > resList2 = new ArrayList<>();
        while (file2.hasNextLine()){
            resList2.add(file2.nextLine());
        }
        for( int i = 0; i < resList2.size(); i++){
            result2.append(resList2.get(i));
            if (i != resList2.size() - 1){
                result2.append("\n");
            }
        }
        file2.close();
        Assert.assertEquals("cu bu cv\n" +
                "de gr lo\n" +
                "re de" , result2.toString());
    }

    @Test
    public  void cmdLine() throws IOException {
        String[]  args = {"-file", "file/input.txt", "-ofile", "file/output.txt"};
        cmdLine line = new cmdLine();
        line.launch(args);
        FileInputStream in1 = new FileInputStream("file/output.txt");
        Scanner file1 = new Scanner(in1);
        StringBuilder result1 = new StringBuilder();
        List< String > resList1 = new ArrayList<>();
        while (file1.hasNextLine()){
            resList1.add(file1.nextLine());
        }
        for( int i = 0; i < resList1.size(); i++){
            result1.append(resList1.get(i));
            if (i != resList1.size() - 1){
                result1.append("\n");
            }
        }
        file1.close();
        Assert.assertEquals("A D\n" +
                "B E\n" +
                "C" , result1.toString());
        String[]  args1 = {"-file", "file/input1.txt", "-ofile", "file/output2.txt", "-a", "2", "-t"};
        cmdLine line1 = new cmdLine();
        line1.launch(args1);
        FileInputStream in2 = new FileInputStream("file/output2.txt");
        Scanner file2 = new Scanner(in2);
        StringBuilder result2 = new StringBuilder();
        List< String > resList2 = new ArrayList<>();
        while (file2.hasNextLine()){
            resList2.add(file2.nextLine());
        }
        for( int i = 0; i < resList2.size(); i++){
            result2.append(resList2.get(i));
            if (i != resList2.size() - 1){
                result2.append("\n");
            }
        }
        file2.close();
        Assert.assertEquals("cu bu cv\n" +
                "de gr lo\n" +
                "re de" , result2.toString());

    }

}