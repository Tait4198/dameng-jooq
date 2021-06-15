package org.example.dm;

import org.example.dm.tables.records.TableTestRecord;
import org.jooq.DSLContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import static org.example.dm.tables.TableTestTable.TABLE_TEST;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class Application implements CommandLineRunner {

    private final DSLContext dslContext;

    public Application(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TableTestRecord tableTestRecord = dslContext.newRecord(TABLE_TEST);
        tableTestRecord.setName("NameName");
        tableTestRecord.setContent("内容内容内容");
        tableTestRecord.insert();

        int count = dslContext.selectCount()
                .from(TABLE_TEST)
                .fetchOne()
                .value1();
        System.out.println(count);
    }
}