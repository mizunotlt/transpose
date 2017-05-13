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

                for (int i = 0; i < word.length; i++) {
                    if (word[i].equals("")){
                    }else{
                        words.add(word[i]);
                    }
                }
                if (words.size() > maxWordsSize) {
                    maxWordsSize = words.size();
                }
                inputStrings.add(words);
            }

            // Обрезание доведение до нужного размера и выравнивания
            for (int i = 0; i < inputStrings.size(); i++ ){
                for (int j =0; j < inputStrings.get(i).size() ;j++){
                    //выравнивание и доведение до нужного размера
                    if (rightBorder) {
                        if (inputStrings.get(i).get(j).length() < length) {
                            StringBuilder sb = new StringBuilder();
                            for (int k = inputStrings.get(i).get(j).length(); k < length; k++)
                                sb.append(" ");
                            sb.insert(sb.length(), inputStrings.get(i).get(j));
                            inputStrings.get(i).set(j,sb.toString());
                        }
                        if ((inputStrings.get(i).get(j).length() > length) && (cut)) {
                            inputStrings.get(i).set(j,inputStrings.get(i).get(j).substring(0,length));
                        }
                    }
                    else{
                        if (inputStrings.get(i).get(j).length() < length) {
                            StringBuilder sb = new StringBuilder();
                            for (int k = inputStrings.get(i).get(j).length(); k <= length; k++)
                                sb.append(" ");
                            sb.insert(0, inputStrings.get(i).get(j));
                            inputStrings.get(i).set(j,sb.toString());
                        }
                        if ((inputStrings.get(i).get(j).length() > length) && (cut)) {
                            inputStrings.get(i).set(j,inputStrings.get(i).get(j).substring(0,length));
                        }
                    }
                }
            }

            for (int i = 0; i < maxWordsSize; i++){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < inputStrings.size(); j++){
                    try{
                        sb.append(inputStrings.get(j).get(i));
                            sb.append(" ");
                    }catch (IndexOutOfBoundsException ignore){
                        if ( i != maxWordsSize - 1)
                            sb.append(" ");
                    }
                }
                out.println(sb.toString().substring(0, sb.toString().length() - 1));
            }
        }
        out.close();
    }
}

