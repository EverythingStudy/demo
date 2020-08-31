package com.example.demo.test.concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @Description 1.8 JUC中控制线程池的工具类 CompletableFuture
 * @Date 2020/3/17 15:44
 * @Author cly
 **/
public class CompletableFutureTest {
    Logger logger = LoggerFactory.getLogger(CompletableFutureTest.class);
    ExecutorService executorService = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
        try {
            sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行";
    }, executorService);

    /**
     * @return void
     * @Author cly
     * @Description //TODO supplyAsync方法 执行线程
     * @Date 12:57 2020/3/18
     * @Param []
     **/
    @Test
    public void testSupplyAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "执行";
        }, executorService);
        String response = null;
        try {
            //future.cancel(true);
            //future.join();//主线程阻塞
            //System.out.println("等待线程池执行完成");
            //System.out.println("开始执行时间=="+System.currentTimeMillis()+"=="+ LocalDateTime.now().toString());
            response = future.get(4L, TimeUnit.SECONDS);
            //future.get();
            //response=future.getNow("test");
            logger.info(response);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO thenAccept(Consumer<? super T> action) 执行任务A,A返回值当作任务B的参数，同时任务B不返回值
     * TODO public CompletionStage<Void> thenAccept(Consumer<? super T> action);
     * TODO public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action);
     * TODO public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor);
     * @Date 13:43 2020/3/18
     * @Param []
     **/

    public void thenAcceptTest() {
        CompletableFuture futureB = futureA.thenAcceptAsync(A -> {
            System.out.println("==" + A);
        });
    }

    public static void main(String[] args) {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        completableFutureTest.thenAcceptTest();
    }

    /**
     * @return void
     * @Author cly
     * @Description // TODO thenApplyAsync(Function<? super T,? extends U> fn)--执行任务A,A返回值当作任务B的参数，同时任务B有返回值
     * // TODO public <U> CompletableFuture<U>     thenApply(Function<? super T,? extends U> fn)
     * // TODO public <U> CompletableFuture<U>     thenApplyAsync(Function<? super T,? extends U> fn)
     * // TODO public <U> CompletableFuture<U>     thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
     * @Date 13:53 2020/3/18
     * @Param []
     **/

    @Test
    public void thenApplyTest() {
        CompletableFuture futureB = CompletableFuture.completedFuture("初始参数").thenApplyAsync(A -> {
            return "===" + A;
        });
        try {
            System.out.println(futureB.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO public <U> CompletableFuture<U>     thenCompose(Function<? super T,? extends CompletionStage<U>> fn)
     * //TODO public <U> CompletableFuture<U>     thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn)
     * //TODO public <U> CompletableFuture<U>     thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn, Executor executor)
     * 　　功能:这个方法接收的输入是当前的CompletableFuture的计算值，返回结果将是一个新的CompletableFuture
     * <p>
     * 　　这个方法和thenApply非常像,都是接受上一个任务的结果作为入参,执行自己的操作,然后返回.那具体有什么区别呢?
     * <p>
     * 　　thenApply():它的功能相当于将CompletableFuture<T>转换成CompletableFuture<U>,改变的是同一个CompletableFuture中的泛型类型
     * <p>
     * 　　thenCompose():用来连接两个CompletableFuture，返回值是一个新的CompletableFuture
     * @Date 14:13 2020/3/18
     * @Param []
     **/
    @Test
    public void thenComposeTest() {
        //String s="";
        //CompletableFuture.completedFuture(s);
        CompletableFuture futureB = futureA.thenComposeAsync(A -> CompletableFuture.supplyAsync(() -> {
            return "==" + A;
        }));
        //CompletableFuture futureB=futureA.thenComposeAsync(A->CompletableFuture.supplyAsync(()->"=="+A));
        //CompletableFuture futureC=futureB.thenCompose(B->CompletableFuture.supplyAsync(B::toUpperCase));
        try {
            System.out.println(futureB.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description thenCombine(..)  thenAcceptBoth(..)  runAfterBoth(..)
     * //TODO  public <U,V> CompletableFuture<V>     thenCombine(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
     * //TODO  public <U,V> CompletableFuture<V>     thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
     * //TODO  public <U,V> CompletableFuture<V>     thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn, Executor executor)
     * 功能:结合两个CompletionStage的结果，进行转化后返回
     * <p>
     * 场景:需要根据商品id查询商品的当前价格,分两步,查询商品的原始价格和折扣,这两个查询相互独立,当都查出来的时候用原始价格乘折扣,算出当前价格. 使用方法:thenCombine(..)
     * <p>
     * thenCombine(..)是结合两个任务的返回值进行转化后再返回,
     * 那如果不需要返回呢,那就需要thenAcceptBoth(..),
     * 同理,如果连两个任务的返回值也不关心呢,那就需要runAfterBoth了,
     * 如果理解了上面三个方法,thenApply,thenAccept,thenRun,这里就不需要单独再提这两个方法了,只在这里提一下.
     * @Date 15:08 2020/3/18
     * @Param []
     **/
    @Test
    public void thenCombineTest() {
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> 100d);
        CompletableFuture<Double> futureDiscount = CompletableFuture.supplyAsync(() -> 0.8);
        CompletableFuture<Double> futureResult = futurePrice.thenCombineAsync(futureDiscount, (price, discount) -> price * discount);
        System.out.println("最终价格为:" + futureResult.join()); //最终价格为:80.0
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO applyToEither(..)  acceptEither(..)  runAfterEither(..)
     * //TODO public <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> other,Function<? super T, U> fn);
     * //TODO public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn);
     * //TODO public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn,Executor executor);
     * 功能:执行两个CompletionStage的结果,那个先执行完了,就是用哪个的返回值进行下一步操作
     * 场景:假设查询商品a,有两种方式,A和B,但是A和B的执行速度不一样,我们希望哪个先返回就用那个的返回值.
     * @Date 15:11 2020/3/18
     * @Param []
     **/
    @Test
    public void applyToEitherTest() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式A获取商品a";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式B获取商品a";
        });
        CompletableFuture<String> futureC = futureA.applyToEither(futureB, product -> "结果:" + product);
        System.out.println(futureC.join()); //结果:通过方式A获取商品a
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO public CompletionStage<T> exceptionally(Function<Throwable, ? extends T> fn);
     * 　　功能:当运行出现异常时,调用该方法可进行一些补偿操作,如设置默认值.
     * <p>
     * 　　场景:异步执行任务A获取结果,如果任务A执行过程中抛出异常,则使用默认值100返回.
     * 代码展示了正常流程和出现异常的情况,可以理解成catch
     * @Date 15:13 2020/3/18
     * @Param []
     **/
    @Test
    public void exceptionallyTest() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "futureA result:" + s)
                .exceptionally(e -> {
                    System.out.println(e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        CompletableFuture<String> futureB = CompletableFuture.
                supplyAsync(() -> "执行结果:" + 50)
                .thenApply(s -> "futureB result:" + s)
                .exceptionally(e -> "futureB result: 100");
        System.out.println(futureA.join());//futureA result: 100
        System.out.println(futureB.join());//futureB result:执行结果:50
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO public CompletionStage<T> whenComplete(BiConsumer<? super T, ? super Throwable> action);
     * //TODO public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action);
     * //TODO public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action,Executor executor);
     * 功能:当CompletableFuture的计算结果完成，或者抛出异常的时候，都可以进入whenComplete方法执行
     * <p>
     * 根据控制台,我们可以看出执行流程是这样,supplyAsync->whenComplete->exceptionally,可以看出并没有进入thenApply执行,原因也显而易见,在supplyAsync中出现了异常,
     * thenApply只有当正常返回时才会去执行.而whenComplete不管是否正常执行,还要注意一点,whenComplete是没有返回值的.
     * <p>
     * 注意whenComplete和exceptionally的顺序
     * @Date 15:16 2020/3/18
     * @Param []
     **/
    @Test
    public void whenCompleteTest() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println(s);//未执行
                    }
                    if (e == null) {
                        System.out.println(s);//未执行
                    } else {
                        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                })
                .exceptionally(e -> {
                    System.out.println("ex" + e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());//futureA result: 100
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);
     * //TODO public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn);
     * //TODO public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn,Executor executor);
     * 　　功能:当CompletableFuture的计算结果完成，或者抛出异常的时候，可以通过handle方法对结果进行处理
     * <p>
     * 通过控制台,我们可以看出,最后打印的是handle result:futureA result: 100,执行exceptionally后对异常进行了"美化",返回了默认值,那么handle得到的就是一个正常的返回,
     * 我们再试下,先调用handle再调用exceptionally的情况.
     * @Date 15:18 2020/3/18
     * @Param []
     **/
    @Test
    public void handleTest() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .exceptionally(e -> {
                    System.out.println("ex:" + e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                })
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println(s);//futureA result: 100
                    } else {
                        System.out.println(e.getMessage());//未执行
                    }
                    return "handle result:" + (s == null ? "500" : s);
                });
        System.out.println(futureA.join());//handle result:futureA result: 100
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO
     * 根据控制台输出,可以看到先执行handle,打印了异常信息,并对接过设置了默认值500,exceptionally并没有执行,因为它得到的是handle返回给它的值,由此我们大概推测handle和whenComplete的区别
     * <p>
     * 　　　1.都是对结果进行处理,handle有返回值,whenComplete没有返回值
     * <p>
     * 　　　2.由于1的存在,使得handle多了一个特性,可在handle里实现exceptionally的功能
     * @Date 15:20 2020/3/18
     * @Param []
     **/
    public void handleTest1() {
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println(s);//未执行
                    } else {
                        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                    return "handle result:" + (s == null ? "500" : s);
                })
                .exceptionally(e -> {
                    System.out.println("ex:" + e.getMessage()); //未执行
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());//handle result:500
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO public static CompletableFuture<Void>  allOf(CompletableFuture<?>... cfs)
     * //TODO public static CompletableFuture<Object>  anyOf(CompletableFuture<?>... cfs)
     * <p>
     * allOf:当所有的CompletableFuture都执行完后执行计算
     * <p>
     * 　　anyOf:最快的那个CompletableFuture执行完之后执行计算
     * <p>
     * 　　场景二:查询一个商品详情,需要分别去查商品信息,卖家信息,库存信息,订单信息等,这些查询相互独立,在不同的服务上,假设每个查询都需要一到两秒钟,要求总体查询时间小于2秒.
     * @Date 15:22 2020/3/18
     * @Param []
     **/
    @Test
    public void allofTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Random random = new Random();
        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品详情";
        }, executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "卖家信息";
        }, executorService);

        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "库存信息";
        }, executorService);

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "订单信息";
        }, executorService);

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futureA, futureB, futureC, futureD);
        allFuture.join();

        System.out.println(futureA.join() + futureB.join() + futureC.join() + futureD.join());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }
}
