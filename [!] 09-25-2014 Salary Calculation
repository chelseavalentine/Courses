# Calculates an employee's salary based upon hours worked and pay per hour.
"""
Assignment: 
- calculate an employee's salary based upon the straight pay (amount owed to worker for work less than or equal to 40 hours)
- and overtime pay (amount owed to worker for work done after 40 hours, 1.5*rate if worked overtime), then add both to get the
- total pay.
"""

print("Hello employee, welcome to the salary calculator!")

#Get hours and pay rate from employee
x=(int(input("How many hours have you worked? ")))
print("Wow...",x,"hours? I smell a promotion coming soon.")
y=(int(input("How much do you get paid per hour (in dollars)? ")))

#Show straight pay, overtime pay, and total pay
print("Your straight pay:", "$"+ str( ((x<40)*y*x) or (y*40))+ ".")
print("Overtime pay:", "$"+str(int(float((x>40)*1.5*y*(x-40))))+".")

a=int(str(((x<40)*y*x)) and str(((x>=40)*y*40)))
b=int(str(int(float((x>40)*1.5*y*(x-40)))))

print("Total pay:", "$"+str((a+b) or str( ((x<40)*y*x) or (y*40))))
print("Have a nice day!")
