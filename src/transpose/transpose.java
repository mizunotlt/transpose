package transpose;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class transpose {

    private int length;
    private boolean rightBorder;
    private boolean cut;

    public transpose( int length, boolean rightBorder, boolean cut){
        this.cut = cut;
        this.length = length;
        this.rightBorder = rightBorder;
    }
    public  void transpose (InputStream input, OutputStream output) throws IOException{
        PrintWriter out = new PrintWriter(output);

        try (Scanner inputStream = new Scanner(input)){
            List<List<String>> inputStrings = new ArrayList<>();
            int maxWordsSize = 0;

            while (inputStream.hasNextLine()) {

                String[] word = inputStream.nextLine().split(" ");
                List<String> words = new ArrayList<>();

                for (String aWord : word) {
                    if (!aWord.equals(""))
                        words.add(aWord);
                }
                if (words.size() > maxWordsSize) {
                    maxWordsSize = words.size();
                }
                inputStrings.add(words);
            }

            // Обрезание доведение до нужного размера и выравнивания
            for (List<String> inputString : inputStrings) {
                for (int j = 0; j < inputString.size(); j++) {
                    //выравнивание и доведение до нужного размера
                    String newString = inputString.get(j);
                    if (newString.length() < length) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = newString.length(); k < length; k++)
                            sb.append(" ");
                        sb.insert(rightBorder ? sb.length() : 0, newString);
                        inputString.set(j, sb.toString());
                    } else if ((newString.length() > length) && (cut)) {
                        inputString.set(j, newString.substring(0, length));
                    }
                }
            }
            for (int i = 0; i < maxWordsSize; i++){
                StringBuilder sb = new StringBuilder();
                for (List<String> inputString : inputStrings) {
                    try {
                        sb.append(inputString.get(i));
                        sb.append(" ");
                    } catch (IndexOutOfBoundsException ignore) {
                        if (i != maxWordsSize - 1)
                        sb.append(" ");
                    }
                }
                out.println(sb.toString().substring(0, sb.toString().length() - 1));
            }
        }
        out.close();
    }
}

