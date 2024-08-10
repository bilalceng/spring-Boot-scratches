package com.bilalberek.demo.mapper;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
class StudentMapperTest {
  @BeforeAll
  static void beforeAll(){
    System.out.println("Before all worked");
  }
  @BeforeEach
   void setUp(){
    System.out.println("Before each worked");
  }

  @AfterEach
   void tearDown(){
    System.out.println("After each worked");
  }

  @AfterAll
  static void afterAll(){
    System.out.println("After all worked");
  }
@Test
  public void testMethod(){
  System.out.println("TEST METHOD all worked");
  }

  @Test
  public void testMethod2(){
    System.out.println("TEST METHOD1 all worked");
  }
  @Test
  public void testMethod3(){
    System.out.println("TEST METHOD2 all worked");
  }
}