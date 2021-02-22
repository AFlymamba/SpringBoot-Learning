package com.springboot.rbac;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huangyin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OtherTest {
    @Test
    public void testMethodA() {
        boolean result = jundgeMethodA();
        System.out.println("结果值为：" + result);
    }

    private boolean jundgeMethodA() {
        if (jundgeMethodB()) {
            System.out.println("false");
            return false;
        }
        return true;
    }

    private boolean jundgeMethodB() {
        return false;
    }
}
