"""
Assignment name: How Many Steps?
Assignment details: Order each of the classes by height in the way you're instructed to.
Student name: Chelsea Valentine (cv851)
"""
import random

#define function
def sortClass(a):
    global steps
    steps = 0 
    #go through the list
    for i in range (1, len(a)):
        originalPosition = i
        ##Move the students until they are standing in front of someone who is taller
        while originalPosition > 0 and a[originalPosition] < a[originalPosition-1]:
            a[originalPosition], a[originalPosition-1] = a[originalPosition-1], a[originalPosition]
            originalPosition -= 1
            ##Count steps
            steps += 1
    
#Get number of data sets from the user & create empty list to hold the data
n = int(input("How many classes of students do you want to order? "))
classes = []
countSteps = []

#Create an empty list for each individual class
for i in range(0, n):
    classes.append([])
    countSteps.append(0)
    
    #Generate random heights within 900 to 1000mm for each child's height
    for j in range (20):
        classes[i].append(random.randint(900, 1000))

#Report the classes' heights back to the user
print()
print("The heights (mm) of the children in each class are as follows:")

for i in range(n):
    print(i+1, end=' ')
    for j in range(20):
        print (classes[i][j], end=' ')
    print()

#Add the steps of each individual class to the countSteps list
for i in range (n):
    sortClass(classes[i])
    countSteps[i] += steps

#Report the number of steps back to the user
print()
print("The steps it took to sort each class are as follows:")
for i in range (n):
    print(i+1, end=' ')
    print(countSteps[i])
