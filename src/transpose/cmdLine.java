package transpose;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import  java.io.*;

import java.io.IOException;


public class cmdLine {
    @Option(name = "-file", metaVar = "file", usage = "Имя входного файла")
    private  String inputFile;

    @Option(name = "-ofile", metaVar = "ofile", usage = "Имя выходного файла")
    private  String outputFile;

    @Option(name = "-a", metaVar = "length", usage = "Длина слова ")
    private  int length;

    @Option(name = "-t", metaVar = "cut", usage = "Нужно ли обрезать слово")
    private boolean cut;

    @Option(name = "-r", metaVar = "rightBorder", usage = "Выравнивание по правой границе")
    private boolean rightBorder;

    public static void main(String[] args) {

        try {
            new cmdLine().launch(args);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public void launch(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);

        try{
            parser.parseArgument(args);
            if ((length == 0) && (cut || rightBorder)){
                length = 10;
            }

        }catch (CmdLineException e){
            System.err.println(e.getMessage());
            System.err.println("java -jar transpose.jar -a length -t cut -r -o ofile -file");
            parser.printUsage(System.err);
            return;
        }
        transpose transpose = new transpose(length, rightBorder, cut);
        try {
            InputStream inputStream;
            OutputStream outputStream;
            outputStream = outputFile == "" ? new BufferedOutputStream(System.out) : new FileOutputStream(outputFile);
            inputStream = inputFile == "" ? new BufferedInputStream(System.in):  new FileInputStream(inputFile);
            transpose.transpose(inputStream, outputStream);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
