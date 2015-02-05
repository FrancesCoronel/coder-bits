Chun-Wei Chen
CSE 332
Project 2 - Write-Up Questions

1.  Chun-Wei Chen
2.  Java API, lecture slides
    to compare the results of WordCount using different adt.
3.  I spent a lot of time working on this project. I don't remember 
    the exact time I used. I think every implementation of data structure, 
    except MoveToFrontList, are difficult. The project itself is ok, 
    I don't think there's anything needed to be changed. Maybe just 
    look through the discussion board, see the most common questions, 
    and then add the clarification about it to the description next time.
4.  none
5.  I looked at the BinarySearchTree's JUnit tests provided for the 
    project imitate them for other data structures. They test size of the 
    structure when constructed, size of the data after adding one data, 
    size of the structure after adding the same data (should remain the same 
    as adding one data), size of the structure after adding multiple data 
    including same duplicate, count of the data, and iterator for every data 
    structure. They also test some other things for different structure. JUnit 
    tests for AVLTree also test if the structure does rotation when it 
    encounters one of four cases which require rotation to maintain its 
    property, and test if it's a BinarySearchTree using string representation.
    JUnits test for Hashtable also test if the table rehashes when it tries to 
    store more value than its initial capacity allowed, and test if the table 
    handles collision correctly using string representation. JUnit tests for 
    FourHeap is kind of different. They test if the heap resizes when it tries 
    to store more value than its initial capacity allowed, and test if it 
    percolates up/down when insert/deleteMin data from the heap; they test size 
    of the structure when constructed and size of the data after adding one data 
    as well. For JUnit tests for sorting, I just used a random order integer array 
    to test each of the sorting algorithm. JUnit tests do not test different type 
    of data other than Integer. Boundary cases I considered are resizing when 
    trying to store more data than its capacity allowed into the structure and 
    throwing exception when calling next while hasNext is false.
6.  It uses stack to avoid recursive way to traverse through the tree. 
    I'm not sure how to change GStack interface to avoid this problem. My 
    solution is to write a new constructor in GArrayStack which takes an 
    positive integer value, the size of the stack, and create an array 
    of that size. By doing this, the code can pass in the size of the 
    tree to create the stack so that the stack won't need to be resized 
    during the iteration.
7.  For BinarySearchTree and AVLTree, implementing another version of 
    BinarySearchTree and AVLTree which takes a DataCountStringComparator as
    a constructor's argument in order to compare count of the data first, 
    and then pass in all the data from the original tree to a new tree sorted 
    by count instead of using alphabetical order. The new version of 
    BinarySearchTree/AVLTree store the data which had most count in the 
    left-most node and store the data which has the least count in the right-most 
    node. And then store the data in new tree in-order into an array, which is 
    being used by the iterator. Create a variable as index to check if the 
    there is more data to be iterated (hasNext()). When the iterator calls next, 
    return the data in the array correspond to index, and increment the index. 
    This will be more efficient than original printing way using insertionSort 
    (O(n^2)) since it's O(nlogn) (due to storing data into new tree), but not more 
    efficient than using heapSort or mergeSort since they are all O(nlogn). For 
    MoveToFrontList and Hashtable, I don't there is a way better than store all 
    the data into an array and then sort it in order to print out the data in 
    descending count order. If we want to make iterator return the data in 
    descending count order, we'll need to find the data which has most count 
    every time, which means go through all the list or table, compare one with 
    the others to figure out which has the most count (O(n^2)), return it and then 
    remove it from the list or mark deleted in the table. This is obviously less 
    efficient than store all the data in the array and then sort it.
8.  Comparator passed in must be able to compare two data's equality, and 
    Hasher passed in must be able to hash data into a non-negative integer
    and doesn't hash every data into the same integer.
9.  Please refer to ADTSortingTimer.java, StringHasher2.java, StringHasher3.java, 
    ADTSortingTimingHamlet.pdf, ADTSortingTimingHamletVesrion2Hasher.pdf, 
    ADTSortingTimingHamletVesrion3Hasher.pdf, 
    and ADTSortingTimingTheAdvancementOfLearning.pdf.
    I used Hamlet for text to collect timing information of different combinations of 
    abstract data type and sorting algorithm. I use System.currentTimeMillis() 
    above and below each WordCount.main to get start time and end time, and then 
    subtract start time from end time to get the total time used. Based on my 
    experimentation, BinarySearchTree + mergeSort ("-os") tends to produce the 
    fastest results. I collected timing information three times, all the results 
    show that BinarySearchTree + mergeSort is the fastest one. I use another text, 
    The Advancement Of Learning to run this exprimentation, and the result still 
    show that BinarySearchTree + mergeSort is the fastest. I write two different 
    versions of hash functions for the last part of the question. Using verion 2 
    hasher does seem to improve running time a little bit, and Using version 3 
    hasher makes running time of hash table with any sort less than 1000 ms. 
    Hashtable + heapsort/mergesort even less than 500 ms; however, they are still
    still not as fast as BinarySearchTree + mergesort. I do everything three 
    times to make sure the results I got are reasonable. 
10. Please refer to WordCount2.java, TopKTimer.java, and 
    WriteUpNo10Experimentation.pdf.
    I use merge sort for this experimentation. I ran the code, which computes the 
    time two ways of approach used to print K most-frequently occuring words, three 
    times and then calculated the mean of the time. Based on my experimentation and 
    my analysis of the data I got, nlogk approach seems to be worse than nlogn 
    approach when k is less than 4 or greater than 500. If I want to take 
    advantage of my experimental conclusions, I will impement both ways of 
    approach, and then add an if block for the value of k. If k is in the range 
    that nlogk is more effiecent than nlogn (4 <= k <= 500 in my experimentation), 
    then use nlogk approach to print K most-frequently occuring words; otherwise, 
    use nlogn approach to do so.
11. Please refer to CorrelatorResults.java, WriteUpNo11Experimentation.jpg, 
    and WriteUpNo11Experimentation.zip.
    No, my experimentation doesn't suggest that Bacon wrote Shakespeare's plays or 
    the other way around. I use King Lear, Romeo and Juliet, Macbeth by 
    Shakespeare and The Advancement of Learning, The Essays by Bacon along with 
    Hamlet and The New Atlantis in my experimentation. I first compute the 
    correlation between works by Bacon (The Advancement of Learning and 
    The Essays) and figure out correlation between Bacon's work, and compute 
    correlation between The New Atlantis and all the other works I use in the 
    experimentation. The result shows that The New Atlant is close to 
    The Advancement of Learning and The Essays but not close to Shakespeare's 
    works, although the correlations between The New Atlantis and the other two 
    Bacon's works are not pretty close to correlation between those two Bacon's 
    works. After this, I do the same thing for Shakespeare's work and Hamlet. 
    The result shows that Hamlet is close to King Lear and Macbeth. Afterwards, 
    I compute the correlations between the rest of the combinations. The result 
    of the rest of the combinations isn't close enough to suggest that one wrote 
    the other's works baed on the correlation between Shakespeare's/Bacon's works 
    I compute.
12. N/A