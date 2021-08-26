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

dataFile = open("counts.csv", "w+")

findAVL = open("findsAVL", "w+")
findBST = open("findsBST", "w+")
power = open("AVLOutput.txt", "r")
powerB = open("BSTOutput.txt","r")

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

power = open("AVLOutput.txt","r")
for i in range(500):
    power.readline()
    output = power.readline()
    #print(output)
    output = output.strip("\n")
    period = output.find(".")
    output = output[period+1:]
    colon = output.find(":")
    period = output.find(".")
    #print(output)
    findCount = (output[colon+2:period]).strip()
    #print(findCount)
    findInt = int(findCount)
    findAVL.write(str(findInt)+"\n")

    powerB.readline()
    outputB = powerB.readline()
    outputB = outputB.strip("\n")
    periodB = outputB.find(".")
    outputB = outputB[periodB+1:]
    colonB = outputB.find(":")
    periodB = outputB.find(".")
    findCountB = (outputB[colonB+2:periodB]).strip()
    findIntB = int(findCountB)
    findBST.write(str(findIntB)+"\n")

findAVL.close()
findBST.close()

findAVL = open("findsAVL", "r")
findBST = open("findsBST", "r")

for j in range(1,501):
    avlInsArr = []
    avlFinArr = []

    bstInsArr = []
    bstFinArr = []

    avlInsert = open("insertAVLCounts.txt", "r")
    bstInsert = open("insertBSTCounts.txt", "r")

    avlFind = open("findsAVL", "r")
    bstFind = open("findsBST", "r")

    for k in range(j):
        coA = avlInsert.readline()
        coA = coA.strip("\n")
        coA.strip()
        intCoA = int(coA)
        avlInsArr.append(intCoA)

        coBi = bstInsert.readline()
        #print(coBi)
        coBi = coBi.strip("\n")
        coBi.strip()
        intCoBi = int(coBi)
        bstInsArr.append(intCoBi)

        coAf = avlFind.readline()
        #print(coAf)
        coAf = coAf.strip("\n")
        #print(coAf)
        coAf.strip()
        #print(coAf)
        intCoAf = int(coAf)
        avlFinArr.append(intCoAf)

        coBf = bstFind.readline()
        coBf = coBf.strip("\n")
        coBf.strip()
        intCoBf = int(coBf)
        bstFinArr.append(intCoBf)

    avlFind.close()
    bstFind.close()
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


    line = str(j)+","+str(avlFinB)+","+str(avlFinW)+","+str(avlFinA)+","+str(bstFinB)+ "," +str(bstFinW)+","+str(bstFinA)+","+str(avlInsB)+","+str(avlInsW)+","+str(avlInsA)+","+str(bstInsB)+","+str(bstInsW)+","+str(bstInsA)+"\n"
    dataFile.readline()
    dataFile.write(line)
dataFile.close()
