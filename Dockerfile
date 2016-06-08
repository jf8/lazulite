FROM java:8

WORKDIR /app

# Adding source, compile and package into a fat jar
ADD target/lazulite-0.0.1-SNAPSHOT.jar /app

EXPOSE 80

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "lazulite-0.0.1-SNAPSHOT.jar"]