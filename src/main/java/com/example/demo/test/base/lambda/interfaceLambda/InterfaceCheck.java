package com.example.demo.test.base.lambda.interfaceLambda;

import java.util.function.Predicate;

public  class InterfaceCheck {
      public  boolean check(Predicate<Integer> predicate){
          return false;
      }
    public boolean check(IntPred predicate){
          return false;
     }
}
