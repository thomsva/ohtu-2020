package statistics.matcher;

import java.util.LinkedList;
import statistics.Player;
import java.util.Arrays; 

public class QueryBuilder implements Matcher {

    private LinkedList<Matcher> elements;
    private Matcher[] matchers;

    public QueryBuilder() {
        elements = new LinkedList<>();
    }

    public QueryBuilder(Matcher... m){
      this.matchers=m;
    }

    public Matcher QueryBuilder(Matcher matcher) {
        elements = new LinkedList<>();
        elements.add(matcher);
        return this;
    }

    public QueryBuilder playsIn(String x) {
        this.elements.add(new PlaysIn(x));
        return this;
    }

    public QueryBuilder hasAtLeast(int i, String x) {
        this.elements.add(new HasAtLeast(i, x));
        return this;
    }

    public QueryBuilder hasFewerThan(int i, String x) {
        this.elements.add(new HasFewerThan(i, x));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... m) {
        this.elements.add(new Or(m));
        return this;
    }

    public Matcher build() {

        if (elements.isEmpty()) {
            matchers = new Matcher[1];
            matchers[0] = new All();
            return this;
        }

        matchers = new Matcher[elements.size()];
        int i = 0;
        while (!elements.isEmpty()) {
            matchers[i] = elements.pop();
            i++;
        }
        return new QueryBuilder(matchers);
    }

    @Override
    public boolean matches(Player p) {

        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }
        return true;
    }

}
