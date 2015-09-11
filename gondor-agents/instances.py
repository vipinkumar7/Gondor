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


class NAMENODE_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not NAMENODE_INSTANCE.instance:
            super(NAMENODE_INSTANCE, self).__init__()
        else:
            NAMENODE_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class DATANODE_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not DATANODE_INSTANCE.instance:
            super(DATANODE_INSTANCE, self).__init__()
        else:
            DATANODE_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class NODEMANAGER_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not NODEMANAGER_INSTANCE.instance:
            super(NODEMANAGER_INSTANCE, self).__init__()
        else:
            NODEMANAGER_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class RESOURCEMANAGER_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not RESOURCEMANAGER_INSTANCE.instance:
            super(RESOURCEMANAGER_INSTANCE, self).__init__()
        else:
            RESOURCEMANAGER_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class SECNAMENODE_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not SECNAMENODE_INSTANCE.instance:
            super(SECNAMENODE_INSTANCE, self).__init__()
        else:
            SECNAMENODE_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class JOBHISTORY_SERVER_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not JOBHISTORY_SERVER_INSTANCE.instance:
            super(JOBHISTORY_SERVER_INSTANCE, self).__init__()
        else:
            JOBHISTORY_SERVER_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class HIVE_METASTROE_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not HIVE_METASTROE_INSTANCE.instance:
            super(HIVE_METASTROE_INSTANCE, self).__init__()
        else:
            HIVE_METASTROE_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class HIVE_SERVER_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not HIVE_SERVER_INSTANCE.instance:
            super(HIVE_SERVER_INSTANCE, self).__init__()
        else:
            HIVE_SERVER_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class HBASE_REGION_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not HBASE_REGION_INSTANCE.instance:
            super(HBASE_REGION_INSTANCE, self).__init__()
        else:
            HBASE_REGION_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class HBASE_MASTER_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not HBASE_MASTER_INSTANCE.instance:
            super(HBASE_MASTER_INSTANCE, self).__init__()
        else:
            HBASE_MASTER_INSTANCE.instance

    def startService(self):
            return 'service started'

    def stopService(self):
        return 'service stopped'


class ZOOKEEPER_INSTANCE(SERVICE):

    instance = None

    def __init__(self):
        if not ZOOKEEPER_INSTANCE.instance:
            super(ZOOKEEPER_INSTANCE, self).__init__()
        else:
            ZOOKEEPER_INSTANCE.instance

    def startService():
            return 'service started'

    def stopService():
        return 'service stopped'
