#!/usr/bin/env python2.7
#@author Vipin Kumar

import properties
import os


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

    def appendEnv(self, prop, text):
        print ("written")
        with open("%s" % prop, "a") as envFile:
            envFile.write(text)
        return True

    def writeConfig(self, configFile, text):
        with open("%s" % configFile, "w") as confFile:
            confFile.write(text)
        return True


class HADOOP_CONFIG(CONFIG):

    instance = None

    def __init__(self):
        if not HADOOP_CONFIG.instance:
            super(HADOOP_CONFIG, self).__init__()
        else:
            HADOOP_CONFIG.instance

    def loadConfigs(self, filename, text):
        super.writeConfig(os.path.join
        (properties.GONDOR_ENV["HADOOP_CONF"], filename), text)

    def loadEnv(self):
        text = "----------hadoop ENV variables---------\n"
        for key in properties.HADOOP_VARIABLES:
            text = text + ("export %s=%s\n" %
            (key, properties.HADOOP_VARIABLES[key]))
        super(HADOOP_CONFIG, self).appendEnv("%s" % properties.GONDOR_ENV["GONDOR_ENV_FILE"], text)
        return True


class HBASE_CONFIG(CONFIG):

    instance = None

    def __init__(self):
        if not HBASE_CONFIG.instance:
            super(HBASE_CONFIG, self).__init__()
        else:
            HBASE_CONFIG.instance

    def loadConfigs(filename, text):
        super.writeConfig(os.path.join
        (properties.GONDOR_ENV["HBASE_CONF"], filename), text)

    def loadEnv():
        text = "----------hbase ENV variables---------\n"
        for key in properties.HBASE_VARIABLES:
            text.join("export %s=%s\n" %
            (key, properties.HBASE_VARIABLES[key]))
        super.appendEnv("%s" % properties.GONDOR_ENV["GONDOR_ENV_FILE"], text)
        return True


class ZOOKEEPER_CONFIG(CONFIG):

    instance = None

    def __init__(self):
        if not ZOOKEEPER_CONFIG.instance:
            super(ZOOKEEPER_CONFIG, self).__init__()
        else:
            ZOOKEEPER_CONFIG.instance

    def loadConfigs(filename, text):
        super.writeConfig(os.path.join
        (properties.GONDOR_ENV["ZOOKEEPER_CONF"], filename), text)

    def loadEnv():
        text = "----------zookeeper ENV variables---------\n"
        for key in properties.ZOOKEEPER_VARIABLES:
            text.join("export %s=%s\n" %
            (key, properties.ZOOKEEPER_VARIABLES[key]))
        super.appendEnv("%s" % properties.GONDOR_ENV["GONDOR_ENV_FILE"], text)
        return True


class HIVE_CONFIG(CONFIG):

    instance = None

    def __init__(self):
        if not HIVE_CONFIG.instance:
            super(HIVE_CONFIG, self).__init__()
        else:
            HIVE_CONFIG.instance

    def loadConfigs(filename, text):
        super.writeConfig(os.path.join
        (properties.GONDOR_ENV["HIVE_CONF"], filename), text)

    def loadEnv():
        text = "----------hbase ENV variables---------\n"
        for key in properties.HIVE_VARIABLES:
            text.join("export %s=%s\n" %
            (key, properties.HIVE_VARIABLES[key]))
        super.appendEnv("%s" % properties.GONDOR_ENV["GONDOR_ENV_FILE"], text)
        return True
