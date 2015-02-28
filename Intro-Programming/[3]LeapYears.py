"""
Assignment:
- Write a program that asks the user to input a integer greater than 0 & less than 2500.
- If x isn't within the range, print "Out of Range" and have the program stop
- Otherwise, determine whether x is a leap year.
- Depending on if it is, print the value of x and "is a leap year." or "is not a leap year."
"""

# Leap Years Program: Chelsea Valentine

#ask user to input number of years
x = int(input("Please enter a number of years that is between 0 and 2500: "))

#check if user followed directions
if 0>=x or x>=2500:
    print("Out of range.")

else:
    if (x%4==0):
        print( x, "is a leap year.")

    else:
        print (x, "is not a leap year.")
