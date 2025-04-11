package compiler;

import gen.javaMinusMinusListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import gen.javaMinusMinusLexer;
import gen.javaMinusMinusParser;

import java.io.IOException;

public class Compiler {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName(".\\src\\test2.txt");
        javaMinusMinusLexer lexer = new javaMinusMinusLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        javaMinusMinusParser parser = new javaMinusMinusParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
//        MiniJavaListener listener = new ScopePrinter();
        javaMinusMinusListener listener = new ProgramPrinter();

        walker.walk(listener, tree);
    }
}
