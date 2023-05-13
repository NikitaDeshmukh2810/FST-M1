# Define function to calculate sum
def Addition(num):
    if num:
        return num + Addition(num-1)
    else:
        return 0
res = Addition(10)

# Print result
print(res)