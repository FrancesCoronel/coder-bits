"""

Problem 2.5 - Time Calculation II

Write a program where you can enter values for minutes from keyboard. Your program should transform and print corresponding values in hours and minutes. Please make sure that entered value will be transformed only if it is a positive value. In case of a negative value print on screen a corresponding message.

"""


minute = int(input("Enter minutes: "))
hour = minute//60
remainder = minute%60

if minute < 0:
	print ("Your integer is negative, try again. ")
else:
	print("Hour: ", hour)
	print("Minutes: ", remainder)

