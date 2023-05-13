num_tuple=[]
num_tuple = [int(item) for item in input("enter the list items :").split()]
sum = 0
print(num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)