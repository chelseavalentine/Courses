"""
Assignment: Sieve of Eratosthenes - Take 2
Student name: Chelsea Valentine
"""

#given code, which generates list x
x=[]
for i in range (2,100):
    x.append(i)
primes=[]

#Get the first element of x, call it k

while len(x) > 1:
    #get the first element of x, call it k, and add it to the primes
    k=x.pop(0)
    primes.append(k)

    #check to see if any multiples of k are in x, if they are, remove them
    for j in range(0, len(x)):
        if j*k in x:
            x.remove(j*k)
            
print(primes)

