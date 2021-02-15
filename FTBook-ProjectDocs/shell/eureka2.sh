#!/bin/bash
APP_NAME=FTBook-EurekaServer-0.0.1-SNAPSHOT_2.jar

#使用说明，用来提示输入参数
usage() {
        echo "please enter the corresponding parameters [start|stop|restart|status]"
        exit 1
}

#检查程序是否在运行
is_exist(){
        pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}' `
        #如果不存在返回1，存在返回0     
        if [ -z "${pid}" ]; then
                return 1
        else
                return 0
        fi  
}

#启动方法
start(){
        is_exist
        if [ $? -eq "0" ]; then
                echo "${APP_NAME} is already running. pid=${pid} ."
        else
                nohup java -Xmx256m -Xms256m -jar $APP_NAME --spring.profiles.active=peer1 > /dev/null 2>&1 &
                if [ $? -eq 0 ]; then
                        echo "start ${APP_NAME} is success"
                else
                        echo "start ${APP_NAME} is fail"
                fi  
        fi  
}

#停止方法
stop(){
        is_exist
        if [ $? -eq "0" ]; then
                kill -9 $pid
                if [ $? -eq 0 ]; then
                        echo "stop ${APP_NAME} is success"
                else
                        echo "stop ${APP_NAME} is fail"
                fi
        else
                echo "${APP_NAME} is not running"
        fi
}

#输出运行状态
status(){
        is_exist
        if [ $? -eq "0" ]; then
                echo "${APP_NAME} is running. Pid is ${pid}"
        else
                echo "${APP_NAME} is not running."
        fi
}

#重启
restart(){
        stop
        start
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
        "start")
        start
        ;;
        "stop")
        stop
        ;;
        "status")
        status
        ;;
        "restart")
        restart
        ;;
        *)
        usage
        ;;
esac