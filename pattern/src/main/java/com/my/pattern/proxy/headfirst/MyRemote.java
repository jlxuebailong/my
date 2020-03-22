package com.my.pattern.proxy.headfirst;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by gavin on 2020/3/21.
 */
public interface MyRemote extends Remote{

    String sayHello() throws RemoteException;
}
