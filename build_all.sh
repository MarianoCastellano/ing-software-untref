#!/usr/bin/env sh
set -e
cd ejemplo1
mvn test
cd ..
cd ahorcado
mvn test
