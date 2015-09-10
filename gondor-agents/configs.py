#!/usr/bin/env python2.7
#@author Vipin Kumar


class CONFIG(object):
    def factory(type):
        if type == "HADOOP":
            return HADOOP_CONFIG()
        if type == "HBASE":
            return HBASE_CONFIG()
        if type == "ZOOKEEPER":
            return ZOOKEEPER_CONFIG()
        if type == "HIVE":
            return HIVE_CONFIG()
        assert 0, "Bad config type" + type
    factory = staticmethod(factory)


class HADOOP_CONFIG():

    def __init__(self):
        super(HADOOP_CONFIG, self).__init__()

    def loadConfigs():
        return "loaded"


class HBASE_CONFIG():

    def __init__(self):
        super(HBASE_CONFIG, self).__init__()

    def loadConfigs():
        return "loaded"


class ZOOKEEPER_CONFIG():

    def __init__(self):
        super(ZOOKEEPER_CONFIG, self).__init__()

    def loadConfigs():
        return "loaded"


class HIVE_CONFIG():

    def __init__(self):
        super(HIVE_CONFIG, self).__init__()

    def loadConfigs():
        return "loaded"
