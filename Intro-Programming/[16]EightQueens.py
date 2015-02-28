"""
Assignment name: Eight Queens Problem
Student name: Chelsea Valentine (cv851)
"""

from itertools import permutations #Going to use permutations to get all of the unique combinations

n=8 #the number of rows
columns = [0, 1, 2, 3, 4, 5, 6, 7] #the chess board has 8 rows and 8 columns
count = 0 #Keep track of the number of solutions!
for pos in permutations(columns):
    ##Check whether there are 8 positions on the board in the set, which will happen if there
    ##aren't queens on the diagonal, column, or row
    if n == len(set(pos[i]-i for i in columns)) and n == len(set(pos[i]+i for i in columns)):
        count+=1
        print("Solution #", count, " is: ", list(pos), sep='' ) #display all of the possible combos in list form

print()
print("There are ", count, " solutions!", sep='')