'''
FVCproductions
Set Theory
Program 1
Written in Python 3
'''

'''
 
Create two sets A and B with set A = {1, 2, 3, 4, 5} and set B = {4, 5, 6, 7, 8}.
 
Write a program to perform the set operations:
A ∪ B,  A ∩ B,  A – B,  and  B – A.

'''

A = {1,2,3,4,5}
B = {4,5,6,7,8}

# A

print("A = " + str(list(A)) + "\n")

# B

print("B = " + str(list(B)) + "\n")

# A union B

print("A Union B = " + str(list(A.union(B))) + "\n")

# A intersect B

print("A Intersect B = " + str(list(A.intersection(B))) + "\n")

# A - B

print("A - B = "  + str(list(A.difference(B))) + "\n")

# B - A

print("B - A = "  + str(list(B.difference(A))) + "\n")

input("Press any key to continue...")