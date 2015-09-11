#!/usr/bin/env python2.7
#@author Vipin Kumar
from __future__ import generators

import web
import socket
import sys
import subprocess
import bundles
import properties
import instances
import configs

urls = (
    '/', 'start',
    '/host/?', 'host',
    '/loadAgent/?', 'loadAgent',
    '/bundle/?', 'loadBundle',
    '/startService/?', 'startService',
    '/stopService/?', 'stopService',
    '/loadConfig/?', 'loadConfig',
    '/loadEnv/?', 'loadEnv',
)


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
    "%s@%s:%s" % (USER, HOST, properties.GONDOR_ENV["_GONDOR_HOME"])])
    p.wait()
    return True


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
        param = web.input(_method='get')
        hostname = param.host
        return setEnvforgnodor(hostname)


class loadBundle:
    def GET(self):
        param = web.input(_method='get')
        bundleName = param.bundle
        b = bundles.BUNDLE().factory(bundleName)
        #b.applyBundle()
        b.untarBundle()
        return 'LOADED'


class startService:
    def GET(self):
        param = web.input(_method='get')
        instancename = param.instance
        i = instances.SERVICE().factory(instancename)
        i.startService()
        i.stopService()
        return 'started service'


class stopService:
    def GET(self):
        param = web.input(_method='get')
        instancename = param.instance
        i = instances.SERVICE().factory(instancename)
        i.stopService()
        return 'stopped service'


class loadConfig:
    def POST(self):
        param = web.input(_method='get')
        whichbundle = param.bundle
        whichFile = param.file
        text = param.text
        c = configs.CONFIG().factory(whichbundle)
        c.loadConfigs(whichFile, text)
        return 'configuration loaded'


class loadEnv:
    def GET(self):
        c = configs.CONFIG().factory("HADOOP")
        c.loadEnv()
        return 'enviroment loaded'


if __name__ == "__main__":
    app.run()


