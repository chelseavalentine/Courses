"""
Assignment Name: Another Sort of Sort
Student Name: Chelsea Valentine (cv851)
"""

import random

#ask for input & keep the user in a loop until they type 'done'
while True:
    n = int(input("Enter an integer to create a random list, or type 'done' to finish: "))

    #check whether user entered 'done' & define the random list
    if n == 'done':
        break
    randomlist=[]

    #show create a list of random values
    for i in range(0,n):
        randomlist.append(random.randint(1,3*n))
        i += 1

    print("The list with", n, "random values is:", randomlist)
    print("When we sort that list, we get:", sorted(randomlist))
    print()
