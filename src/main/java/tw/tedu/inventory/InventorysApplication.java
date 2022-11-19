package tw.tedu.inventory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;

@SpringBootApplication
@Configuration
@MapperScan("tw.tedu.inventory.mapper")
public class InventorysApplication {

    public static void main(String[] args) throws FileNotFoundException {

        SpringApplication.run(InventorysApplication.class,args);



    }
}
