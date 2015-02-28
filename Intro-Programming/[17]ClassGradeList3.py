"""
Assignment name: Class Grade List - One Last Time
Student name: Chelsea Valentine (cv851)
"""

input = open('scores.txt') #tell Python the file you want to read from
docString = input.readlines() #Convert, one line/entry
data = [] #Create an empty list to hold the data
for i in docString: #Split every line into individual data points
    split = i.split()
    data.append(split) #Add the data to the data list to be used later
"""
Right now, data is a 2-dimensional list, so that for any list, x, within
the list,
[x][0] = First name
[x][1] = Last name
[x][2] = Midterm grade
[x][3] = Final grade
"""

#Create a file to hold the results
output = open('results.txt', 'w')

#Calculate each student's average, then add it to the data list
for i in range (len(data)):
    averageNow = (float(data[i][3]) + float(data[i][2]))/2
    data[i].append(format(averageNow, '.2f')) #Average

#find average of the students' averages
average = 0
for i in range(len(data)):
    data[i][4] = float(data[i][4])
    average += data[i][4]
average /= len(data)

#Calculate each student's deviation, then add it to the data list; also add a line break
for i in range(len(data)):
    data[i].append(format(data[i][4]-average, '.2f'))
    data[i].append('\n')
print(data)

"""
Now, data has the additional entries, so that for any list, x, within the list,
[x][4] = Average
[x][5] = Deviation
[x][6] = line break
"""

#Convert each data entry into a string
for i in range(len(data)):
    for j in range (len(data[i])):
        if j != 6:
            data[i][j] = str(data[i][j]) + " "
        output.writelines(data[i][j])
output.close()


resultsString = open('results.txt', 'r') #tell Python the file you want to read from

#Header for output
print(format("Name", '>16s'), format("Midterm", '>10s'), format("Final", '>10s'), format("Average", '>10s'), format("Deviation", '>10s'), sep='')

#Print data
results = []
for i in resultsString: #Split every line into individual data points
    split = i.split()
    results.append(split) #Add the data to the data list to be used later

#Now display the data in the table
for i in range(len(results)):
    for j in range(len(results[i])):
        if j==0:
            print(format(results[i][j] + " " + results[i][j+1], '>16s'), end='')
        elif j==1:
            continue
        else:
            print(format(float(results[i][j]), '>10.2f'), end='')
    print()