package project.parser.ast;

import project.visitors.evaluation.Eval;

import java.util.Iterator;
import java.util.NoSuchElementException;
import project.visitors.evaluation.rangeValue;
import project.visitors.evaluation.Value;
import project.environments.EnvironmentException;
import project.environments.GenEnvironment;




public class rangeIterator implements Iterator<Integer> {
    private int start;
    private int next;
    private final int end;

    public rangeIterator(int start, int end) {
        this.start = start;
        this.next = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        if(start < end)return next < end;
        if(start >= end) return next > end;
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if(start < end) return next++;
        if(start >= end) return next--;
        return next;
    }
}

