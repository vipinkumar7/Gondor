#!/usr/bin/env python2.7
#@author Vipin Kumar


#import properties


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


class NAMENODE_INSTANCE():

    def __init__(self):
        super(NAMENODE_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class DATANODE_INSTANCE():

    def __init__(self):
        super(DATANODE_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class NODEMANAGER_INSTANCE():

    def __init__(self):
        super(NODEMANAGER_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class RESOURCEMANAGER_INSTANCE():

    def __init__(self):
        super(RESOURCEMANAGER_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class SECNAMENODE_INSTANCE():

    def __init__(self):
        super(SECNAMENODE_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class JOBHISTORY_SERVER_INSTANCE():

    def __init__(self):
        super(JOBHISTORY_SERVER_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class HIVE_METASTROE_INSTANCE():

    def __init__(self):
        super(HIVE_METASTROE_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class HIVE_SERVER_INSTANCE():

    def __init__(self):
        super(HIVE_SERVER_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class HBASE_REGION_INSTANCE():

    def __init__(self):
        super(HBASE_REGION_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class HBASE_MASTER_INSTANCE():

    def __init__(self):
        super(HBASE_MASTER_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'


class ZOOKEEPER_INSTANCE():

    def __init__(self):
        super(ZOOKEEPER_INSTANCE, self).__init__()

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'
