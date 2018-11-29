package chap11;

import java.util.concurrent.atomic.AtomicReference;

//Nonserializable stateful class allowing serializable subclass
public abstract class AbstractFoo {
    private int x,y;    //Our state

    //this enum and field are used to track initialization
    private enum State{NEW,INITIALIZING,INITIALIZED};
    private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);

    public AbstractFoo(int x,int y){
        initialize(x, y);
    }

    //this constructor and the following method allow
    //subclass's readObject method to initialize our State.
    protected AbstractFoo(){}

    protected final void initialize(int x,int y){
        if (!init.compareAndSet(State.NEW,State.INITIALIZING))
                throw new IllegalStateException("Already initialized");
            this.x = x;
            this.y = y;
            //todo do anything else the original constructor did
        init.set(State.INITIALIZED);
    }

    //these methods provide access to internal state so it can
    //be manually serialized by subclass's writeObject method.
    protected final int getX(){checkInit();return x;}
    protected final int getY(){checkInit();return y;}

    private void checkInit(){
        if (init.get()!=State.INITIALIZED)
                throw new IllegalStateException("Uninitialized");
    }

    //Remainder omitted
}
