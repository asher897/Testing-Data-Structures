import os
import subprocess

def findBest(count):
    maxNum = 0
    for i in range(len(count)):
        if int(count[i]) > maxNum:
            maxNum = int(count[i])
    return maxNum

def findWorst(count):
    minNum = count[0]
    for i in range(len(count)):
        if int(count[i]) < minNum:
            minNum = int(count[i])
    return minNum

def findAverage(count):
    total = 0
    avg = 0;
    for i in range(len(count)):
        total += int(count[i])
    if len(count) != 0:
        avg = total/len(count)
    return avg


dates = open("dates.txt", "r")
count= 0
dataFile = open("counts.csv", "w+")
countFile = open("counts.txt", "w+")
countBST = open("coBST.txt","w+")
AVLBest = 0
AVLWorst = 0
AVLAvg = 0

treeBest = 0
treeWorst = 0
treeAvg = 0

dataFile.write("N,AVLBest,AVLWorst,AVLAverage,TreeBest,TreeWorst,TreeAverage\n")

for i in range(500):

    date = str(dates.readline())
    dateColon = date.find(":")
    date = date[0:dateColon+6]
    os.system("java PowerAVLApp " + date+" >AVLOutput.txt")
    power = open("AVLOutput.txt","r")
    power.readline()
    output = power.readline()
    colon = output.find(":")
    count = int(output[colon+2:])
    countFile.write(str(count)+"\n")

    os.system("java PowerBSTApp " + date+" >powerBST.txt")
    powerB = open("powerBST.txt","r")
    powerB.readline()
    outputB = powerB.readline()
    colonB = outputB.find(":")
    countB = int(outputB[colonB+2:])
    countBST.write(str(countB)+"\n")

    power.close()
    powerB.close()
dates.close()
countBST.close()
countFile.close()


for j in range(1,501):
    countArray = []
    treeArray = []

    powerFile = open("counts.txt", "r")
    BFile = open("coBST.txt", "r")
    for k in range(j):

        coB = BFile.readline()
        coB = coB.strip("\n")
        coB.strip()
        intCoB = int(coB)
        treeArray.append(coB)

        co = powerFile.readline()
        co = co.strip("\n")
        co.strip()
        intCo = int(co)
        countArray.append(intCo)


    powerFile.close()
    BFile.close()

    AVLBest = findBest(countArray)
    AVLWorst = findWorst(countArray)
    AVLAvg = findAverage(countArray)

    treeBest = findBest(treeArray)
    treeWorst = findWorst(treeArray)
    treeAvg = findAverage(treeArray)

    line = str(j)+","+str(AVLWorst)+","+str(AVLBest)+","+str(AVLAvg)+","+str(treeWorst)+","+str(treeBest)+","+str(treeAvg)+"\n"
    dataFile.readline()
    dataFile.write(line)
dataFile.close()
