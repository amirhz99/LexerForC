import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Lexer lexer = new Lexer(args[0]);
        String outfilename = "output.txt";
        File file = new File(outfilename);
        file.createNewFile();
        FileWriter tokData = new FileWriter(outfilename,true);
        BufferedWriter tokDataB = new BufferedWriter(tokData);

        while (!lexer.isExausthed() ) {

            tokDataB.write(""+lexer.currentLexema());
            tokDataB.write(" :  ");
            tokDataB.write(""+lexer.currentRegexes());
            tokDataB.write("\n");
            if (lexer.currentRegexes()==Regexes.TK_ERRORNUM1 || lexer.currentRegexes()==Regexes.TK_ERRORNUM2 || lexer.currentRegexes()==Regexes.TK_ERRORNUM3 ) {
                break;
            }
            if (lexer.currentRegexes()==Regexes.TK_ERRORIDENT) {
                break;
            }
            lexer.moveAhead();
        }

        tokDataB.close();
    }
}