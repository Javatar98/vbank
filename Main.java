package vbank;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {
	public static Hashtable<String, Integer> clients = new Hashtable<String, Integer>();
	
	public static int getBalance(String key) {
		return clients.get(key);
	}
	
	public static void transaction(String keyFrom, String keyTo, int amount) {
		clients.put(keyFrom, clients.get(keyFrom) - amount);
		clients.put(keyTo, clients.get(keyTo) + amount);
		System.out.println("Tttransaction done!");
	}
	public static void reg() {
		System.out.println("please insert a key for example an email or phone number:");
		Scanner s = new Scanner(System.in);
		String key = s.next();
		clients.put(key, 0);
		System.out.println("Registration succesful!");
	}
	
	public static void main(String[] args) {
		String input;
		Scanner s = new Scanner(System.in);
		// TODO Auto-generated method stub
		do {
		System.out.println("Welcome to vbank!");
		System.out.println("Insert reg for registration.");
		System.out.println("Insert transaction to make a transaction.");
		System.out.println("Insert balance to get balance.");
		System.out.println();
		input = s.next();
		if(input.equals("reg")) reg();
		if(input.equals("balance")) {
			System.out.println("Enter the key:");
			String key = s.next();
			System.out.println(getBalance(key));
		}
		if(input.equals("transaction")) {
			System.out.println("Insert the sender key");
			String skey = s.next();
			System.out.println("insert recipient key");
			String rkey = s.next();
			System.out.println("Insert the amount to send");
			int amount = s.nextInt();
			transaction(skey, rkey, amount);
			System.out.println("Transaction is done!");
		}
		} while(input != "exit");
	}

}
