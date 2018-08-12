package com.example.springbootcache.service.impl;

import com.example.springbootcache.dao.EmployeeDao;
import com.example.springbootcache.entity.Employee;
import com.example.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp")//所有缓存value都是emp 缓存公共配置
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /*
     * CacheManager管理多个Cache组件的，对缓存的真正crud操作在Cache组件中，每一个缓存又自己唯一一个名字
     * @Cacheable开启缓存,调用方法
     * @cacheNames/value：指定缓存的名字,将方法的返回结果放在哪个缓存，是数组的方式，可以指定多个缓存
     *       key：缓存数据使用的key，可以用它来指定，默认是使用方法参数的值 1-方法的返回值
     *              编写SpeL:#id 参数id的值  #a0 #p0 #root.args[0]
     *       keyGenerator:key的生成器，可以自己指定key的生成器的组件的id
     *              key/keyGenerator:二选一使用
     *       cacheManager:指定缓存管理器；或者cacheResolver指定获取解析器
     *       condition:指定符合条件的情况下才缓存
     *       unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *       sync:是否使用异步模式 sync不支持unless
     *
     * */

    /*
     * @Cacheable标注的方法执行之前先来检查缓存中没有这个数据，默认按照参数的值作为key去查询，
     * 如果没有就运行方法并将结果放入缓存
     * */
    @Override
    @Cacheable(key = "'id:'+#id", condition = "#id>0", unless = "#result==null")
//    @Cacheable(value = {"emp"}, keyGenerator = "myKeyGenerator", condition = "#id>0", unless = "#result==null")
    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "号员工");
        return employeeDao.getEmpById(id);
    }

    /*
     * @CachePut:缓存更新
     * 既调用方法，又跟新缓存数据
     * 修改了数据库的某个数据，同时跟新缓存
     * 运行时机：
     *   1、先调用目标方法
     *   2、将目标方法的结果缓存起来
     * */
    @Override
    @CachePut(key = "'id:'+#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("跟新" + employee.getId() + "号员工");
        return employeeDao.updateEmp(employee);
    }

    /*
     * @CacheEvict:缓存清楚
     * key:指定要清楚的数据
     * allEntries = true 指定清楚缓存中的所有数据
     * beforeInvocation = false 缓存的清除是否在方法之前执行
     *   默认代表是在方法执行之后执行，如果出现异常缓存就不会清除
     * */
    @Override
    @CacheEvict(key = "'id:'+#id")
    public void deleteEmp(Integer id) {
        System.out.println("删除" + id + "号员工");
        employeeDao.deleteEmp(id);
    }

    /*
     * @Caching定义复杂注解
     * */
    @Override
    @Caching(
            cacheable = {
                    @Cacheable(key = "'lastName:'+#lastName")
            },
            put = {
                    @CachePut(key = "'id:'+#result.id"),
                    @CachePut(key = "'email:'+#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeDao.getEmpByLastName(lastName);
    }
}

/*
 *       原理：
 *       1、自动配置类：CacheAutoConfiguration
 *       2、缓存的配置类 ...
 *       3、哪个配置类默认生效：SimpleCacheConfiguration
 *       4、给容器中注册一个CacheManager:ConcurrentMapCacheManager
 *       5、可以获取和创建ConcurrentMapCache类型的缓存组件；它的作用将数据保存在ConcurrentMap中
 *
 *       运行流程：
 *       @Cacheable:
 *       1、方法运行之前，先去查询Cache(缓存组件)，按照cacheNames指定的名字获取；
 *          （CacheManager先获取响应的缓存）
 *       2、去Cache中查询缓存的内容，使用一个key，默认就是方法的参数
 *           key是按照默认某种策略生成的，默认使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key
 *              SimpleKeyGenerator生成key的默认策略：
 *                  如果没有参数：key=new SimpleKey();
 *                  如果有一个参数：key=参数的值
 *                  如果有多个参数：key=new SimpleKey(params)
 *       3、没有查到缓存就调用目标方法
 *       4、将目标方法返回的结果，放进缓存中
 *
 *    核心：
 *    1、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件，保存数据的中心
 *    2、key使用keyGenerator生成，默认是SimpleKeyGenerator
 */