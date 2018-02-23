package io.djigger.ql;

import io.djigger.ql.OQLParser.ParseContext;
import org.antlr.v4.runtime.*;

public class OQLFilterBuilder {

    public static <T> Filter<T> getFilter(String expression, FilterFactory<T> factory) {
        ParseContext context = parse(expression);
        OQLFilterVisitor<T> visitor = new OQLFilterVisitor<>(factory);
        Filter<T> filter = visitor.visit(context.getChild(0));
        return filter;
    }

    private static ParseContext parse(String expression) {
        OQLLexer lexer = new OQLLexer(new ANTLRInputStream(expression));
        OQLParser parser = new OQLParser(new CommonTokenStream(lexer));
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });
        return parser.parse();

    }
}
