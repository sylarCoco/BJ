package com.platform.controller;

public  class test {
    public  static test A=null;
    public test(){
        }
        public static final test A(){
          if(A==null){
              synchronized (test.class) {
                  return A = new test();
              }
          }else{
              return A;
          }
        }
}
