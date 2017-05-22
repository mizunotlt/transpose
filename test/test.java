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
    public transpose transpose1 = new transpose(1, false, false);
    public transpose transpose2 = new transpose(2, true, false);
    public transpose transpose3 = new transpose(1, false, true);
    public transpose transpose4 = new transpose(4, true, true);


    @Test
    public void transpose() throws IOException {

        transpose1.transpose(new FileInputStream("file/input.txt"), new FileOutputStream("file/output.txt"));
        FileInputStream in1 = new FileInputStream("file/output.txt");
        Scanner file1 = new Scanner(in1);
        StringBuilder result1 = new StringBuilder();
        List<String> resList1 = new ArrayList<>();
        while (file1.hasNextLine()) {
            resList1.add(file1.nextLine());
        }
        for (int i = 0; i < resList1.size(); i++) {
            result1.append(resList1.get(i));
            if (i != resList1.size() - 1) {
                result1.append("\n");
            }
        }
        file1.close();
        Assert.assertEquals("A D\n" +
                "B E\n" +
                "C  ", result1.toString());

        transpose3.transpose(new FileInputStream("file/input3.txt"), new FileOutputStream("file/output3.txt"));
        FileInputStream in3 = new FileInputStream("file/output3.txt");
        Scanner file3 = new Scanner(in3);
        StringBuilder result3 = new StringBuilder();
        List<String> resList3 = new ArrayList<>();
        while (file3.hasNextLine()) {
            resList3.add(file3.nextLine());
        }
        for (int i = 0; i < resList3.size(); i++) {
            result3.append(resList3.get(i));
            if (i != resList3.size() - 1) {
                result3.append("\n");
            }
        }
        file3.close();
        Assert.assertEquals("z s d s d\n" +
                "s d g d  \n" +
                "e   f    \n" +
                "v        \n" +
                "s        ", result3.toString());

        transpose4.transpose(new FileInputStream("file/input4.txt"), new FileOutputStream("file/output4.txt"));
        FileInputStream in4 = new FileInputStream("file/output4.txt");
        Scanner file4= new Scanner(in4);
        StringBuilder result4 = new StringBuilder();
        List<String> resList4 = new ArrayList<>();
        while (file4.hasNextLine()) {
            resList4.add(file4.nextLine());
        }
        for (int i = 0; i < resList4.size(); i++) {
            result4
                    .append(resList4.get(i));
            if (i != resList4.size() - 1) {
                result4.append("\n");
            }
        }
        file4.close();
        Assert.assertEquals("  zx  asd erdf\n" +
                "zxcv        vb\n" +
                "derf          " , result4.toString());

        transpose2.transpose(new FileInputStream("file/input1.txt"), new FileOutputStream("file/output2.txt"));
        FileInputStream in2 = new FileInputStream("file/output2.txt");
        Scanner file2 = new Scanner(in2);
        StringBuilder result2 = new StringBuilder();
        List<String> resList2 = new ArrayList<>();
        while (file2.hasNextLine()) {
            resList2.add(file2.nextLine());
        }
        for (int i = 0; i < resList2.size(); i++) {
            result2.append(resList2.get(i));
            if (i != resList2.size() - 1) {
                result2.append("\n");
            }
        }
        file2.close();
        Assert.assertEquals("cut but cve\n" +
                "def grood loj\n" +
                "red dec   ", result2.toString());

    }

    @Test
    public void cmdLine() throws IOException {

        String[] args = {"file/input.txt", "-ofile", "file/output.txt", "-a" , "1"};
        cmdLine line = new cmdLine();
        line.launch(args);
        FileInputStream in1 = new FileInputStream("file/output.txt");
        Scanner file1 = new Scanner(in1);
        StringBuilder result1 = new StringBuilder();
        List<String> resList1 = new ArrayList<>();
        while (file1.hasNextLine()) {
            resList1.add(file1.nextLine());
        }
        for (int i = 0; i < resList1.size(); i++) {
            result1.append(resList1.get(i));
            if (i != resList1.size() - 1) {
                result1.append("\n");
            }
        }
        file1.close();
        Assert.assertEquals("A D\n" +
                "B E\n" +
                "C  ", result1.toString());

        String[] args5 = {"file/input.txt", "-ofile", "file/output5.txt", "-r"};
        cmdLine line5 = new cmdLine();
        line5.launch(args5);
        FileInputStream in5= new FileInputStream("file/output5.txt");
        Scanner file5 = new Scanner(in5);
        StringBuilder result5 = new StringBuilder();
        List<String> resList5 = new ArrayList<>();
        while (file5.hasNextLine()) {
            resList5.add(file5.nextLine());
        }
        for (int i = 0; i < resList5.size(); i++) {
            result5.append(resList5.get(i));
            if (i != resList5.size() - 1) {
                result5.append("\n");
            }
        }
        file5.close();
        Assert.assertEquals("         A          D\n" +
                "         B          E\n" +
                "         C           ", result5.toString());


        String[] args6 = {"file/input1.txt", "-ofile", "file/output6.txt", "-r"};
        cmdLine line6 = new cmdLine();
        line6.launch(args6);
        FileInputStream in6= new FileInputStream("file/output6.txt");
        Scanner file6 = new Scanner(in6);
        StringBuilder result6 = new StringBuilder();
        List<String> resList6 = new ArrayList<>();
        while (file6.hasNextLine()) {
            resList6.add(file6.nextLine());
        }
        for (int i = 0; i < resList6.size(); i++) {
            result6.append(resList6.get(i));
            if (i != resList6.size() - 1) {
                result6.append("\n");
            }
        }
        file6.close();
        Assert.assertEquals("       cut        but        cve\n" +
                "       def      grood        loj\n" +
                "       red        dec           ", result6.toString());


        String[] args1 = {"file/input1.txt", "-ofile", "file/output2.txt", "-a", "2", "-t"};
        cmdLine line1 = new cmdLine();
        line1.launch(args1);
        FileInputStream in2 = new FileInputStream("file/output2.txt");
        Scanner file2 = new Scanner(in2);
        StringBuilder result2 = new StringBuilder();
        List<String> resList2 = new ArrayList<>();
        while (file2.hasNextLine()) {
            resList2.add(file2.nextLine());
        }
        for (int i = 0; i < resList2.size(); i++) {
            result2.append(resList2.get(i));
            if (i != resList2.size() - 1) {
                result2.append("\n");
            }
        }
        file2.close();
        Assert.assertEquals("cu bu cv\n" +
                "de gr lo\n" +
                "re de   ", result2.toString());

        String[] args3 = {"file/input3.txt", "-ofile", "file/output2.txt", "-a", "1", "-t"};
        cmdLine line3 = new cmdLine();
        line3.launch(args3);
        FileInputStream in3 = new FileInputStream("file/output2.txt");
        Scanner file3 = new Scanner(in3);
        StringBuilder result3 = new StringBuilder();
        List<String> resList3 = new ArrayList<>();
        while(file3.hasNextLine())

        {
            resList3.add(file3.nextLine());
        }
        for(
                int i = 0; i<resList3.size();i++)

        {
            result3.append(resList3.get(i));
            if (i != resList3.size() - 1) {
                result3.append("\n");
            }
        }
        file3.close();
        Assert.assertEquals("z s d s d\n"+
                "s d g d  \n"+
                "e   f    \n"+
                "v        \n"+
                "s        ",result3.toString());

        String[] args4 = {"file/input4.txt", "-ofile", "file/output4.txt", "-a", "4", "-t", "-r"};
        cmdLine line4 = new cmdLine();
        line4.launch(args4);
        FileInputStream in4 = new FileInputStream("file/output4.txt");
        Scanner file4 = new Scanner(in4);
        StringBuilder result4 = new StringBuilder();
        List<String> resList4 = new ArrayList<>();
        while(file4.hasNextLine())

        {
            resList4.add(file4.nextLine());
        }
        for(
                int i = 0; i<resList4.size();i++)

        {
            result4.append(resList4.get(i));
            if (i != resList4.size() - 1) {
                result4.append("\n");
            }
        }
        file4.close();
        Assert.assertEquals("  zx  asd erdf\n" +
                "zxcv        vb\n" +
                "derf          " , result4.toString());

    }
}




