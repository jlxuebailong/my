package com.my.pattern.proxy.headfirst;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by gavin on 2020/3/21.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {
        super();
    }


    @Override
    public String sayHello() throws RemoteException{
        return "Server says, 'Hey'";
    }

    public static void main(String[] args) {
        System.out.println("Naming.....");
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
