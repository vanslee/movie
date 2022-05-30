package com.ldx.endingwork;

import org.junit.jupiter.api.Test;

public class DemoTest1 {
    @Test
    public void test01(){
        System.out.println("\"     XX       \".trim() = " + "  XX ".trim());
    }
    @Test
    public void test02() {
            Object msg = true;
            if(boolean.class.isInstance(msg)) System.out.println("dsada");
        System.out.println("12313123");
    }
}
