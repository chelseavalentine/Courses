"""
Assignment title: Where's Waldo?
Purpose: Evaluate whether a matrix has a saddle point or not
Student name: Chelsea Valentine (cv851)
"""
import random

#define funtion to print square matrices
def showMatrix (MATRIX):
    for i in range (n):
        for j in range(n):
            print(format(MATRIX[i][j], '<3d'), end='')
        print()
    return MATRIX

def column (x, i):
    col = [x[j][i] for j in range(n)]
    return col

#Ask for user input until user types 'done'
while True:
    n = input("Please enter an integer to base the dimensions of your matrices, or type 'done' to exit: ")

    if n == 'done':
        break

    else:
        n = int(n)

    #Create empty list
    A = []
    
    #Generate an 0 entries of an empty matrix depending on the size
    for a in range (n):
        for b in range (n):
            A.append(n*[0])
    
    #Generate matrix A, randomly
    for c in range (n):
        for d in range (n):
            A[c][d] = random.randint(0,5)

    #Print matrix
    print("Matrix:")
    showMatrix(A)
    print()

    #find maximum point for each column
    maxes = []
    for a in range(n):
        maxes.append(max(column(A, a)))
    
    #define found to keep track of whether a saddle point was found
    found = False
    
    #find whether each point is a saddle point
    for e in range (n):
        for f in range (n):
            if A[e][f] == min(A[e]) and A[e][f] >= maxes[f]:
                print("A saddle point was found!", A[e][f], "is a saddle point in the", f+1, "x-position and", e+1, "y-position")
                print("In other words: ("+ str(A[e][f])+",", str(f+1)+",", str(e+1)+")")
                found = True
    if found == True:
        print()
        print("Note: the x- and y-positions are based such that (1,1) represents the first column's first entry. (1,2) is the second column's first entry, and so on.")
    if found == False:
        print("No saddle points were found!")
    print()
