package org.my.def;

@FunctionalInterface
public interface IConvertor <S, T>{
    T convert(S s);
}
