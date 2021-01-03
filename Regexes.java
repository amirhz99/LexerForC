import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regexes {

    TK_COMMENTS1 ("\\/\\*[^\\*]*\\*\\/"),
    TK_COMMENTS2 ("\\/\\/[^\\n]*\\n"),
    TK_MINUS ("-"),
    TK_PLUS ("\\+"),
    TK_MUL ("\\*"),
    TK_DIV ("/"),
    TK_NOT ("~"),
    TK_AND ("&&"),
    TK_OR ("\\|"),
    TK_LESS ("<"),
    TK_LEG ("<="),
    TK_GT (">"),
    TK_GEQ (">="),
    TK_EQ ("=="),
    TK_ASSIGN ("="),
    TK_OPEN ("\\("),
    TK_CLOSE ("\\)"),
    TK_SEMI (";"),
    TK_COMMA (","),
    TK_KEY_IF ("if"),
    TK_KEY_THEN ("then"),
    TK_KEY_ELSE ("else"),
    TK_KEY_WHILE ("while"),
    TK_KEY_RETURN ("return"),
    TK_KEY_BREAK ("break"),
    TK_KEY_FOR ("for"),
    OPEN_BRACKET ("\\{"),
    CLOSE_BRACKET ("\\}"),
    DIFFERENT ("!="),
    TK_KEY_ARROPNEW ("new"),
    TK_KEY_ARROPSIZE ("size"),
    TK_KEY_DTYPEVOID ("void"),
    TK_KEY_DTYPEBOOL ("bool"),
    TK_KEY_DTYPEINT ("int"),
    TK_KEY_DTYPEFLOAT ("float"),
    TK_KEY_BOOLVALTRUE ("true"),
    TK_KEY_BOOLVALFALSE ("false"),
    STRING ("\"[^\"]+\""),
    REAL ("(\\d*)\\.\\d+"),
    TK_ERRORNUM1 ("\\d+\\.+"),
    TK_ERRORNUM2 ("\\d+\\.\\d+\\.[\\d\\.]*"),
    TK_ERRORNUM3 ("\\d+\\.\\.[\\d+\\.]*"),
    IDENTIFIER ("[a-zA-Z\\_][a-zA-Z\\_0-9]*"),
    TK_ERRORIDENT ("[0-9]+[a-zA-Z][a-zA-Z\\_0-9]*"),
    INTEGER ("\\d+");

    private final Pattern pattern;

    Regexes(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}
