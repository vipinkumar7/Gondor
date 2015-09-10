#!/usr/bin/env python2.7
#@author Vipin Kumar

GONDOR_ENV = {
    "TAR_SUFFIX": ".tar.gz",
    "_GONDOR_HOME": "/opt",
    "HADOOP_HOME": "/opt/_GONDOR/hadoop",
    "HADOOP_VERSION": "2.6.0",
    "HIVE_HOME": "/opt/_GONDOR/hive",
    "ZOOKEEPER_HOME": "/opt/_GONDOR/zookeeper",
    "HBASE_HOME": "/opt/_GONDOR/hbase",
    "HADOOP_FETCH_URL": "https://archive.apache.org/dist/hadoop/core/" +
    "hadoop-2.6.0/hadoop-2.6.0.tar.gz",
    "HIVE_FETCH_URL": "http://archive.apache.org/dist/hive/" +
    "hive-0.14.0/apache-hive-0.14.0-bin.tar.gz",
    "HBASE_FETCH_URL": "https://archive.apache.org/dist/hbase/" +
    "hbase-0.98.9/hbase-0.98.9-src.tar.gz",
    "ZOOKEEPER_FETCH_URL": "http://archive.apache.org/dist/zookeeper/" +
    "zookeeper-3.4.5/zookeeper-3.4.5.tar.gz",
    "HADOOP_ENV_FILE": "hadoop_env.sh",
    "HADOOP_CONF": "/opt/_GONDOR/hadoop-2.6.0/etc/hadoop",
    "HIVE_CONF": "/opt/_GONDOR/hive/apache-hive-0.14.0-bin/conf",
    "ZOOKEEPER_CONF": "/opt/_GONDOR/zookeeper-3.4.5/conf",
    "HBASE_CONF": "/opt/_GONDOR/hbase-0.98.9/conf"}


SERVICE_SCRIPT = {
    "NAMENODE_START": "/opt/_GONDOR/hadoop/sbin/hadoop-daemon.sh start namenode",
    "SECONDARY_NAMENODE_START": "/opt/_GONDOR/hadoop/sbin/hadoop-daemon.sh start secondarynamenode",
    "DATANODE_START": "hadoop-daemon.sh start datanode",
    "NODEMANAGER_START": "yarn-daemons.sh start nodemanager",
    "RESOURCEMANAGER_START": "yarn-daemon.sh  start resourcemanager"
    }

