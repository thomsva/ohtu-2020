package statistics.matcher;

import java.util.LinkedList;

public class Stack {

    private LinkedList<String> elements;

    public Stack() {
        elements = new LinkedList<String>();
    }

    public void push(String alkio) {
        elements.addFirst(alkio);
    }

    public String pop() {
        return elements.remove();
    }

    public boolean empty() {
        return elements.isEmpty();
    }

}
