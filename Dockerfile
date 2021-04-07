#Build
from gradle:6.8.3-jdk8 as builder
copy . /home
workdir /home
run gradle build --info

#Exec
from openjdk:8-jre-slim
workdir /app
copy --from=builder /home/build/libs/*.jar app.jar
cmd ["sh","-c","java -Xmx300m -Xss512k -Dserver.port=$PORT -jar /app/app.jar"]
# cmd ["sh" "-c" "java" "-Xmx300m" "-Xss512k" "-Dserver.port=$PORT" "-jar" "/app/app.jar"]
