
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /build


COPY src/ ./src/


RUN mkdir -p classes && \
    javac -d classes src/supermarket/*.java src/Main.java


RUN mkdir -p META-INF && \
    echo "Manifest-Version: 1.0" > META-INF/MANIFEST.MF && \
    echo "Main-Class: supermarket.SupermarketSystem" >> META-INF/MANIFEST.MF && \
    jar cfm Supermarket_management_system.jar META-INF/MANIFEST.MF -C classes .


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /build/Supermarket_management_system.jar /app/Supermarket_management_system.jar


ENTRYPOINT ["java", "-jar", "/app/Supermarket_management_system.jar"]
