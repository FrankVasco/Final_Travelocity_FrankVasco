package travelocity.DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="FlightDetails")
    public Object[][] FlightDetails(){
        Object [][] details = new Object[1][2];
        {
            details[0][0] = "LAS";
            details[0][1] = "LAX";
        }
        return details;
    }


    @DataProvider(name="InputData")
    public Object[] getDate(){
        Object [] data = new Object[4];

        data[0]="PRICE_INCREASING";
        data[1]="DURATION_INCREASING";
        data[2]="DEPARTURE_INCREASING";
        data[3]="ARRIVAL_INCREASING";

        return data;
    }





}
