package project.parser.ast;

import static java.util.Objects.requireNonNull;

import project.visitors.Visitor;

public class forStmt implements Stmt {
    private final Exp exp;
    private final Exp exp1;
    private final Block forblock;

    public forStmt(Exp exp, Exp exp1, Block forblock) {
        this.exp = requireNonNull(exp);
        this.exp1 = requireNonNull(exp1);
        this.forblock = requireNonNull(forblock);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + exp + "," + exp1 + "," + forblock + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitForStmt(exp, exp1, forblock);
    }

}
