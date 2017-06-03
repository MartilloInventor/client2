# coursesclient

**Problem Description**

In problem set 2 we build a simple client that uses the coursesapi and test the node.js web server. This simple client will generate the same HTTP requests as courseinfotest.sh which can be found at the following location.

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



