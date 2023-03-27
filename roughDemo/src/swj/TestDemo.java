package swj;

public class TestDemo {
    public static void main(String[] args) {
        // 1、生产者线程：负责不断接收打进来的电话
        CallThread call = new CallThread();
        call.start();

        // 2、消费者线程：客服，每个客服每次接听一个电话
        ReceiveThread r1 = new ReceiveThread();
        r1.start();
    }
}

class CallThread extends Thread{
    @Override
    public void run() {
        // 不断的打入电话
        while (true){
            try {
                Thread.sleep(1000);
                CallSystem.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReceiveThread extends Thread{
    @Override
    public void run() {
        // 1号  2号
        while (true){
            try {
                Thread.sleep(1000);
                CallSystem.receive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 呼叫系统。
class CallSystem {
    // 定义一个变量记录当前呼入进来的电话。
    public static int number = 0; // 最多只接听一个。

    // 接入电话
    public synchronized static void call() {
        try {
            String name = Thread.currentThread().getName();
            number++;
            System.out.println(name+"成功接入一个用户，等待分发~~~~");

            // 唤醒别人 : 1个
            CallSystem.class.notify();
            // 让当前线程对象进入等待状态。
            CallSystem.class.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 分发电话
    public synchronized static void receive() {
        try {
            String name = Thread.currentThread().getName();
            if(number == 1){
                System.out.println(name + "此电话已经分发给客服并接听完毕了~~~~~");
                number--;
                // 唤醒别人 : 1个
                CallSystem.class.notify();
                CallSystem.class.wait(); // 让当前线程等待
            }else {
                // 唤醒别人 : 1个
                CallSystem.class.notify();
                CallSystem.class.wait(); // 让当前线程等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
