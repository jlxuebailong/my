package com.my.common.thinkinginjava.ch17;

import java.util.*;

import static com.my.common.thinkinginjava.util.Print.*;

interface Generator{
    Object next();
}
class Government implements Generator{
    private Object[] foundation = null;
    private int index = 0;
    public Government(Object[] foundation){
        this.foundation = foundation;
    }
    @Override
    public Object next() {
        if(foundation != null && index  < this.foundation.length) {
            return this.foundation[index++];
        }
        return null;
    }
}
class CollectionData extends ArrayList{

    public CollectionData(Generator gen){
        for(Object o = gen.next(); o != null; o = gen.next()){
            add(o);
        }
    }
    public static CollectionData list(Generator gen){
        return new CollectionData(gen);
    }
}

public class Ex02 {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Collections.nCopies(4, 4));
        for(Integer i : list){
            print(i + " ");
        }
        println();
        Collections.fill(list, 5);
        for(Integer i : list){
            print(i + " ");
        }
        println();

        Object[] foundation = ("Strange women lying in ponds distributing swords " +
                "is no basis for a system of government").split(" ");

        Set set = new LinkedHashSet(new CollectionData(new Government(foundation)));
        println(set);

        foundation = ("100 pieces cat mouse is less than before you`ll never walk alone").split(" ");
        set.addAll(CollectionData.list(new Government(foundation)));
        println(set);
    }
}
