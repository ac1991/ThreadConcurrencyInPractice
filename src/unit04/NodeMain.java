package unit04;

import unit03.Node0302.SafeListener;
import unit04.Node0404.SafeListHelper;
import unit04.Node0404.UnsafeListHelper;


public class NodeMain {
    public static void main(String[] args){
//        testSafeListHelper();
        testUnsafeListHelper();
    }

    public static void testSafeListHelper(){
        SafeListHelper<String> stringSafeListHelper = new SafeListHelper<>();
        for (int i = 0; i < 1000; i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (finalI % 2 == 0){
                        stringSafeListHelper.list.add("test" + finalI/2);
                    }else {

                        stringSafeListHelper.putIfAbsent("test" + finalI/2);

                    }

                    System.out.println("size:" + stringSafeListHelper.list.size());
                }
            }, "thread" + i).start();
        }
        
//        stringSafeListHelper.list.add("test");
    }

    public static void testUnsafeListHelper(){
        UnsafeListHelper<String> stringUnSafeListHelper = new UnsafeListHelper<>();
        for (int i = 0; i < 1000; i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    if (finalI % 2 == 0){
                        stringUnSafeListHelper.putIfAbsent("test" + finalI);
                        stringUnSafeListHelper.list.add("test" + finalI);
//                    }else {



//                    }

                    System.out.println("size:" + stringUnSafeListHelper.list.size());
                }
            }, "thread" + i).start();
        }
    }
}
