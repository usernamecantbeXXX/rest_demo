#!/bin/sh
PIDFILE=service.pid
if [ ! -d "logs" ]; then
   sudo mkdir logs
fi
if [ -f "$PIDFILE" ]; then
    echo "Service is already start ..."
else
    echo "Service  start ..."
    nohup java -jar rest_demo-0.0.1-SNAPSHOT.jar 1> logs/rest_demo.out 2>&1  &
    printf '%d' $! > $PIDFILE
    echo "Service  start SUCCESS "
fi