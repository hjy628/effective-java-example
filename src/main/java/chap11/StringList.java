package chap11;

import java.io.*;

//StringList with a reasonable custom serialized form
public final class StringList implements Serializable {

    private transient int size = 0;
    private transient Entry head = null;

    //No longer Serializable!
    private static class Entry{
        String data;
        Entry next;
        Entry previous;
    }

    //Appends the specified string to the list
    public final void add(String s){

    }

    private void writeObject(ObjectOutputStream s)throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        for (Entry e=head;e!=null;e=e.next){
            s.writeObject(e.data);
        }
    }


    private void readObject(ObjectInputStream s)throws IOException,ClassNotFoundException{
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0;i<numElements;i++){
            add((String)s.readObject());
        }
    }

}
