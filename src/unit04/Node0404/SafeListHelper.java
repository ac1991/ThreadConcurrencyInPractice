package unit04.Node0404;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SafeListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x){
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }

            return absent;
        }
    }
}
