package com.bridgelabz.CabInvoiceGenerator.service;

public class Ride {
    public final double distance;
    public final int time;
    public  String userId;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, int time, String userId) {
        this.distance = distance;
        this.time = time;
        this.userId = userId;
    }
}
