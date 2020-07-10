import com.bridgelabz.CabInvoiceGenerator.service.InvoiceGenerator;
import com.bridgelabz.CabInvoiceGenerator.service.InvoiceSummary;
import com.bridgelabz.CabInvoiceGenerator.service.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void init() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
    @Test
    public void givenMultipleRides_AndGivenUserId_ShouldReturnInvoiceAndListOfRide() {
        Ride[] rides = {new Ride(2.0, 5,"raj"),
                        new Ride(2.0, 5,"raj"),
                        new Ride(0.1, 1,"raj"),
                        new Ride(0.1, 1,"sham")};
        double totalInvoice = invoiceGenerator.calculateTotalInvoice(rides,"raj");
        Assert.assertEquals(55,totalInvoice,0.0);
    }
}
