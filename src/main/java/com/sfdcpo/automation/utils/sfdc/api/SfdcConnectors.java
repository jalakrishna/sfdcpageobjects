package com.sfdcpo.automation.utils.sfdc.api;
import java.util.Random;
import com.sforce.soap.partner.Error;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SfdcConnectors {

    public static void main(String[] args) throws ConnectionException {

        ConnectorConfig config = new ConnectorConfig();
            config.setAuthEndpoint("https://na174.salesforce.com//services/Soap/u/38.0/");
            config.setUsername("RealTimeProject@realtimeproject.com");
            config.setPassword("Sales234XXXXXXXXX");
        PartnerConnection connectionAsAdmin = new PartnerConnection(config);
        System.out.println("ConnectionString:  " + connectionAsAdmin.toString());
        SObject[] leads = new SObject[1];
        SObject lead = new SObject();
        int randomNumb = new Random().nextInt();
            lead.setType("Lead");
            lead.setField("LastName", Integer.toString(randomNumb).substring(1) + "-Lead-API-");
            lead.setField("Company", "Prospect");
            leads[0] = lead;
        // SObject accountURN = accounts[0];
        SaveResult[] results = connectionAsAdmin.create(leads);
        SaveResult[] result = results;

        for (int i = 0; i < result.length; i++) {
            if (result[i].isSuccess()) {
                String recordId = result[i].getId();
                System.out.println(recordId);
            } else {
                for (int j = 0; j < result[i].getErrors().length; i++) {
                    Error error = result[i].getErrors()[j];
                    error.getStatusCode();
                    error.getMessage();
                }
            }

        }
}
}