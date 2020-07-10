package com.bridgelabz.CabInvoiceGenerator.service;

import java.util.HashMap;

public class InvoiceGenerator {
    public static final double NORMAL_COST_PER_KILOMETER = 10;
    public static final int NORMAL_COST_PER_TIME = 1;
    public static final double PREMIUM_COST_PER_KILOMETER = 15;
    public static final int PREMIUM_COST_PER_TIME = 2;
    private static final double PREMIUM_RIDE_MINIMUM_FARE = 20;
    private static final double NORMAL_RIDE_MINIMUM_FARE = 5;
    public static HashMap<String, Double> hashMap = new HashMap<>();

    /**
     * Fare Calculator
     *
     * @param distance
     * @param time
     * @return
     */
    public double calculateFare(double distance, int time, String rideType) {
        if (rideType.contains("premium")) {
            double totalFare = distance * PREMIUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
            return Math.max(totalFare, PREMIUM_RIDE_MINIMUM_FARE);
        }
        double totalFare = distance * NORMAL_COST_PER_KILOMETER + time * NORMAL_COST_PER_TIME;
        return Math.max(totalFare, NORMAL_RIDE_MINIMUM_FARE);
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
            totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
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
            totalFare = this.calculateFare(ride.distance, ride.time, ride.rideType);
            if (hashMap.containsKey(ride.userId))
                totalFare +=hashMap.get(ride.userId);
            hashMap.put(ride.userId,totalFare);
        }
        return hashMap.get(userIdentity);
    }
}
