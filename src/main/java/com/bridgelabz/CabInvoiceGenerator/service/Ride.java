package com.bridgelabz.CabInvoiceGenerator.service;

public class Ride {
    public final double distance;
    public final int time;
    public  String rideType;
    public  String userId;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
    public Ride(double distance, int time, String userId,String rideType) {
        this.distance = distance;
        this.time = time;
        this.userId = userId;
        this.rideType=rideType;
    }
}
