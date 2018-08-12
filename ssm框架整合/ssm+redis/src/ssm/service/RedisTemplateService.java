package ssm.service;

public interface RedisTemplateService {

    /*
    * 执行多个命令
    * */
    public void execMultiCommand();

    /*
    * 执行Redis事务
    * */
    public void execTransaction();

    /*
    * 执行Redis流水线
    * */
    public void execPipeline();
}
