#!/bin/bash

NAME = hadoop-service

namenode(){
	
	nohup /opt/_GONDOR/hadoop/sbin/hadoop-daemon.sh start namenode 
}


case "$1" in
start_namenode)
	echo "starting namenode"
	namenode
	;;

start_datanode)
	echo "starting datanode"
	datanode
	;;
start_nodemanager)
	echo "starting nodemanager"
	nodemanager
	;;
start_resourcemanager)
	echo "starting resource manager"
	resourcemanager
	;;
*)

N=/etc/init.d/$NAME
echo "Usage: $N {start_namenode|start_datanode|start_nodemanager|start_resourcemanager}" > &2
exit 1
;;

esac
exit 0
	
