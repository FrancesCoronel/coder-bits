"""

Problem 2.6 - Unexpected Operations

Write a program that deliberately makes following *mistakes*:
	- reads a string and an integer value and multiplies them. print result
	- reads a string and a floating point value and multiplies them. print result
	- reads 2 integer values without converting them to int. add these numbers (which are then actually strings). print result

Explain in comments the behavior (in case of error the reason of the error) for each of these 3 actions. In case of errors comment the corresponding lines.

"""

string_a = str(input("Enter a string please: "))
int_a = int(input("Enter integer value please: "))

print("String multiplied by integer value: ", string_a*int_a)

#string*int prints out string int number of times

#print("\n")
#string_b = str(input("Enter a string please: "))
#float_b = float(input("Enter a float number please: "))
#print("String multiplied by float value: ", string_b*float_b)
# cannot multiply sequence by non-int of type 'float'

print("\n")

int_c = input("Enter your first integer value: ")
int_d = input("Enter your second integer value: ")

print("Integers added together: ", int_c + int_d)

# when asking for input, the type of input must be clarified
# so if input is meant to be a float or int, that must be put into the code
# otherwise it is assumed the input is in string format
# this is why entering 3 and 4 results in 34 instead of 7, they are considered strings