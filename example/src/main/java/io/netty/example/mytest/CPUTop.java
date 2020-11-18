package io.netty.example.mytest;

/**
 * @Author panligang3
 * @create 2020/11/17 3:25 PM
 */
public class CPUTop {

    public static void main(String[] args) {
      for(int i = 0; i < 10; i++){

          Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                  try {
                      Thread.sleep(100000000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          },"idle-Thread-" + i);

          thread.start();
      }


      new Thread(new Runnable() {
          @Override
          public void run() {
              while (true){
              }
          }
      },"busy-Thread").start();
    }
}
