#!/usr/bin/python
import time
import os

totalTime = 9
triggerTime = 3

print "Start : %s" % time.ctime()
while totalTime >= triggerTime:
    os.system("bash ~/Develop/distrComp/cse5234/batch/InventoryUpdate.sh")
    time.sleep(triggerTime)
    totalTime = totalTime - triggerTime
    print totalTime
time.sleep(totalTime)
print "End : %s" % time.ctime()
