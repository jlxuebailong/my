package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/20.
 */
public class Ex02 {

    final class ANumberType extends Number{
        private final int value;

        public ANumberType(int value) {
            this.value = value;
        }

        @Override
        public int intValue() {
            return value;
        }

        @Override
        public long longValue() {
            return (long)value;
        }

        @Override
        public float floatValue() {
            return (float)value;
        }

        @Override
        public double doubleValue() {
            return (double)value;
        }

        public int getValue(){
            return this.value;
        }
    }

    public ANumberType buildANumberType(int value){
        return new ANumberType(value);
    }

    public static void main(String[] args){
        Ex02  ex = new Ex02();
        ANumberType aNumberType = ex.buildANumberType(4);
        System.out.println(aNumberType.getValue());
    }
}
