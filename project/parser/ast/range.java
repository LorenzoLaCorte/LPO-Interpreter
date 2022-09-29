package project.parser.ast;

import project.visitors.Visitor;
import project.visitors.evaluation.Eval;
import project.environments.EnvironmentException;
import project.visitors.evaluation.Value;


public class range implements Iterable<Integer>,Exp{

    private final Exp start, end;
    private final int start1;
    private final int end1;

    // ranges from start (inclusive) to end (exclusive)
    public range(Exp start, Exp end) {
        this.start = start;
        this.end = end;
        this.start1 = 0;
        this.end1 = 0;
    }

    public range(int start1, int end1) {
        this.start = null;
        this.end = null;
        this.start1 = start1;
        this.end1 = end1;
    }


    public Exp getEnd() {
        return end;
    }

    public Exp getStart() {
        return start;
    }


    @Override
    public rangeIterator iterator() {
        return new rangeIterator(start1, end1);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + start + "," + end + ")";
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitRange(start, end);
    }
}
