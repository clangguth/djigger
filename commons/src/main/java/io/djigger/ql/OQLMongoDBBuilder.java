package io.djigger.ql;

import io.djigger.ql.OQLParser.ParseContext;
import org.antlr.v4.runtime.*;
import org.bson.conversions.Bson;

public class OQLMongoDBBuilder {

    public static Bson build(String expression) {
        ParseContext context = parse(expression);
        OQLMongoDBQueryVisitor visitor = new OQLMongoDBQueryVisitor();
        Bson bson = visitor.visit(context.getChild(0));
        return bson;
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
