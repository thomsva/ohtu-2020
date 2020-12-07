package statistics.matcher;

import statistics.Player;

public class OneOf implements Matcher {
    
    private Matcher first;
    private Matcher second;

    public OneOf(Matcher m1, Matcher m2) {
        first =m1;
        second=m2;
    }

    @Override
    public boolean matches(Player p) {
        return (first.matches(p));
    }
    
}
