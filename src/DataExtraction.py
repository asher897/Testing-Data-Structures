import os

dates = open("dates.txt", "r")

countFile = open("counts.txt", "w+")
countBST = open("coBST.txt","w+")

findAVL = open("findsAVL", "w+")
findBST = open("findsBST", "w+")

for i in range(500):
    #Extract total counts for AVL
    date = str(dates.readline())
    dateColon = date.find(":")
    date = date[0:dateColon+6]
    #print(date)
    os.system("java PowerAVLApp " + date+" >AVLOutput.txt")
    power = open("AVLOutput.txt","r")
    power.readline()
    output = power.readline()
    output = output.strip("\n")
    #print(output)
    period = output.find(".")
    count = (output[period-4:period])
    #print(count)
    countFile.write(str(count)+"\n")

    #Extract total counts for BST
    os.system("java PowerBSTApp " + date+" >powerBST.txt")
    powerB = open("powerBST.txt","r")
    powerB.readline()
    outputB = powerB.readline()
    outputB = outputB.strip("\n")
    periodB = outputB.find(".")
    countB = int(outputB[periodB-4:periodB])
    countBST.write(str(countB)+"\n")

    power.close()
    powerB.close()

    #Extract find counts for AVL
    subOutput = output[period+2:]
    #print(subOutput)
    colon = subOutput.find(":")
    period = subOutput.find(".")
    findCount = (subOutput[colon+2:period]).strip()
    #print(findCount)
    findInt = int(findCount)
    #print(count)
    findAVL.write(str(findInt)+"\n")


    subOutputB = outputB[periodB+2:]
    colonB = subOutputB.find(":")
    periodB = subOutputB.find(".")
    findCountB = (subOutputB[colonB+2:periodB]).strip()
    #print(count)
    findBST.write(str(findCountB)+"\n")

    power.close()
    powerB.close()
dates.close()
countBST.close()
countFile.close()
findAVL.close()
findBST.close()
