"""
Assignment name: Score the Race
Student name: Chelsea Valentine (cv851)
"""

#Ask the user for the race's results and verify that they followed the directions
while True:
    #Define accumulative variables and lists
    teamCount = 0
    verifyTeamsEqual =[]
    team = []
    scores = []
    storeWinner = 0
    notInTeam = 0
    
    userinput = input("Input the outcome of the race (or type 'done' to finish): ")

    #check if user wants to end the loop
    if userinput == 'done':
        break
    else:

        #convert the userinput into a list to be able to work with it
        list(userinput)
        for i in range (0, len(userinput)):
            verifyTeamsEqual.append(1)

        #Sort the list of runners that the user gave, alphabetically
        a = sorted(userinput)

        for i in range (0, len(a)):
            #Only add each letter to the official list of teams once, while working on checking for equal numbers of teammates
            if a[i] not in team:
                team.append(a[i])
                scores.append(0)
                notInTeam +=1
            if a[i] in team:
                teamCount += 1

        if teamCount%notInTeam != 0:
            print("Error! There aren't an equal number of runners on each team. Try again.")

        else:
            #Add up the scores of each of the teams based on the runners' placements
            for i in range(0, len(a)):
                for j in range(0, len(team)):
                    if userinput[i] == team[j]:
                        scores[j] += (i+1)

            #Print number of teams and runners per team
            print("There are", len(team), "teams.")
            print("There are", int(teamCount/len(team)), "runners per team")

            #print header to show result
            print("Team","Score", sep='\t')

            #print and format the results
            for i in range (0, len(team)):
                print (team[i], end='\t')
                print (format(scores[i]/ (teamCount/len(team)), '.2f'))

            #find winning team
            for i in range (0, len(team)):
                if scores[i] == min(scores):
                    storeWinner = i
                    
            #print winning team
            print("The winning team is team", team[storeWinner], "with a score of", format((scores[storeWinner]/ (teamCount/len(team))), '.2f'))
