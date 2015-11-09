# FVCproductions
# Dijkstra's Short Code Stub
# Python 3

# importing necessary heap class

import heapq

# checking for file existing or not

import os.path

# calculating shortest distance
# using Dijstra's Shortest-Path Algorithm
#
# dijkstra(w,a,z,L) {
#	L(a) = 0
#
#	while (z is an element T) {
#		choose v an element of T with minimum L(v)
#		T = T - {v}
#		for each x an element of T adjacent to v
#			L(x) = min{L(x), L(v) + w(v, x)}

def Dijkstras(graph, start, end):

   queue = [(0, start, [])]
   seen = set()

   while True:

      (cost, v, path) = heapq.heappop(queue)

      if v not in seen:

         path = path + [v]
         seen.add(v)

         if v == end:
            return cost, path

         for (next, c) in graph[v].items():

            heapq.heappush(queue, (cost + c, next, path))

# function to print graph

def graph():

   # graph will be a dictionary

   graph = {}

   # asking user to enter filename with data in it

   inputFile = input('Enter the file: ')

	# make sure file exists

   if (os.path.exists(inputFile)):
      print("")
   else:
      print("\nFile is missing.")

   # open the file

   file = open(inputFile, 'r')

   # Set the number of Undirected Edges to 0

   numUndirectedEdges = 0

   # variables for graph input

   fromEdge = []
   toEdge = []
   distance = []

   # Print a heading for the graph edges

   print("The edges of the graph\n")

   # splitting lines from file to traverse through them
   # Process the graph file

   for lines in file:

      nums = lines.split()

      # fromEdge, toEdge - adding on to respective dictionaries

      fromEdge.append(nums[0])
      toEdge.append(nums[1])
      distance.append(int(nums[2]))

      # Print the edge

      print (fromEdge[numUndirectedEdges] + " " + toEdge[numUndirectedEdges] + " " + str(distance[numUndirectedEdges]))

      # fromEdge is key in dictionary

      if fromEdge[numUndirectedEdges] not in graph:
         graph[fromEdge[numUndirectedEdges]] = {toEdge[numUndirectedEdges]:distance[numUndirectedEdges]}
      else:
         graph[fromEdge[numUndirectedEdges]][toEdge[numUndirectedEdges]] = distance[numUndirectedEdges]

      # incrementing numUndirectedEdges by 1

      numUndirectedEdges += 1;

   # print(graph)

   start = input("\nEnter start: ")
   end = input("\nEnter end: ")

   return graph, start, end


# defining our initial graph

graph, start, end = graph()

# printing results

print (Dijkstras(graph, start, end))

input = input("\nEnter a new file to continue: ")
