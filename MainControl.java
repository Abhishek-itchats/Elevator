package com.Elevator.java;

import java.util.Scanner;

public class MainControl {
	    public static void main(String[] args) {
	        Elevator elevator = new Elevator(10); // assuming the building has 10 floors
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Enter floor number to request elevator (-1 to quit): ");
	            int requestedFloor = scanner.nextInt();

	            if (requestedFloor == -1) {
	                break;
	            } else if (requestedFloor < 0 || requestedFloor > 10) {
	                System.out.println("Invalid floor. Please enter a floor between 0 and 10.");
	            } else {
	                elevator.addRequest(requestedFloor);
	            }

	            elevator.processNextRequest();
	        }

	        scanner.close();
	    }
	}


