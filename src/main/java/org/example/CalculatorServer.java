package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer extends UnicastRemoteObject implements Calculator {

    protected CalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculator", server);
            System.out.println("Calculator Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
