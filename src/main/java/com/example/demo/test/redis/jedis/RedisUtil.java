package com.example.demo.test.redis.jedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 存储key命名规则：
 * user.doctor.123456
 * 
 * @author wanghc
 *
 */
public class RedisUtil {
	//Redis服务器IP
    private static String ADDR = "127.0.0.1";
    //Redis的端口号
    private static int PORT = 6379;
    //访问密码
    private static String AUTH = "chen";
     //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 2048;
     //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 500;
     //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;
    private static final Long RELEASE_SUCCESS = 1L;
     /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            //config.setMaxActive(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            //config.setMaxWait(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
         } catch (Exception e) {
           e.printStackTrace();
       }
   }
     /**
    * 获取Jedis实例
    * @return
      */
     public synchronized static Jedis getJedis() {
         try {
             if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                 return resource;
             } else {
                 return null;
            }
         } catch (Exception e) {
            e.printStackTrace();
             return null;
        }
    }


     /**
      * 重复key 多值
      */
     public static void lpush(String key,String... value){
    	 Jedis jedis = getJedis();
    	 
    	 //设置失效时间  在这里直接设置
    	 jedis.lpush(key, value);
    	 returnResource(jedis);
     }
     
     public static String rpop(String key){
    	 Jedis jedis = getJedis();
    	 
    	 String rpop = jedis.rpop(key);
    	 returnResource(jedis);
    	 return rpop;
     }
     
     public static void lpush(String key, Integer timeout, String... value){
    	 Jedis jedis = getJedis();
    	 //设置失效时间  在这里直接设置
    	  
    	 jedis.lpush(key, value);
    	 jedis.expire(key, timeout); 	
    	 returnResource(jedis);
    	 
     }
     
     /**
      * 获取
      */
     public static List<String> getPush(String key){
    	 List<String> list = new ArrayList<String>();
    	 Jedis jedis = getJedis();
    	 list = jedis.lrange(key, 0, -1);
    	 returnResource(jedis);
    	 return list;
     }
     /**
      * 移除
      */
     public static void del(String key){
    	 Jedis jedis = getJedis();
    	 jedis.del(key);
    	 returnResource(jedis);
    	 
     }
     /**
     * 释放jedis资源
     * @param jedis
      */
     public static void returnResource(final Jedis jedis) {
         if (jedis != null) {
            jedisPool.returnResource(jedis);

        }
     }
    /**
     * 添加永久性对象
     * 已存在的话直接覆盖
     */
     public static void add(String key,String value){
    	 Jedis jedis = getJedis();
    	 jedis.set(key, value);
    	 returnResource(jedis);
     }
     
     /**
      * 只在键 key 不存在的情况下， 将键 key 的值设置为 value 。
      * 若键 key 已经存在， 则 SETNX 命令不做任何动作。
      * 相当于setnx
      */
      public static Long addnx(String key,String value){
     	 Jedis jedis = getJedis();
     	 Long setnx = jedis.setnx(key, value);
     	 returnResource(jedis);
     	 return setnx;
      }
     
     /**
      * 添加有时间的对象
      * long 以秒为单位
      * 失效以后再取的话为null 
      */
     public static void add(String key,String value,int secs){
    	 Jedis jedis = getJedis();
    	 //设置带失效时间的key 
    	 jedis.setex(key,secs, value);
    	 returnResource(jedis);
     }
     /**
      * 取数据 不存在的话返回null
      * @return
      */
     public static String get(String key){
    	 String ret = null;
    	 Jedis jedis = getJedis();
    	 ret = jedis.get(key);
    	 returnResource(jedis);
    	 return ret;
     }
     
     /**
      * 监视一个(或多个) key ，如果在事务执行之前这个(或这些) key 被其他命令所改动，那么事务将被打断。
      * @date 2019年2月25日上午11:40:10
      * @param key
      * @return
      */
     public static String watchKey(String... key){
    	 String ret = null;
    	 Jedis jedis = getJedis();
    	 ret = jedis.watch(key);
    	 returnResource(jedis);
    	 return ret;
     }
     
     /**
      * 判断key值是否存在
      * @param key
      * @return
      */
     public static boolean exists(String key){
    	 boolean bl = false;
    	 Jedis jedis = getJedis();
    	 bl = jedis.exists(key);
    	 returnResource(jedis);
    	 return bl;
     }
     
     /**
      * 获取key的过期时间
      * @param key
      * @return
      */
     public static Long getTtl(String key){
    	 Jedis jedis = getJedis();
    	 Long ttl = jedis.ttl(key);
    	 returnResource(jedis);
    	 return ttl;
     }
     
     public static Boolean expire(String key,int secs){
    	 Boolean result =false;
    	 Jedis jedis = getJedis();
    	 //设置带失效时间的key 
    	 if(jedis!=null){
    		 jedis.expire(key, secs);
    		 returnResource(jedis);
    		 result = true;
    	 }
    	 return result;
     }
     
     public static List<String> getValues(String[] keys){
    	 List<String> ret = null;
    	 Jedis jedis = getJedis();
		 if(jedis!=null){
			 ret = jedis.mget(keys);
			 returnResource(jedis);
		 }
		 return ret;
     }
     
     public static Set<String> getKeyByPrefix(String keyPrefix){
    	 Set<String> keys = null;
    	 Jedis jedis = getJedis();
    	 if(jedis != null){
    		 keys = jedis.keys(keyPrefix);
    		 returnResource(jedis);
    	 }
    	 return keys;
     }
     /**
     * @Description //TODO 获取分布式锁
     **/
     public static String lock(String key,String value,Long time){
         Jedis jedis = getJedis();
         String data=jedis.set(key,value,"NX","PX",time);
         return data;
     }
     public static String unLock(String key,String value){
         Jedis jedis = getJedis();
         String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
         Object  data=jedis.eval(script,Collections.singletonList(key), Collections.singletonList(value));
         if(RELEASE_SUCCESS.equals(data)){
             return "succss";
         }
         return "false";
     }
     public static void main(String[] args) {
    	 String accessToken = "uc.u.t.177854237c9592b0fc45daef13124f41";
    	 int personId = 115;
    	 int facilityId = 105;
		RedisUtil.lpush(accessToken, String.valueOf(personId), String.valueOf(facilityId));
		List<String> rerr = RedisUtil.getPush(accessToken);
		
		
		System.out.println(rerr);
    	 Jedis jedis = getJedis();
    	 jedis.expire("foo",5);
    	 String messageKey = "massage.1.8.7";
    	 jedis.del(messageKey);
    	 jedis.lpush(messageKey, "17","16");
    	 List<String> ret = jedis.lrange(messageKey,0,-1);
    	 System.out.println(ret);
/*    	// Jedis jedis = getJedis();
    	 //jedis.expire("foo", 5); 8 7String messageKey = "massage.1.8.7";
//    	 String messageKey = "massage.1.8.7";
//    	 jedis.lpush(messageKey, "17","16");
    	 //jedis.lpush("consultation.8", "7","1","2");
    	// Map<String, String> map = jedis.hgetAll("test_test");
    	 //jedis.del("consultation.8");
//    	 String key = "seng_msgImage_7";
//    	 del(key);
    	// System.out.println(list.size());
    	 //System.out.println(jedis.get("user.accessToken.d155d91387db9f0db7d5007d0b423e6c"));//取出所有
    	// returnResource(jedis);
*/	}
}
