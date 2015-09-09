#!/usr/bin/env python2.7
from __future__ import generators
import web
import socket
import sys
import os
import subprocess 
import random
import   urllib
import tarfile


urls = (
		'/','start',
		'/host/?','host',
		'/loadAgent/?','loadAgent',
		'/bundle/?','loadBundle',
		'/startService/?','startService',
		'/stopService/?','stopService',
)

app=web.application(urls,globals())

# check if host is reachable from this machine
def checkHost(hostname):
	try:
		socket.gethostbyname(hostname)
		return True
	except socket.error:
		return False

#create gondor directory and replicate agent to all hosts
def setEnvforgnodor(HOST):
	COMMAND="mkdir  -v /opt/_GONDOR"
	ssh= subprocess.Popen(["ssh","%s" % HOST,COMMAND],
	shell=False,
	stdout=subprocess.PIPE,
	stderr=subprocess.PIPE)
	result = ssh.stdout.readlines()
	if result == []:
		error = ssh.stderr.readlines()
		print ( sys.stderr ,"ERROR :%s" % error)
		return False		
	else :
		print (result)
	p = subprocess.Popen(["scp","./dude_agent.py","root@localhost:/opt/_GONDOR"])
	sts=os.wait()
	return True

class BUNDLE(object):
	def factory(type):
		if type == "HADOOP" :return HADOOP_BUNDLE()
		if type == "HIVE" :return HIVE_BUNDLE()
		assert 0 ,"Bad Bundle type"+type
	factory =staticmethod(factory)
	

	def untarBundle(self,filename):
                tar=tarfile.open(filename)
                tar.extractall()
                tar.close()
 
class SERVICE(object):
	def factory(type):
		if type == "DATANODE" :return DATANODE_INSTANCE()
		if type == "NAMENODE" : return NAMENODE_INSTANCE()
		if type == "NODEMANAGER" : return NODEMANAGER_INSTANCE()
		if type == "RESOURCEMANAGER" : return RESOURCEMANAGER_INSTANCE()
		if type == "SECONDARYNAMENODE" : return  SECNAMENODE_INSTANCE()
		if type == "JOBHISTORY_SERVER" :return JOBHISTORY_SERVER_INSTANCE()
		if type == "HIVE_METASTORE" : return HIVE_METASTROE_INSTANCE()
		if type == "HIVE_SERVER" :return HIVE_SERVER_INSTANCE()
		if type == "ZOOKEEPER" :return ZOOKEEPER_INSTANCE()
		assert 0, "Bad service type" +type
	factory = staticmethod(factory)


					
class HADOOP_BUNDLE(BUNDLE):
	def applyBundle(self,url):
		urllib.urlretrieve("https://archive.apache.org/dist/hadoop/core/hadoop-2.6.0/hadoop-2.6.0.tar.gz",
		filename="/opt/hadoop.tar.gz")
		
		
class HIVE_BUNDLE(BUNDLE):
	def applyBundle(self,url):
		urllib.urlretrieve("https://archive.apache.org/dist/hive/hive-0.14.0/apache-hive-0.14.0-bin.tar.gz",
		filename="/opt/hive.tar.gz")

			
class start:
	def GET(self):
		return 'started'

class host:
	def GET(self):
		data=web.input(_method='get')
		hostname=data.host
		return checkHost(hostname)

class loadAgent:
	def GET(self):
		return setEnvforgnodor("localhost")				
class loadBundle:
	def GET(self):
		param=web.input(_method='get')
		bundleName=param.bundle
		b= Bundle().factory(bundleName)
		return 'loaded'

class startService:
	def GET(self):
		return 'started service'

class stopService:
	def GET(self):
		return 'stopped'


if __name__ == "__main__":
	app.run()


