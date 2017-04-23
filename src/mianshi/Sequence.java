package mianshi;

/**
 * Author ： Martin
 * Date : 17/4/10
 * Description :
 * Version : 2.0
 */
public class Sequence {
    private Object[] items;
    private int index = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (index < items.length) {
            items[index++] = x;
        }
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(5);
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);
        sequence.add(5);
        sequence.add(6);
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
