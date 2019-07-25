package unit03.Node0302;

public class SafeListener {
    private final EventListener listener;

    private SafeListener(){

        this.listener = new EventListener() {
            @Override
            public void onEvent(String event) {

            }
        };
    }

    public static SafeListener newInstance(){
        SafeListener safeListener = new SafeListener();
        return  safeListener;
    }



}


