/*
 *  Dijkstra's Shortest-Path Algorithm
 */

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class ShortestPathSTUB {
  // Variables for vertices in the graph
  static String[] vertex = new String[100];
  static String[] path = new String[100];
  static int[] value = new int[100];
  static boolean[] circled = new boolean[100];

  static int numberOfVertices;
  static final int INFINITY = 1000;

  /*
   * Find the index of a vertex
   */
  public static int IndexOf(String s) {
    for (int i = 0; i < numberOfVertices; i++)
      if (s.equals(vertex[i]))
        return i;
    return -1;
  }

  /*
   * Dijkstra's Shortest-Path Algorithm
   */
  public static void main(String[] args) throws IOException {
    String input;

    // Variables for inputing the graph
    String[] from = new String[100];
    String[] to = new String[100];
    int[] distance = new int[100];

    int numberOfUndirectedEdges;

    // Miscelleanous variables
    int i;
    int j;

    // Create a Scanner object for keyboard input
    Scanner keyboard = new Scanner(System.in);

    // Get the filename
    System.out.print("Enter the filename: ");
    String filename = keyboard.nextLine();
    System.out.println(" ");

    // Make sure the file exists
    File file = new File(filename);
    if (!file.exists()) {
      System.out.println("File " + filename + " does not exist");
      System.exit(0);
    }

    // Open the file
    Scanner inputFile = new Scanner(file);

    // Set the number of Undirected Edges to 0
    numberOfUndirectedEdges = 0;

    // Print a heading for the graph edges
    System.out.println("The edges of the graph\n");

    // Process the graph file
    while (inputFile.hasNext()) {
      // Read a line from the graph file
      input = inputFile.nextLine();

      // Create a Tokenizer object
      StringTokenizer st = new StringTokenizer(input);

      // From and To direction
      from[numberOfUndirectedEdges] = st.nextToken();
      to[numberOfUndirectedEdges] = st.nextToken();
      distance[numberOfUndirectedEdges] = Integer.valueOf(st.nextToken());

      // Print the edge
      System.out.println(from[numberOfUndirectedEdges] + " " + to[numberOfUndirectedEdges] + " " + distance[numberOfUndirectedEdges]);

      // To and From direction
      from[numberOfUndirectedEdges + 1] = to[numberOfUndirectedEdges];
      to[numberOfUndirectedEdges + 1] = from[numberOfUndirectedEdges];
      distance[numberOfUndirectedEdges + 1] = distance[numberOfUndirectedEdges];

      numberOfUndirectedEdges += 2;
    }

    // Close the file
    inputFile.close();
    System.out.println(" ");

    // Get the starting vertex
    System.out.print("Enter the starting vertex: ");
    String start = keyboard.nextLine();

    // Get the ending vertex
    System.out.print("Enter the ending vertex: ");
    String end = keyboard.nextLine();
    System.out.println(" ");

    // Create an array of the vertices
    numberOfVertices = 0;

    // Create an array of all the vertices
    for (i = 0; i < numberOfUndirectedEdges; i++) {
      // Look to see if we already have this vertex
      boolean exists = false;

      for (j = 0; j < numberOfVertices; j++)
        if (from[i].equals(vertex[j]))
          exists = true;

      // Add this vertex to the array
      if (!exists)
        vertex[numberOfVertices++] = from[i];
    }
    static void Dijkstra(Graph G, int s, int[] D) {
      int v;                              // The current vertex
      DijkElem[] E = new DijkElem[G.e()]; // Heap for edges
      E[0] = new DijkElem(s, 0);          // Initial vertex
      MinHeap<DijkElem> H = new MinHeap<DijkElem>(E, 1, G.e());
      for (int i = 0; i < G.n(); i++)     // Initialize distance
        D[i] = Integer.MAX_VALUE;
      D[s] = 0;
      for (int i = 0; i < G.n(); i++) {   // For each vertex
        do { v = (H.removemin()).vertex(); }    // Get position
        while (G.getMark(v) == VISITED);
        G.setMark(v, VISITED);
        if (D[v] == Integer.MAX_VALUE) return;  // Unreachable
        for (int w = G.first(v); w < G.n(); w = G.next(v, w))
          if (D[w] > (D[v] + G.weight(v, w))) { // Update D
            D[w] = D[v] + G.weight(v, w);
            H.insert(new DijkElem(w, D[w]));
          }
      }
    }
    static int Dijkstra(Graph G) {
      for (int i = 1; i < n; i++) {
        L(v[i]) = INFINITY;
      }
      S = NULL;
      L(a) = 0;
      while (z != S[i]) {
        u = ;
        S = S + {u};
        for (all vertices v not in S) {
          if (L(u) + w(u, v) < L(v)) {
            L(v) = L(u) + w(u, v);
          }
        }
      }
      return L(z);
    }
    //
    // procedure Dijkstra(G)
    // for i := 1 to n
    //  L(v[i]) := INFINITY
    //
    //
    // S := NULL
    //
    //
    // L(a) := 0
    //
    //
    // while z is NOT an element of S
    //
    //
    //  u := a vertex not in S with L(u) minimal
    //
    //
    //  S := S + {u}
    //
    //
    //  for all vertices v not in S
    //
    //
    //    if L(u) + w(u, v) < L(v) then L(v) := L(u) + w(u, v)
    //
    //
    // return L(z)
    //

  }
}
