package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/20.
 */
public class Ex02 {

    class ATypeName {
        private double value;
        public ATypeName(){}
        public ATypeName(double value) {
            this.value = value;
        }
        public double getValue(){
            return Math.round(this.value);
        }
    }

    public ATypeName buildATypeName(double value){
        return new ATypeName(value);
    }

    public static void main(String[] args){
        Ex02  ex = new Ex02();
        ATypeName typeName = ex.buildATypeName(0.3d);
        System.out.println(typeName.getValue());
    }
}
