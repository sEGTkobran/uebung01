package ueb01;

import javax.print.DocFlavor;
import java.util.NoSuchElementException;

class CharElement {
    char value;
    CharElement next;

    public CharElement(char c, CharElement E){
        this.value = c;
        this.next = E;
    }

}

class CharStackImpl implements CharStack {

    private CharElement head;
    private int size = 0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public char pop() {
        if (head == null) {
            throw new NoSuchElementException();

        }

        CharElement it = head;
        CharElement itPrev = null;
        //bis zum lesten "reisen"
        while (it.next != null){
            itPrev = it;
            it = it.next;
        }

        size--;
        if (itPrev == null){
            itPrev = it;
            it = null;
            return itPrev.value;
        }
        itPrev.next = null;
        return it.value;
    }

    @Override
    public void push(char c) {
        // size eins hochzählen
        size++;
        // leere List
        if (head == null){
            head = new CharElement(c , null);

            return;
        }

        // bis zum Ende laufen
        CharElement it = head;
        while (it.next != null)
            it = it.next;

        // am Ende anhängen
        it.next = new CharElement(c, null);

    }
}
