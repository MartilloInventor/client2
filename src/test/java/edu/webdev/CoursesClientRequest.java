package edu.webdev;

/**
 * Created by algotrader on 6/3/17.
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import javax.ws.rs.core.MultivaluedMap; // the locations of these classes are weird

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoursesClientRequest {
    private static final Logger logger = LoggerFactory.getLogger(CoursesClientRequest.class);
    static Client client = null; // must be non-null and unchangeable
    final static String applicationServiceURI = "http://localhost:8080/api/";
    final static Random generator = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int nummodified = 0;
        int balance = 0;
        List<Account> accts = null;
        Account account = null;
        logger.info("Starting the test client");
        System.out.println("Class Path is " + System.getProperty("java.class.path"));
        initializeClient();
        try {
            logger.info("Testing the health methods");
            System.out.println( getInterviewVersion() );
            System.out.println( getInterviewPostgresVersion() );
            System.out.println( sendInterviewPing() );

            account = getInterviewAccount( "1" );
            if (account == null) {
                System.out.println( "account 1 was not found" );
            } else {
                System.out.println( "Found the following:\n\tID:\t"+ account.getId() + "\tBalance:\t" + account.getBalance());
            }

            account = getInterviewAccount( "4" );
            if (account == null) {
                System.out.println( "account 4 was not found" );
            } else {
                System.out.println( "Found the following:\n\tID:\t"+ account.getId() + "\tBalance:\t" + account.getBalance());
            }

            System.out.println("Account 3 has balance: " + getInterviewAccountBalance("3"));

            logger.info("dump all the accounts");
            accts = getInterviewAccount();
            if (accts == null) {
                System.out.println( "No accounts were found" );
            } else {
                System.out.println( "Found the following:");
                for(Account a: accts) {
                    System.out.println("\tID:	" + a.getId() + "\tBalance:\t" + a.getBalance());
                }
            }

            logger.info("methods to modify accounts");
            System.out.println( "*Transfer of 5 cents from account 1 to account 4 has " +
                    makeTransfer( "1", "4", 5 ) );

            System.out.println("Resetting account\n\t" + setInterviewAccountBalance(new Integer(generator.nextInt(25)).toString(), generator.nextInt(2500)) + " records modified");

            System.out.println("Updating account\n\t" + addInterviewAccountBalance("2", generator.nextInt(100) - 50).toString() + " records modified");

            logger.info("dump all the accounts");
            accts = getInterviewAccount();
            if (accts == null) {
                System.out.println( "No accounts were found" );
            } else {
                System.out.println( "Found the following:");
                for(Account a: accts) {
                    System.out.println("\tID:	" + a.getId() + "\tBalance:\t" + a.getBalance());
                }
            }

            logger.info("methods to modify accounts via v2 methods");
            System.out.println( "*Transfer of 7 cents from account 3 to account 2 is " +
                    makeTransferV2( "3", "2", 7 ) );

            System.out.println("Resetting account\n\t" + "Record modification is " + setInterviewAccountBalanceV2(new Integer(generator.nextInt(25)).toString(), generator.nextInt(2500)));

            System.out.println("Updating account\n\t" + "Record modification is " + addInterviewAccountBalanceV2("3", generator.nextInt(100) - 50));

            logger.info("dump all the accounts");
            accts = getInterviewAccount();
            if (accts == null) {
                System.out.println( "No accounts were found" );
            } else {
                System.out.println( "Found the following:");
                for(Account a: accts) {
                    System.out.println("\tID:	" + a.getId() + "\tBalance:\t" + a.getBalance());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println( "Something went wrong!" );
        }
    }

    /* here is where the client api starts */
    static public void initializeClient() {
        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        client = Client.create(defaultClientConfig);
    }
}
