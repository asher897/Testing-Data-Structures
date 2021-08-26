import os
import subprocess

def findWorst(count):
    maxNum = 0
    for i in range(len(count)):
        if int(count[i]) > maxNum:
            maxNum = int(count[i])
    return maxNum

def findBest(count):
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

count= 0

dataFile = open("counts500.csv", "w+")

findAVL = open("findsAVL500", "w+")
findBST = open("findsBST500", "w+")
power = open("AVLOutput500.txt", "r")
bstOutput = open("BSTOutput500.txt","r")

avlInsB = 0
avlInsW = 0
avlInsA = 0

bstInsB = 0
bstInsW = 0
bstInsA = 0

avlFinB = 0
avlFinW = 0
avlFinA = 0

bstFinB = 0
bstFinW = 0
bstFinA = 0

dataFile.write("N,AVLFindBest,AVLFindWorst,AVLFindAverage,BSTFindBest,BSTFindWorst,BSTFindAverage,AVLInsertBest,AVLInsertWorst,AVLInsertAverage,BSTInsertBest,BSTInsertWorst,BSTInsertAverage\n")

length = bstOutput.readlines()
size = len(length)
bstOutput.close()
bstOutput = open("BSTOutput500.txt","r")
bstOutput.readline()
power.readline()
for i in range(size/2):
    power.readline()
    output = power.readline()
    #print(output)
    output = output.strip("\n")
    period = output.find(".")
    output = output[period+1:]
    #print(output)
    colon = output.find(":")
    period = output.find(".")
    findCount = (output[colon+2:period]).strip()
    #print(findCount)
    findInt = int(findCount)
    findAVL.write(str(findInt)+"\n")

    bstOutput.readline()
    outputB = bstOutput.readline()
    #print(outputB)
    #print(outputB)
    outputB = outputB.strip("\n")
    periodB = outputB.find(".")
    outputB = outputB[periodB+1:]
    colonB = outputB.find(":")
    periodB = outputB.find(".")
    findCountB = (outputB[colonB+2:periodB]).strip()
    #print(findCountB)
    findIntB = int(findCountB)

    findBST.write(str(findIntB)+"\n")

findAVL.close()
findBST.close()
power.close()
bstOutput.close()

findAVL = open("findsAVL500", "r")
findBST = open("findsBST500", "r")
avlInsArr = []
avlFinArr = []
bstInsArr = []
bstFinArr = []

avlInsert = open("insertAVLCounts500.txt", "r")
bstInsert = open("insertBSTCounts500.txt", "r")



for k in range(500):
    coAf = findAVL.readline()
    #print(coAf)
    coAf = coAf.strip("\n")
    #print(coAf)
    coAf.strip()
    #print(coAf)
    intCoAf = int(coAf)
    avlFinArr.append(intCoAf)

    coBf = findBST.readline()
    coBf = coBf.strip("\n")
    coBf.strip()
    intCoBf = int(coBf)
    bstFinArr.append(intCoBf)

coA = avlInsert.readline()
#print(coA)
coA = coA.strip("\n")
coA.strip()
#print(coA)
intCoA = int(coA)
avlInsArr.append(intCoA)

coBi = bstInsert.readline()
#print(coBi)
coBi = coBi.strip("\n")
coBi.strip()
intCoBi = int(coBi)
bstInsArr.append(intCoBi)

findAVL.close()
findBST.close()
avlInsert.close()
bstInsert.close()

avlInsB = findBest(avlInsArr)
avlInsW = findWorst(avlInsArr)
avlInsA = findAverage(avlInsArr)

bstInsB = findBest(bstInsArr)
bstInsW = findWorst(bstInsArr)
bstInsA = findAverage(bstInsArr)

avlFinB = findBest(avlFinArr)
avlFinW = findWorst(avlFinArr)
avlFinA = findAverage(avlFinArr)

bstFinB = findBest(bstFinArr)
bstFinW = findWorst(bstFinArr)
bstFinA = findAverage(bstFinArr)


line = "500"+","+str(avlFinB)+","+str(avlFinW)+","+str(avlFinA)+","+str(bstFinB)+ "," +str(bstFinW)+","+str(bstFinA)+","+str(avlInsB)+","+str(avlInsW)+","+str(avlInsA)+","+str(bstInsB)+","+str(bstInsW)+","+str(bstInsA)+"\n"
dataFile.readline()
dataFile.write(line)
dataFile.close()
