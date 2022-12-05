package homework.ultimatemall;

import homework.ultimatemall.common.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
//@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement
public class UltimateMallApplication {

    public static void main(String[] args) {
        BaseContext.setCurrentId(1599423857683345409L);
        SpringApplication.run(UltimateMallApplication.class, args);
        log.info("项目启动成功...,当前用户id:{}", BaseContext.getCurrentId());
    }

}
