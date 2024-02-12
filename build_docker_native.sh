#!/bin/bash

mvn clean package -Pnative -Dquarkus.native.container-build=true

docker build -f src/main/docker/Dockerfile.native -t rinha-backend-2024q1-native:latest .
docker tag rinha-backend-2024q1-native:latest 442494/rinha-backend-2024q1-native:latest
# docker push 442494/rinha-backend-2024q1-native:latest