"""
Assignment Title: Class Grade List -- 1st Attempt
Assignment Details:
  We want a program that will allow us to print a “grade list” of the students in a class.
  
  The program should loop, asking for a name, midterm score, and final score. It should then echo 
the input, and print the information entered, plus the student’s average.

  To exit the loop, the user enters ”done” in lower case. The program will print the class average 
and then terminate.
Student: Chelsea Valentine (cv851)
"""

#Accumulative variables
classtotal = 0
numberofentries = 0

#Ask for information
while True:
    name = input("Please enter the student's name (or type 'done' to end): ")

    #Exit the loop if the user types 'done'
    if name == "done":
        break
    
    midterm = float(input("Please enter his/her midterm grade: "))
    final = float(input("Please enter his/her grade on the final: "))

    #Add to the accumulative variables
    classtotal += (midterm + final)
    numberofentries += 2

    #Print the student's name, scores, and average
    print("Name:", name, "Midterm:", format(midterm, '.1f'), "Final:", format(final, '.1f'), "Average:", format((midterm + final)/2 , '.1f' ))

#Give the class average
print("The class average is", classtotal/numberofentries)
