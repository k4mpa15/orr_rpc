package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator stub = (Calculator) registry.lookup("Calculator");
            int result = stub.add(5, 3);
            System.out.println("Result of 5 + 3 is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
