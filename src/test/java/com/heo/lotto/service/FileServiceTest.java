package com.heo.lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class FileServiceTest {
    FileService fs = new FileService(new DateService());
    
    @Test
    public void getUUIDTest(){
        String str = fs.getUUID();
        System.out.println("str : " + str);
    
        assertNotEquals("test", str);
    }

    @Test
    public void getGameNoTest(){
        String str = fs.getGameNo();
        System.out.println(str);

        assertEquals(14, str.length());
    }
}
