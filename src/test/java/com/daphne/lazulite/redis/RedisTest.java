/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.redis;

import com.daphne.lazulite.LazuliteApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by junfu on 2016/5/25.
 */
public class RedisTest extends LazuliteApplicationTests {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void TestRedis(){
        ValueOperations<String, String> vo= template.opsForValue();
        vo.set("person","junfu.chen");
        System.out.println(vo.get("person"));



    }

    public static void main(String[] args) {
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();
        SerialExecutor se=new SerialExecutor(executor);
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+" run 1");
//            }
//        });
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+" run 2");
//            }
//        });
//        Collection<Callable<String>> solvers =new ArrayList<Callable<String>>();
//        Callable<String> callable1= new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                System.out.println("call task 1");
//                return "call 1";
//            }
//        };
//        Callable<String> callable2= new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                System.out.println("call task 2");
//                return "call 2";
//            }
//        };
//        solvers.add(callable1);
//        solvers.add(callable2);
//        try {
//            solve(se,solvers);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        BeeperControl beeperControl=new BeeperControl();
        beeperControl.beepForAnHour();

    }
   static void solve(Executor e, Collection<Callable<String>> solvers)
            throws InterruptedException, ExecutionException {
        CompletionService<String> ecs = new ExecutorCompletionService<String>(e);
        int n=solvers.size();
       List<Future<String>> futures= new ArrayList<Future<String>>(n);
       String result=null;
       try
       {
           for (Callable<String> s : solvers)
               futures.add(ecs.submit(s));
           for (int i = 0; i < n; ++i) {
               try {
                   String r = ecs.take().get();
                   if (r != null) {
                       result = r;
                       break;
                   }
               } catch(ExecutionException ignore) {}
           }

       }catch (Exception e1){

       } finally {
           for (Future<String> f : futures)
               f.cancel(true);
       }
       if (result != null)
           use(result);


   }

    static class BeeperControl {
        private final ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        public void beepForAnHour() {
            final Runnable beeper = new Runnable() {
                public void run() { System.out.println("beep"); }
            };
            final ScheduledFuture<?> beeperHandle =
                    scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);

            scheduler.schedule(new Runnable() {
                public void run() { beeperHandle.cancel(true); }
            }, 60 * 60,TimeUnit.SECONDS);
        }
    }


    static void use(String result){
        System.out.println("use:"+result);
    }


    public static class ThreadPerTaskExecutor implements Executor {
        public void execute(Runnable r) {
            new Thread(r).start();
        }
    }
    static class SerialExecutor implements Executor {
        final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
        final Executor executor;
        Runnable active;

        SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        public synchronized void execute(final Runnable r) {
            tasks.offer(new Runnable() {
                public void run() {
                    try {
                        r.run();
                    } finally {
                        scheduleNext();
                    }
                }
            });
            if (active == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            if ((active = tasks.poll()) != null) {
                executor.execute(active);
            }
        }
    }



}
