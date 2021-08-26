avlInsert = open("insertAVLCounts.txt", "r")
for i in range(500):
    coA = avlInsert.readline()
    coA = coA.strip("\n")
    coA.strip()
    print(coA)
    intCoA = int(coA)
    print(intCoA)

avlInsert.close()
