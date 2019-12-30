
//Ogaddinma Enwereji
//4-18-19
//Assignment No. 7

import java.util.*;

public class Intcoll
{
   private int[] c; //array only accessible in class

   //default constructor
   public Intcoll()
   {
      	c = new int[500+1];
      	c[0] = 0;
   }

   //alternate constructor
   public Intcoll(int i)
   {
      	c = new int[i+1];
    	c[0] = 0;
   }

   /*copy the content of a collection into an object 
    * if the object and the collection are not the same
    */
   public void copy(Intcoll obj)
   {
      	if (this != obj)
      	{
	    c = new int[obj.c.length];
	    int j = 0;
	    while (obj.c[j] != 0)
	    {
		c[j] = obj.c[j]; j++;
	    }
	    c[j] = 0;
	}
   }

   /*return a true or false value if the inserted integer 
    * is not 0 or the integer already exist within the collection*/
   public boolean belongs(int i)
   {
      	int j = 0;
      	while ((c[j] != 0)&&(c[j] != i)) j++;
      	return (c[j] != 0);
   }

   /*inserting an integer in a collection by first traversing the array and check whether a 0 or repeats occur
    * Second, if the last index is 0, expand length of collection*/
   public void insert(int i)
   {
      	if (i > 0)
	{
	    int j = 0;
	    while ((c[j] != 0) && (c[j] != i)) j++;
	    if (c[j] == 0)
	    {
		if (j == c.length - 1)
		{
			int d[] = c;
			int x = c.length;
			int y = c.length+1;
			
			c = new int[y];
			
			for(int k = 0; k < x; k++) {
				c[k] = d[k];
			}
		}
		c[j] = i; c[j + 1] = 0;
	    }
	}
   }

   /*Omit integer from collection if integer already exists
    * Similar to insert method, traverse the array until you reach the desired integer
    * remove it and place 0 at the end again*/
   public void omit(int i)
   {
       if (i>0)
       {
      	  int j = 0;
      	  while ((c[j] != 0)&&(c[j] != i)) j++;
      	  if (c[j] == i)
      	  {
             int k = j+1;
             while (c[k] != 0) k++;
             c[j] = c[k-1]; c[k-1]=0;
      	  }
       }
   }

   //return the number of integers in the collection
   public int get_howmany()
   {
      	int j=0, howmany=0;

      	while (c[j]!=0) {howmany++; j++;}
      	return howmany;
   }

   //print the contents of the collection
   public void print()
   {
      	int j = 0;
      	System.out.println();
      	while (c[j] != 0)
      	{
           System.out.println(c[j]); j++;
      	}
   }

   /*comparing the content of the object and the collection 
   and upon examination determine whether or not the lists are the same*/
   public boolean equals(Intcoll obj)
   {
      	int j = 0; boolean result = true;
      	while ((c[j] != 0)&&result)
      	{
           result = obj.belongs(c[j]); j++;
      	}
      	j = 0;
      	while ((obj.c[j] != 0)&&result)
      	{
           result = belongs(obj.c[j]); j++;
      	}
      	return result;
   }
}
