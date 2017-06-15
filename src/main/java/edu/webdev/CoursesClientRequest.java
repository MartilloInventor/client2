package edu.webdev;

/**
 * Created by algotrader on 6/3/17.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CoursesClientRequest {
    private static final Logger logger = LoggerFactory.getLogger( CoursesClientRequest.class );
    static Client client = null;
    final static String applicationServiceURI = "http://localhost:3000/courses"; // should be configurable

    public static void main(String[] args) {
        logger.info( "Starting the test client" );
        System.out.println( "Class Path is " + System.getProperty( "java.class.path" ) );

        initializeClient();

        try {
            logger.info( "curl 'http://localhost:3000/courses/area/Cs' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/area/Cs' -H 'Content-Type: application/json'" );
            sendGetRequest( "/area/CS" );

            logger.info( "curl 'http://localhost:3000/courses/area/Ac' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/area/Ac' -H 'Content-Type: application/json'" );
            sendGetRequest( "/area/Ac" );

            logger.info( "curl 'http://localhost:3000/courses/area/AD' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/area/AD' -H 'Content-Type: application/json'" );
            sendGetRequest( "/area/AD" );

            logger.info( "curl 'http://localhost:3000/courses/area/*' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/area/*' -H 'Content-Type: application/json'" );
            sendGetRequest( "/area/*" );

            logger.info( "curl 'http://localhost:3000/courses/area/C' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/area/C' -H 'Content-Type: application/json'" );
            sendGetRequest( "/area/C" );

            logger.info( "curl 'http://localhost:3000/courses/instructor/Barbara' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/instructor/Barbara' -H 'Content-Type: application/json'" );
            sendGetRequest( "/instructor/Barbara" );

            logger.info( "curl 'http://localhost:3000/courses/instructor/Da' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/instructor/Da' -H 'Content-Type: application/json'" );
            sendGetRequest( "/instructor/Da" );

            logger.info( "curl 'http://localhost:3000/courses/instructor/ixzy' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/instructor/ixzy' -H 'Content-Type: application/json'" );
            sendGetRequest( "/instructor/ixzya" );

            logger.info( "curl 'http://localhost:3000/courses/instructor/*' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/instructor/*' -H 'Content-Type: application/json'" );
            sendGetRequest( "/instructor/*" );

            logger.info( "curl 'http://localhost:3000/courses/instructor/z' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/instructor/z' -H 'Content-Type: application/json'" );
            sendGetRequest( "/instructor/z" );

            logger.info( "curl 'http://localhost:3000/courses/instructor/q' -H 'Content-Type: application/json'" );
            System.out.println( "curl 'http://localhost:3000/courses/instructor/q' -H 'Content-Type: application/json'" );
            sendGetRequest( "/instructor/q" );
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println( "Something went wrong!" );
        }
    }

    static void sendGetRequest(String s) throws RuntimeException {
        logger.debug( "argument: {}", s );

        if (s == null) {
            s = "";
        }

        try {
            WebResource webResource = client.resource( applicationServiceURI + s );
            ClientResponse response = webResource.accept( "application/json" )
                    .get( ClientResponse.class );
            if (response.getStatus() != 200) {
                throw new RuntimeException( "Failed : HTTP error code : "
                        + response.getStatus() );
            }
            List<String> slist = response.getEntity( new GenericType<List<String>>() {
            } );

            System.out.println( slist );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void initializeClient() {
        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add( JacksonJsonProvider.class );
        client = Client.create( defaultClientConfig );
    }
}
