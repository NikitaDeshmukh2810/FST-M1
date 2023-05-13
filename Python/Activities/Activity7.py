numlist=[]
numlist = [int(item) for item in input("enter the list items :").split()]
sum = 0
print(numlist)
print(sum)

for number in numlist:
    sum += (number)

print(sum)