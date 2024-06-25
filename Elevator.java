package com.Elevator.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private int currentFloor;
    private int totalFloors;
    private Direction currentDirection;
    private Queue<Integer> upRequests;
    private Queue<Integer> downRequests;

    public Elevator(int totalFloors) {
        this.currentFloor = 0;
        this.totalFloors = totalFloors;
        this.currentDirection = Direction.IDLE;
        this.upRequests = new PriorityQueue<>();
        this.downRequests = new PriorityQueue<>((a, b) -> b - a);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void moveUp() {
        if (currentFloor < totalFloors) {
            currentFloor++;
        }
    }

    public void moveDown() {
        if (currentFloor > 0) {
            currentFloor--;
        }
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upRequests.add(floor);
        } else if (floor < currentFloor) {
            downRequests.add(floor);
        }
    }

    public void processNextRequest() {
        if (currentDirection == Direction.UP || currentDirection == Direction.IDLE) {
            if (!upRequests.isEmpty()) {
                int targetFloor = upRequests.poll();
                while (currentFloor < targetFloor) {
                    moveUp();
                    System.out.println("Moving up to floor: " + currentFloor);
                }
            } else if (!downRequests.isEmpty()) {
                currentDirection = Direction.DOWN;
            }
        }

        if (currentDirection == Direction.DOWN) {
            if (!downRequests.isEmpty()) {
                int targetFloor = downRequests.poll();
                while (currentFloor > targetFloor) {
                    moveDown();
                    System.out.println("Moving down to floor: " + currentFloor);
                }
            } else if (!upRequests.isEmpty()) {
                currentDirection = Direction.UP;
            }
        }

        if (upRequests.isEmpty() && downRequests.isEmpty()) {
            currentDirection = Direction.IDLE;
        }
    }
}

