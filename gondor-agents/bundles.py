#!/usr/bin/env python2.7
#@author Vipin Kumar


import urllib
import tarfile
import properties


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


class HADOOP_BUNDLE(BUNDLE):
    def applyBundle(self):
        urllib.urlretrieve(properties.GONDOR_ENV["HADOOP_FETCH_URL"],
        filename="%s%s" % (properties.GONDOR_ENV["HADOOP_HOME"],
        properties.GONDOR_ENV["TAR_SUFFIX"]))

    def untarBundle(self):
        tar = tarfile.open("%s%s" % (properties.GONDOR_ENV["HADOOP_HOME"],
        properties.GONDOR_ENV["TAR_SUFFIX"]))
        tar.extractall(path="%s" % (properties.GONDOR_ENV["HADOOP_HOME"]))
        tar.close()


class HBASE_BUNDLE(BUNDLE):

    def __init__(self):
        super(HBASE_BUNDLE, self).__init__()

    def applyBundle(self):
        urllib.urlretrieve(properties.GONDOR_ENV["HBASE_FETCH_URL"],
        filename="%s%s" % (properties.GONDOR_ENV["HBASE_HOME"],
        properties.GONDOR_ENV["TAR_SUFFIX"]))

    def untarBundle(self):
        tar = tarfile.open("%s%s" % (properties.GONDOR_ENV["HBASE_HOME"],
         properties.GONDOR_ENV["TAR_SUFFIX"]))
        tar.extractall(path="%s" % (properties.GONDOR_ENV["HBASE_HOME"]))
        tar.close()


class ZOOKEEPER_BUNDLE():
    def applyBundle(self):
        urllib.urlretrieve(properties.GONDOR_ENV["ZOOKEEPER_FETCH_URL"],
        filename="%s%s" % (properties.GONDOR_ENV["ZOOKEEPER_HOME"],
        properties.GONDOR_ENV["TAR_SUFFIX"]))

    def untarBundle(self):
        tar = tarfile.open("%s%s" % (properties.GONDOR_ENV["ZOOKEEPER_HOME"],
         properties.GONDOR_ENV["TAR_SUFFIX"]))
        tar.extractall(path="%s"% (properties.GONDOR_ENV["ZOOKEEPER_HOME"]))
        tar.close()


class HIVE_BUNDLE(BUNDLE):
    def applyBundle(self):
        urllib.urlretrieve(properties.GONDOR_ENV["HIVE_FETCH_URL"],
        filename="%s%s" % (properties.GONDOR_ENV["HIVE_HOME"],
        properties.GONDOR_ENV["TAR_SUFFIX"]))

    def untarBundle(self):
        tar = tarfile.open("%s%s" % (properties.GONDOR_ENV["HIVE_HOME"],
         properties.GONDOR_ENV["TAR_SUFFIX"]))
        tar.extractall(path="%s" % (properties.GONDOR_ENV["HIVE_HOME"]))
        tar.close()
