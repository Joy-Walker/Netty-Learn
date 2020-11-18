package io.netty.example.echo;

import io.netty.util.concurrent.*;

/**
 * @Author panligang3
 * @create 2020/10/27 9:41 AM
 *
 * 任务交给线程池执行，，执行完毕向Promise中设置执行结果，设置完毕后触发监听器
 */
public class TestPromise {
    public static void main(String[] args) {

        EventExecutor eventExecutor = new DefaultEventExecutor();

        final Promise promise = new DefaultPromise(eventExecutor);

        promise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {

                if (future.isSuccess()) {
                    System.out.println("任务结束，结果：" + future.get());
                } else {
                    System.out.println("任务失败，异常：" + future.cause());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("任务结束，balabala...");
            }
        });


        eventExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                // 设置 promise 的结果
                promise.setFailure(new RuntimeException());
                //promise.setSuccess(123456);
            }
        });

        try {
            Promise p = promise.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
