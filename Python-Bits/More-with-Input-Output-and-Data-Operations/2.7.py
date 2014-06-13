"""

Problem 2.7 - Using print for different formatting

Write a program which:

1. initializes a variable called a with 123 and prints value of a over 7 places

2. initializes a variable called b with -89.6548754 and prints value of b over 10 places and with floating point precision of 4

3. initializes a variable called c with 'b' and prints character on screen

4. initializes a variable called d with 19.987243 and prints value of d with floating point precision of 2

"""

a = 123
b = -89.6548754
c = 'b'
d = 19.987243

print("a value is {:7}".format(a))
print("b value is {:10.4f}".format(b))
print("c value is", c)
print("d value is {:.2f}".format(d))
