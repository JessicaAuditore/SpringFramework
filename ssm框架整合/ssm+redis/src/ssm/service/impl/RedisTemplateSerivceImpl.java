package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import ssm.service.RedisTemplateService;

import java.util.List;

public class RedisTemplateSerivceImpl implements RedisTemplateService {

    @Autowired
    private RedisTemplate redisTemplate = null;

    /*
     * 使用SessionCallback接口实现多个命令在一个Redis连接中执行
     * */
    @Override
    public void execMultiCommand() {
        //使用java8 lambda表达式
//        Object obj = redisTemplate.execute((RedisOperations ops) -> {
//            ops.boundValueOps("key1").set("abc");
//            ops.boundHashOps("hash").put("hash-key-1", "hash-value-1");
//            return ops.boundValueOps("key1").get();
//        });
//        System.err.println(obj);
    }

    /*
     * 使用SessionCallback接口事务在一个Redis连接中执行
     * */
    @Override
    public void execTransaction() {
//        List list = (List) redisTemplate.execute((RedisOperations ops) -> {
//            //监控
//            ops.watch("key1");
//            //开启事务
//            ops.multi();
//            //注意，命令都不会被马上执行，只会放到Redis的队列中，只会返回为null
//            ops.boundValueOps("key1").set("abc");
//            ops.boundHashOps("hash").put("hash-key-1", "hash-value-1");
//            ops.opsForValue().get("key1");
//            //执行exec方法后会触发事务执行，返回结果，存放到list中
//            List result = ops.exec();
//            return result;
//        });
//        System.err.println(list);
    }

    /*
     * 执行流水线，将多个命令一次性发给Redis服务器
     * */
    @Override
    public void execPipeline() {
        //使用匿名类实现
        List list = redisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                //在流水线下，命令不会马上返回结果，结果是一次性执行后返回的
                ops.opsForValue().set("key1", "value1");
                ops.opsForHash().put("hash", "key-hash-1", "value-hash-1");
                ops.opsForValue().get("key1");
                return null;
            }
        });
        System.err.println(list);
    }
}
