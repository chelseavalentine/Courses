"""
Assignment name: Shortest Path Problem
Details: given a matrix of random values, find the path that costs the least to go from left to right
Student name: Chelsea Valentine
"""
from random import randint

#Get number of rows & columns
dim = (input("Input the rows, followed by the columns, of the matrix that you want to create (eg. 2 2) "))
dim = dim.split()
dim[0]=int(dim[0])
dim[1]=int(dim[1])
matrix = []
tracker=[]

#Fill the matrix with random values
for i in range(int(dim[0])):
    matrix.append([])
    tracker.append([])
    for j in range(int(dim[1])):
        matrix[i].append(randint(1,9))

#Show the user the matrix
print("Matrix:")
for i in range(int(dim[0])):
    for j in range (int(dim[1])):
        print(matrix[i][j], end=' ')
    print()

#Find the minimum value in the close entries of the column before the current one
for col in range(1, dim[1]):
    for row in range(dim[0]):
        #find the smallest value near the current entry
        temp=[]
        for test in [-1, 0]:
            temp.append(matrix[row+test][col-1])
        if row == dim[0]-1:
            temp.append(matrix[0][col-1])
        else:
            temp.append(matrix[row+1][col-1])
        ##add it to the current point, and also to the list tracking each possible path
        tracker[row].append(min(temp))
        matrix[row][col] += min(temp)
"""
#testing
print("tracker", tracker)
print("results")
for i in range(int(dim[0])):
    for j in range (int(dim[1])):
        print(matrix[i][j], end=' ')
    print()
"""
#find the smallest cost in the final row
placeholder = 0
for i in range(dim[0]):
    mini = matrix[0][dim[1]-1]
    if matrix[i][(dim[1])-1] <= mini:
        placeholder = i
        tracker[placeholder].append(matrix[i][dim[1]-1])
        cost = matrix[i][dim[1]-1]

#Restore the path to match the original matrix
for i in range(len(tracker[placeholder])-1, 0, -1):
    tracker[placeholder][i] -= tracker[placeholder][i-1]
print("Least cost path is: ", end='')
for i in range(len(tracker)):
    print(tracker[placeholder][i], end=' ')
print("\nCost is:", cost)