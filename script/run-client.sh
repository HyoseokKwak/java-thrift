#!/bin/sh

SERVER_HOME="./"
PACKAGE="java-thrift-1.0-SNAPSHOT.jar"
MAIN_CLASS="com.test.khs.Client"
CLASSPATH=$SERVER_HOME/$PACKAGE

for LIB_FILE in $SERVER_HOME/dependency/*
do
            CLASSPATH=$CLASSPATH:$LIB_FILE
done
CLASSPATH=$CLASSPATH

echo java -cp $CLASSPATH $MAIN_CLASS 
java -cp $CLASSPATH $MAIN_CLASS 
