"""
Assignment:
- Write a program that inputs an integer n and prints an nXn multiplication table.
"""

## Multiplication Table Program ; Chelsea Valentine
#works best for n values under 10

# ask user for an input
n = int(input("Input a number to create your multiplication table: "))
last_entry_in_row = n

#print the horizontal header
print ('    ', end='')
for n in range (1, n+1):
    print (n, end='  ')
    
#print the dashed line
print(end= '\n')
print ('   ', ((n)*3-2)*'-', end='\n')

#print the vertical header
for n in range (1, n+1):
    print (str(n)+'* ', end= '')

    #print the entries on that vertical header's row
    entry = 1
    while entry != (last_entry_in_row + 1):
        print (format( entry * n, '2d'), end=' ')
        entry += 1

    #move to the next vertical header
    print (end='\n') 
