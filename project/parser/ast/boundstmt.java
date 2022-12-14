package project.parser.ast;

import static java.util.Objects.requireNonNull;

import project.visitors.Visitor;

public class boundstmt implements Exp {
    private final Exp exp;

    public boundstmt(Exp exp) {
        this.exp = requireNonNull(exp);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + exp + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitBoundStmt(exp);
    }

}
