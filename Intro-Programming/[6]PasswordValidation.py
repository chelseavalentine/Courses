##Password Validation Program
#Name: Chelsea Valentine

#Request a password from the user:
password = int(input("Please choose a 2-digit password in which both digits are even: "))

#See whether the user followed the directions correctly
while True:
    if  99>password>9 and (password%10)%2 == 0 and (password//10)%2 == 0:
        break
    else:
        password = int(input("The password you entered doesn't meet our standards. Please choose a 2-digit password in which both digits are even: "))


#accumulative variable to use the range function
tries = 0

#check whether passwords match up
for tries in range (0,3):

    #Ask the user to input the password they chose.
    enteredPassword = int(input("Please enter the password that you chose: "))

    if enteredPassword == password:
        print ("Correct! You may access the system.")
        break

    else:
        print ("Invalid password. Try again.")
        tries += 1

if tries == 3:
    print ("Too many invalid attempts. Please try again later.")
