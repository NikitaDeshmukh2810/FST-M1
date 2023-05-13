numList=[]
numList = [int(item) for item in input("enter the list items :").split()]
print("Entered list is ", numList)


# Get first element in list
firstElement = numList[0]
# Get last element in list
lastElement = numList[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)