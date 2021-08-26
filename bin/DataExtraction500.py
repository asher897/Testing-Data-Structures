import os

os.system("java dateArraySort > dateSort.txt")
dates = open("dateSort.txt", "r")
dateArr = dates.readlines()
size = len(dateArr)
dates.close()
dates = open("dateSort.txt", "r")

for i in range(size):
    #Run both apps and collect all outputs into 2 seperate files
    date = str(dates.readline())
    dateColon = date.find(":")
    date = date[0:dateColon+6]
    #print(date)
    os.system("java PowerAVL500 " + date+" >>AVLOutput500.txt")
    os.system("java PowerBST500 " + date+" >>BSTOutput500.txt")

dates.close()
