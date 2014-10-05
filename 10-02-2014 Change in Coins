"""
Assignment:
- Write a program to provide change in coins.
- The user should input an amount of money, and then you output the minimum number of coins needed to create that amount.
- The coins should be in denominations of half-dollars, quarters, dimes, nickels, and pennies.
- Print the each denomination on their own line.
"""

#Change in Coins Program: Chelsea Valentine

#Ask user for money input
money = float(input("How much money do you want to convert into change?: "))

#divide amount of money inputted into the denominations
halfdollars = int(money / 0.50)
quarters =  int( (money - (halfdollars * 0.50)) / 0.25 )
dimes = int( (money - (halfdollars * 0.50 + quarters * 0.25 )) / 0.10 )
nickels = int( (money - (halfdollars * 0.50 + quarters * 0.25 + dimes * 0.10)) / 0.05 )
pennies = int( (money - (halfdollars * 0.50 + quarters * 0.25 + dimes * 0.10 + nickels * 0.05)) / 0.01 )


#output
print("Your change is:")
print("Half-dollars:", halfdollars)
print("Quarters:", quarters)
print("Dimes:", dimes)
print("Nickels:", nickels)
print("Pennies:", pennies)
