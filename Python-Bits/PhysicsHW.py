
import math

'''


period = .49
amplitude = 5.4
mass = .27

'''

var = float(float((float(.27) * float(4) * float((math.pi*math.pi)) * float(5.4) * float((10**-2))) / float(((.49)**2))))

print var
print var/(.054)

'''
The piston in the cylinder head of a locomotive has a stroke (twice the amplitude) of 0.63 m. 
If the piston moves with simple harmonic motion with an angular frequency of 170 rev/min, what is its maximum speed?

.315
'''



var = 170 * .1047
var_1 = var * .315

print var
print var_1


'''
Caught in an avalanche, a skier is fully submerged in flowing snow of density 88 kg/m3. 
Assume that the average density of the skier, clothing, and skiing equipment is 1040 kg/m3. 
What percentage of the gravitational force on the skier is offset by the buoyant force from the snow?
'''

var = (float(88)/1040) * 100
print var


'''
A block of wood floats in fresh water with 0.812 of its volume V submerged and in oil with 0.913 V submerged. 
Find the density of (a) the wood and (b) the oil.
'''

var = (float(.812))*(10**3)
print var

var_1 = float(812)/(.913)
print var_1

'''
What is the fastest transverse wave that can be sent along a given wire? 
For safety reasons, the maximum tensile stress to which this wire should be subjected is 9.40 b. 
The density of the wire is 7690 kg/m3. Note that your answer does not depend on the diameter of the wire.
'''

var = math.sqrt((9.4*10**8)/(7690))
print var