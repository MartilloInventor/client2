# coursesclient

**Problem Description**

In problem set 2 we build a simple client that uses the coursesapi and tests the node.js web server. This simple client will generate the same HTTP requests as courseinfotest.sh which can be found at the following location.

https://github.com/MartilloInventor/coursesapi/blob/master/courseinfotest.sh

Here are the contents of courseinfotest.sh.

_echo curl 'http://localhost:3000/courses/area/Cs' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/area/Cs' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/area/Ac' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/area/AC' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/area/AD' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/area/AD' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/area/*' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/area/*' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/area/C' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/area/C' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/instructor/Barbara' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/instructor/Barbara' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/instructor/Da' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/instructor/Da' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/instructor/ixzy' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/instructor/ixzy' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/instructor/*' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/instructor/*' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/instructor/z' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/instructor/z' -H 'Content-Type: application/json'_

_echo ""_

_echo curl 'http://localhost:3000/courses/instructor/q' -H 'Content-Type: application/json'_

_curl 'http://localhost:3000/courses/instructor/q' -H 'Content-Type: application/json'_

_echo ""_

**Procedure for Solving the Problem**

The first step is creating the coursesclient repository on github.

Creating an initial README.md on github makes it possible to create a new Intelli-j project by importing from github.

If you click on the File tab, you can set various options.

The default settings are probably okay.

Under Project Structure in Project, choose Java version 1.8 and Project language level as at least 8.

Then right click on the courseclient project in the project explorer window.

Under add framework choose: JSON Processing, Java EE verion Java EE 7, and maven.

Now replace the automatically generated pom.xml with the needed pom.xml.

See the pom.xml in the github coursesclient repository.

https://github.com/MartilloInventor/coursesclient/blob/master/pom.xml

Click on the java directory in the project explorer window pane and create the main class specified by the pom.xml

The pom.xml in the GitHub repository tells us that the main class relative to the java directory is the following.

_edu.webdev.CoursesClientRequest_

Next we rewrite the CoursesClientRequest.java in various languages that are commonly used by web developers.

All the real work of this program is done in the following method.

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
    
Do you understand it?





