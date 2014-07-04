"""

Problem 2.4 - Fahrenheit and Celcius

Write a program that converts Celsius degrees to Fahrenheit degrees. You should be able to enter a number from keyboard, then result should be printed on screen. Conversion formula from Celsius to Fahrenheit is following:

F = (9/5)*C + 32

Print corresponding messages if temperature is below 32 F or above 104 F. 

"""

celsius = int(input("enter celsisus degrees: "))

fahrenheit = 9/5*celsius+32

if fahrenheit < 32:
	print ("Your converted fahrenheit temperature of", fahrenheit, "is below 32 degrees F")
elif fahrenheit > 104:
	print ("Your converted fahrenheit temperature of", fahrenheit, "is above 104 degrees F")
else: 
	print ("Your converted fahrenheit temperature is", fahrenheit)
