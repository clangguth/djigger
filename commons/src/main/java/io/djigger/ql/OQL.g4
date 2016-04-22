grammar OQL;

@header {
    package io.djigger.ql;
}

parse
    : expr EOF
    ;
    
expr
 : NOT expr                             #notExpr
 | expr op=(EQ | NEQ) expr              #equalityExpr
 | expr AND expr                        #andExpr
 | expr OR expr                         #orExpr
 | atom                                 #atomExpr
 ;    

atom
 : OPAR expr CPAR  #parExpr
 | NONQUOTEDSTRING #nonQuotedStringAtom
 | STRING          #stringAtom
 ;

EQ : '=';
NEQ : '!=';
OR : 'or';
AND : 'and';
NOT : 'not';

OPAR : '(';
CPAR : ')';

NONQUOTEDSTRING: ('a'..'z' | 'A'..'Z' | '0'..'9' |'.'|'$'|'_'|'-'|'<'|'>')+ ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

SPACE
 : [ \t\r\n] -> skip
 ;