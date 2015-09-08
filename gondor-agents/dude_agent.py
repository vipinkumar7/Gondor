#!/usr/bin/env python2.7
import web
import socket
import sys
import os
import subprocess 

urls = (
		'/','start',
		'/host/?','host',
		'/install/?','install',
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

class start:
	def GET(self):
		return 'started'

class host:
	def GET(self):
		data=web.input(_method='get')
		hostname=data.host
		return checkHost(hostname)

class install:
	def GET(self):
		return setEnvforgnodor("localhost")				







if __name__ == "__main__":
	app.run()


