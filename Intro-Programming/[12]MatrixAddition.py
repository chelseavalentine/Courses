"""
Assignment name: Matrix Addition
Student name: Chelsea Valentine (cv851)
"""

#Assign matrix A's values:
A = [[1,2,3],[4,5,6],[7,8,9]]

#Show matrix A's values:
print("Matrix A:")
for i in range(0, len(A)):
    for j in range(0, len(A)):
        print(A[i][j], end='  ')
    #start new row
    print()
print()

#Assign matrix B's values:
B = [[10, 11, 12], [13, 14, 15], [16, 17, 18]]

#Show matrix B's values:
print("Matrix B:")
for i in range(0, len(B)):
    for j in range(0, len(B)):
        print(B[i][j], end='  ')
    print()
print()

print("If we add those two matrices together, we get...")
#Create C to make space to add A & B's entries
C=[[0,0,0], [0,0,0], [0,0,0]]

#Add A + B's entries to get C's entries
for i in range(0, len(B)):
    for j in range (0, len(B)):
        (C[i][j]) = (A[i][j]) + (B[i][j])

#Show matrice C's values
print("Matrix C:")
for i in range(0, len(B)):
    for j in range (0, len(B)):
        print(C[i][j], end='  ')
    print()
