#!/bin/sh
echo =================================
echo  自动化部署脚本启动
echo =================================

echo 停止原来运行中的工程
APP_NAME=myblog

tpid=`ps -ef|grep aurora-springboot|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'Stop Process...'
    kill -15 $tpid
fi
sleep 2
tpid=`ps -ef|grep aurora-springboot|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'Kill Process!'
    kill -9 $tpid
else
    echo 'Stop Success!'
fi
echo 当前分支为
git branch
echo 准备从Git仓库拉取最新代码
cd ~/item/$APP_NAME

echo 开始从Git仓库拉取最新代码
git pull
echo 代码拉取完成

echo 开始打包
cd ~/item/$APP_NAME/aurora-springboot
mvn clean
mvn package
echo 打包完成
cd ~/item/$APP_NAME/aurora-springboot/target

echo 启动项目
nohup java -jar aurora-springboot-0.0.1.jar &> ~/item/$APP_NAME.log &
echo 项目启动完成

