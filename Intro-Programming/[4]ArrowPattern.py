"""
Assignment:
- Write a program that prompts the user for a number of columns, and then prints out a pattern that looks like an
- arrow that first goes to the right, and then the left.
- Keep asking for a value and printing the pattern until the user enters 'done'.
"""

##Arrow Pattern Program; Assignment #4; Chelsea Valentine

#Ask user to input a number of columns
cols = int(input("How many columns do you want to produce? (Enter a number greater than 0): "))

while cols != "done":
        spaces = 0

        #create the pattern going to the right
        while spaces != (cols - 1):
                print (' ' * (spaces) + '*')
                spaces += 1
        
        #create the pattern going to the left
        while spaces != -1:
            print (' ' * spaces + '*')
            spaces -=1
        
        #Ask user whether they want to continue
        cols = int(input("How many columns do you want to produce? (type 'done' to end): "))
