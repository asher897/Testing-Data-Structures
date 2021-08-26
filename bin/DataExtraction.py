import os

dates = open("dates.txt", "r")

for i in range(500):
    #Run both apps and collect all outputs into 2 seperate files
    date = str(dates.readline())
    dateColon = date.find(":")
    date = date[0:dateColon+6]
    #print(date)
    os.system("java PowerAVLApp " + date+" >>AVLOutput.txt")
    os.system("java PowerBSTApp " + date+" >>BSTOutput.txt")

dates.close()
