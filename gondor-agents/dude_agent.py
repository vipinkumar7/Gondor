#!/usr/bin/env python
from __future__ import generators
import web
import socket
import sys
import subprocess
import urllib
import tarfile


urls = (
    '/', 'start',
    '/host/?', 'host',
    '/loadAgent/?', 'loadAgent',
    '/bundle/?', 'loadBundle',
    '/startService/?', 'startService',
    '/stopService/?', 'stopService',
)

GONDOR_ENV = {
    "TAR_SUFFIX": ".tar.gz",
    "_GONDOR_HOME": "/opt",
    "HADOOP_HOME": "/opt/_GONDOR/hadoop",
    "HIVE_HOME": "/opt/_GONDOR/hive",
    "ZOOKEEPER_HOME": "/opt/_GONDOR/zookeeper",
    "HBASE_HOME": "/opt/_GONDOR/hbase",
    "HADOOP_FETCH_URL": "https://archive.apache.org/dist/hadoop/core/hadoop-2.6.0/hadoop-2.6.0.tar.gz",
    "HIVE_FETCH_URL": "https://archive.apache.org/dist/hive/hive-0.14.0/apache-hive-0.14.0-bin.tar.gz",
    "HBASE_FETCH_URL": "https://archive.apache.org/dist/hbase/hbase-0.98.9/hbase-0.98.9-src.tar.gz",
    "ZOOKEEPER_FETCH_URL": "https://archive.apache.org/dist/zookeeper/zookeeper-3.4.5/zookeeper-3.4.5.tar.gz"}

app = web.application(urls, globals())


# check if host is reachable from this machine
def checkHost(hostname):
    try:
        socket.gethostbyname(hostname)
        return True
    except socket.error:
        return False


#create gondor directory and replicate agent to all hosts
def setEnvforgnodor(HOST):
    USER = "root"
    COMMAND = "mkdir  -v /opt/_GONDOR"
    ssh = subprocess.Popen(["ssh", "%s" % HOST, COMMAND],
    shell=False,
    stdout=subprocess.PIPE,
    stderr=subprocess.PIPE)
    result = ssh.stdout.readlines()
    if result == []:
        error = ssh.stderr.readlines()
        print ((sys.stderr, "ERROR :%s" % error))
        return False
    else:
        print (result)
    p = subprocess.Popen(["scp", "./dude_agent.py",
    "%s@%s:%s" % (USER, HOST, GONDOR_ENV["_GONDOR_HOME"])])
    p.wait()
    return True


class BUNDLE(object):
    def factory(type):
        if type == "HADOOP":
            return HADOOP_BUNDLE()
        if type == "HIVE":
            return HIVE_BUNDLE()
        if type == "HBASE":
            return HBASE_BUNDLE()
        if type == "ZOOKEEPER":
            return ZOOKEEPER_BUNDLE()
        assert 0, "Bad Bundle type" + type
    factory = staticmethod(factory)


class SERVICE(object):
    def factory(type):
        if type == "DATANODE":
            return DATANODE_INSTANCE()
        if type == "NAMENODE":
            return NAMENODE_INSTANCE()
        if type == "NODEMANAGER":
            return NODEMANAGER_INSTANCE()
        if type == "RESOURCEMANAGER":
            return RESOURCEMANAGER_INSTANCE()
        if type == "SECONDARYNAMENODE":
            return  SECNAMENODE_INSTANCE()
        if type == "JOBHISTORY_SERVER":
            return JOBHISTORY_SERVER_INSTANCE()
        if type == "HIVE_METASTORE":
            return HIVE_METASTROE_INSTANCE()
        if type == "HIVE_SERVER":
            return HIVE_SERVER_INSTANCE()
        if type == "ZOOKEEPER":
            return ZOOKEEPER_INSTANCE()
        if type == "HBASE_REGION":
            return HBASE_REGION_INSTANCE()
        if type == "HBASE_MASTER":
            return HBASE_MASTER_INSTANCE()
        assert 0, "Bad service type" + type
    factory = staticmethod(factory)


class HADOOP_BUNDLE(BUNDLE):
    def applyBundle(self, url):
        urllib.request.urlretrieve(GONDOR_ENV["HADOOP_FETCH_URL"],
        filename="%s%s" % (GONDOR_ENV["HADOOP_HOME"], GONDOR_ENV["TAR_SUFFIX"]))

    def untarBundle(self):
        tar = tarfile.open("%s%s" % (GONDOR_ENV["HADOOP_HOME"],
         GONDOR_ENV["TAR_SUFFIX"]))
        tar.extractall(path=GONDOR_ENV["HADOOP_HOME"], member=None)
        tar.close()


class HBASE_BUNDLE(BUNDLE):

    def __init__(self):
        super(HBASE_BUNDLE, self).__init__()

    def applyBundle(self, url):
        urllib.request.urlretrieve(GONDOR_ENV["HBASE_FETCH_URL"],
        filename="%s%s" % (GONDOR_ENV["HBASE_HOME"], GONDOR_ENV["TAR_SUFFIX"]))


class ZOOKEEPER_BUNDLE():

    def __init__(self):
        super(ZOOKEEPER_BUNDLE, self).__init__()

        def applyBundle(self, url):
                urllib.request.urlretrieve(GONDOR_ENV["ZOOKEEPER_FETCH_URL"],
                filename="%s%s" % (GONDOR_ENV["ZOOKEEPER_HOME"], GONDOR_ENV["TAR_SUFFIX"]))

    def applyBundle(self, url):
        urllib.request.urlretrieve(GONDOR_ENV["ZOOKEEPER_FETCH_URL"],
        filename="%s%s" % (GONDOR_ENV["ZOOKEEPER_HOME"], GONDOR_ENV["TAR_SUFFIX"]))


class HIVE_BUNDLE(BUNDLE):
    def applyBundle(self, url):
        urllib.requext.urlretrieve(GONDOR_ENV["HIVE_FETCH_URL"],
        filename="%s%s" % (GONDOR_ENV["HIVE_HOME"], GONDOR_ENV["TAR_SUFFIX"]))


class NAMENODE_INSTANCE():

    def __init__(self):
        super(NAMENODE_INSTANCE, self).__init__()

    def startService():
            return 'service started'


class DATANODE_INSTANCE():

    def __init__(self):
        super(DATANODE_INSTANCE, self).__init__()


class NODEMANAGER_INSTANCE():

    def __init__(self):
        super(NODEMANAGER_INSTANCE, self).__init__()


class RESOURCEMANAGER_INSTANCE():

    def __init__(self):
        super(RESOURCEMANAGER_INSTANCE, self).__init__()


class SECNAMENODE_INSTANCE():

    def __init__(self):
        super(SECNAMENODE_INSTANCE, self).__init__()


class JOBHISTORY_SERVER_INSTANCE():

    def __init__(self):
        super(JOBHISTORY_SERVER_INSTANCE, self).__init__()


class HIVE_METASTROE_INSTANCE():

    def __init__(self):
        super(HIVE_METASTROE_INSTANCE, self).__init__()


class HIVE_SERVER_INSTANCE():

    def __init__(self):
        super(HIVE_SERVER_INSTANCE, self).__init__()


class HBASE_REGION_INSTANCE():

    def __init__(self):
        super(HBASE_REGION_INSTANCE, self).__init__()


class HBASE_MASTER_INSTANCE():

    def __init__(self):
        super(HBASE_MASTER_INSTANCE, self).__init__()


class ZOOKEEPER_INSTANCE():

    def __init__(self):
        super(ZOOKEEPER_INSTANCE, self).__init__()


class start:
    def GET(self):
        return 'started'


class host:
    def GET(self):
        data = web.input(_method='get')
        hostname = data.host
        return checkHost(hostname)


class loadAgent:
    def GET(self):
        return setEnvforgnodor("localhost")


class loadBundle:
    def GET(self):
        param = web.input(_method='get')
        bundleName = param.bundle
        b = BUNDLE().factory(bundleName)
        b.applyBundle()
        return 'loaded'


class startService:
    def GET(self):
        return 'started service'


class stopService:
    def GET(self):
        return 'stopped'


if __name__ == "__main__":
    app.run()


