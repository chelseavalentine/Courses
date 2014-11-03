"""
Assignment Name: Class Grade List -- 2nd Attempt
Assignment Details:
  We want a program that will allow us to print a “grade list” of the students in a class.
  
  The program should loop, asking for a name, midterm score, and final score. It should then echo 
the input, and print the information entered, plus the student’s average.
  
  To exit the loop, the user enters ”done” in lower case. The program will print the summary 
information in a table (see above) including each student’s deviation from the class average. The 
program then prints the class average on the last line and then terminates.

Name: Chelsea Valentine (cv851)
"""

#define accumulative variables
midtermTotal = 0
finalTotal = 0
nameCount = 0

#create names, midterms, finals, & average lists
names = []    
midterms = []
finals = []
averageFinalMidterm = []

#Ask for the information
while True:
    name = input("Please enter the student's name (type done to stop): ")
    if name == "done":
        break
    names.append(name)
    nameCount += 1
    
    midterm = float(input("Please enter the student's midterm: "))
    midtermTotal += midterm
    midterms.append(midterm)
    
    final = float(input("Please enter the student's final: "))
    finalTotal += final
    finals.append(final)

    #Add to averageFinalMidterm list
    averageFinalMidterm.append(float((final+midterm)/2))
    print()

#compute class average
totalScore = midtermTotal + finalTotal
totalCount = 2 * nameCount
classAverage = float(totalScore/totalCount)


###Print the Name, Midterm, Final, Average, and Deviation to the user

#First print the header row
print(format("Name", '<20s'), format("Midterm", '>8s'), format("Final", '>10s'), format("Average", '>10s'), format("Deviation", '>11s') , sep='')
print()

#Create a for loop to print the names
for i in range(0,nameCount):
    print(format(names[i], '<20s'), end='')
    print(format(midterms[i], '>8.2f'), end='')
    print(format(finals[i], '>10.2f'), end='')
    print(format(averageFinalMidterm[i], '>10.2f'), end='')
    print(format(averageFinalMidterm[i] - classAverage, '>11.2f'))
    i += 1

print()
print("The class average is:", format(classAverage, '.2f'))
