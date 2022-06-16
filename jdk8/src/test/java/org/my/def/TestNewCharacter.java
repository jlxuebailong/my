package org.my.def;

public class TestNewCharacter {

    private static void t1(INewCharacter nc){
        nc.test1();
    }

    private static void methodRef(){
        //方法引用
        IConvertor<String, Integer> convertor = Integer :: valueOf;
        Integer n = convertor.convert("1");
        System.out.println(n);

        //同样可以使用lambda的方法来实现
        IConvertor<String, Integer> convertor1 = ( s ) -> Integer.valueOf(s);
        Integer m = convertor1.convert("5");
        System.out.println(m);
    }

    public static void main(String[] args) {
        methodRef();

        INewCharacter newCharacter1 = new INewCharacter() {
            @Override
            public void test1() {
                System.out.println("0000000000000");
            }
        };
        newCharacter1.test1();

        //执行接口默认实现方法
        newCharacter1.test2();

        //使用lambda简化对test1方法的实现
        t1(()->{
            System.out.println(1111111);
        });
        //同上
        INewCharacter newCharacter2 = () -> {
            System.out.println(333333333);
        };

        newCharacter2.test1();


    }

}
