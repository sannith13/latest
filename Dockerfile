
From tomcat:8

WORKDIR /usr/springapp
copy *.war /usr/local/tomcat/webapps/
EXPOSE 8080

