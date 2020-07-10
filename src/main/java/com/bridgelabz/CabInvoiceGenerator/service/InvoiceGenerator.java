package com.bridgelabz.CabInvoiceGenerator.service;

import java.util.HashMap;

public class InvoiceGenerator {
    public static final double MINIMUM_COST_PER_KILOMETER = 10;
    public static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    public  static HashMap<String, Double> hashMap = new HashMap<>();

    /**
     * Fare Calculator
     *
     * @param distance
     * @param time
     * @return
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Multiple Rides Calculator
     *
     * @param rides
     * @return
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Calculate Total Invoice
     * @param rides
     * @param userIdentity
     * @return
     */
    public Double calculateTotalInvoice(Ride[] rides, String userIdentity) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare = this.calculateFare(ride.distance, ride.time);
            if (hashMap.containsKey(ride.userId))
                totalFare +=hashMap.get(ride.userId);
            hashMap.put(ride.userId,totalFare);
        }
        return hashMap.get(userIdentity);
    }
}
