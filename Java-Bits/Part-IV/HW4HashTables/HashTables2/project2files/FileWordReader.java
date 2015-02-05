import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * FileWordReader reads words from a file one-by-one, converting to lowercase
 * and eliminating punctuation.
 * 
 */
class FileWordReader {
    StreamTokenizer tok;

    public FileWordReader(String file) throws FileNotFoundException, IOException {
        tok = new StreamTokenizer(new BufferedReader(new InputStreamReader(
                new FileInputStream(file))));
        tok.eolIsSignificant(false);
        tok.lowerCaseMode(true);
        tok.wordChars('a', 'z');
        tok.wordChars('A', 'Z');
        String punctuation = "!.;:-[],;!?*+-=\\|/(){}\"><'";
        for (int i = 0; i < punctuation.length(); i++) {
            tok.wordChars(punctuation.charAt(i), punctuation.charAt(i));
        }
    }

    public String nextWord() throws IOException {
        int ttype = tok.nextToken();
        while (ttype != StreamTokenizer.TT_WORD
                && ttype != StreamTokenizer.TT_EOF)
            ttype = tok.nextToken();
        if (ttype == StreamTokenizer.TT_EOF)
            return null;
        // a little kludgy to remove puncation, e.g., it's becomes its
        // removes everything except english letters (already lower-cased)
        String ans = tok.sval.replaceAll("[^a-z]", "");
        if(ans.length() > 0)
        	return ans;
        return nextWord();
    }
}
