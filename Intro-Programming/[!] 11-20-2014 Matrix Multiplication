"""
Assignment title: Matrix Multiplication
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

#define dot product function
def dot(A, B):
    lena = len(A)
    g = 0
    for i in range(lena):
        g += A[i] * B[i]
    return g

#define function to multiply 2 square matrices    
def mult(A, B):
    entry = 0
    for e in range (n):
        for f in range (n):
            for g in range (n):
                part = A[e][g]*B[g][f]
                entry += part
            #Assign value to corresponding entry in matrix C & reset entry
            C[e][f] = entry
            entry = 0
    showMatrix(C)
    
#Ask for user input until user types 'done'
while True:
    n = input("Please enter an integer to base the dimensions of your matrices, or type 'done' to exit: ")

    if n == 'done':
        break

    else:
        n = int(n)

    #Create lists that will become matrices
    A = []
    B = []
    C = []
    
    #Generate an empty matrix depending on the size
    for a in range (n):
        for b in range (n):
            A.append(n*[0])
            B.append(n*[0])
            C.append(n*[0])
    
    #Generate matrix A & B, randomly
    for c in range (n):
        for d in range (n):
            A[c][d] = random.randint(0,5)
            B[c][d] = random.randint(0,5)

    #Print matrices A & B
    print("First Matrix:")
    showMatrix(A)
    print()

    print("Second Matrix:")
    showMatrix(B)
    print()

    #Generate the product of the matrices
    print("When we multiply the matrices together, we get:")
    
    #Multiply matrix A & B
    mult(A,B)
    print()
