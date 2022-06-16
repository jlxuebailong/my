package org.my.def;

@FunctionalInterface
public interface INewCharacter {

    /**
     * 当接口中只有一个未实现方法时，
     * 则在使用该接口的地方，可以使用lambda表达式来代替实现类
     */
    void test1();

    default void test2(){
        System.out.println("Test 2....");
    }

}
