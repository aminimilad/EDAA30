import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;

public class Test {
	int[][] unsolvable_Array = {
		       {9, 1, 1, 1, 0, 0, 0, 0, 5},
	           {0, 0, 5, 0, 9, 0, 2, 0, 1},
	           {8, 0, 0, 0, 4, 0, 0, 0, 0},
	           {0, 0, 0, 0, 8, 0, 0, 0, 0},
	           {0, 0, 0, 7, 0, 0, 0, 0, 0},
	           {0, 0, 0, 0, 2, 6, 0, 0, 9},
	           {2, 0, 0, 3, 0, 0, 0, 0, 6},
	           {0, 0, 0, 2, 0, 0, 9, 0, 0},
	           {0, 0, 1, 9, 0, 4, 5, 7, 0}
    };
	int[][] solvable_Array = {
            {5, 1, 6, 8, 4, 9, 7, 3, 2},
            {3, 0, 7, 6, 0, 5, 0, 0, 0},
            {8, 0, 9, 7, 0, 0, 0, 6, 5},
            {1, 3, 5, 0, 6, 0, 9, 0, 7},
            {4, 7, 2, 5, 9, 1, 0, 0, 6},
            {9, 5, 8, 3, 7, 0, 0, 5, 0},
            {2, 0, 3, 1, 8, 6, 0, 7, 4},
            {6, 8, 4, 2, 0, 7, 5, 0, 0},
            {7, 9, 1, 0, 5, 0, 6, 0, 8}
    };



	int[][] figur1_Array = {
			   {0, 0, 8, 0, 0, 9, 0, 6, 2},
			   {0, 0, 0, 0, 0, 0, 0, 0, 5},   
			   {1, 0, 2, 5, 0, 0, 0, 0, 0},
			   {0, 0, 0, 2, 1, 0, 0, 9, 0},
			   {0, 5, 0, 0, 0, 0, 6, 0, 0},
			   {6, 0, 0, 0, 0, 0, 0, 2, 8},
			   {4, 1, 0, 6, 0, 8, 0, 0, 0},
			   {8, 6, 0, 0, 3, 0, 1, 0, 0},
			   {0, 0, 0, 0, 0, 0, 4, 0, 0},
 };

	
	
	int[][] empty_Array = {
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},   
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
			   {0, 0, 0, 0, 0, 0, 0, 0, 0},
 };	
	
	 Sudoku solution_solvable; 
	 Sudoku solution_unsolvable; 
	 Sudoku solution_figur1; 
	 Sudoku solution_empty; 


	@Before
	public void setUp() throws Exception {	
		/// den falska Array 
		
		solution_solvable = new Sudoku(solvable_Array);
		solution_unsolvable = new Sudoku(unsolvable_Array);
		solution_figur1 = new Sudoku(figur1_Array);
		solution_empty = new Sudoku(empty_Array);
	}

	@After
	public void tearDown() throws Exception {
		solution_solvable = null;	
		solution_unsolvable  = null;
		solution_figur1 = null;
		solution_empty =  null;
	}
	
	public final void check_Row(){
		/*  
		 *{5, 1, 6, 8, 4, 9, 7, 3, 2},
          {3, 0, 7, 6, 0, 5, 0, 0, 0},
          {8, 0, 9, 7, 0, 0, 0, 6, 5},
          {1, 3, 5, 0, 6, 0, 9, 0, 7},
          {4, 7, 2, 5, 9, 1, 0, 0, 6},
          {9, 5, 8, 3, 7, 0, 0, 5, 0},
          {2, 0, 3, 1, 8, 6, 0, 7, 4},
          {6, 8, 4, 2, 0, 7, 5, 0, 0},
          {7, 9, 1, 0, 5, 0, 6, 0, 8} 
		 */ 
		
	///	assertEquals("", solution_solvable.checkRow(row, col, nbr),false);
		assertEquals("Fail in checkRow(method) for coordinates(1,1) in solvable_Array  ", solution_solvable.checkRow(1, 1, 2),false );
		assertEquals("Fail in checkRow(method) for coordinates(2,1) in solvable_Array ", solution_solvable.checkRow(2,  1, 4),false);

	    /* {0, 0, 8, 0, 0, 9, 0, 6, 2},
		   {0, 0, 0, 0, 0, 0, 0, 0, 5},   
		   {1, 0, 2, 5, 0, 0, 0, 0, 0},
		   {0, 0, 0, 2, 1, 0, 0, 9, 0},
		   {0, 5, 0, 0, 0, 0, 6, 0, 0},
		   {6, 0, 0, 0, 0, 0, 0, 2, 8},
		   {4, 1, 0, 6, 0, 8, 0, 0, 0},
		   {8, 6, 0, 0, 3, 0, 1, 0, 0},
		   {0, 0, 0, 0, 0, 0, 4, 0, 0},
		      
		*/
		assertEquals("Fail in checkRow(method) for coordinates(0,0) in figur1_Array ", solution_figur1.checkRow(0,  0, 3),false);

	  /*  
	       {9, 1, 1, 1, 0, 0, 0, 0, 5},
           {0, 0, 5, 0, 9, 0, 2, 0, 1},
           {8, 0, 0, 0, 4, 0, 0, 0, 0},
           {0, 0, 0, 0, 8, 0, 0, 0, 0},
           {0, 0, 0, 7, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 2, 6, 0, 0, 9},
           {2, 0, 0, 3, 0, 0, 0, 0, 6},
           {0, 0, 0, 2, 0, 0, 9, 0, 0},
           {0, 0, 1, 9, 0, 4, 5, 7, 0}
            */
		assertEquals("Fail in checkRow(method) for coordinates(1,1) in unsolvable", solution_unsolvable.checkRow(1,  1, 6),false);
		assertEquals("Fail in checkRow(method) for coordinates(2,2) in unsolvable", solution_unsolvable.checkRow(2,  2, 9),false);

		
		
		assertEquals("Fail in checkRow(method) in Empty", solution_empty.checkRow(2,  2, 9),false);

	}
	
	public final void check_Colummn(){
		/*  
		 *{5, 1, 6, 8, 4, 9, 7, 3, 2},
          {3, 0, 7, 6, 0, 5, 0, 0, 0},
          {8, 0, 9, 7, 0, 0, 0, 6, 5},
          {1, 3, 5, 0, 6, 0, 9, 0, 7},
          {4, 7, 2, 5, 9, 1, 0, 0, 6},
          {9, 5, 8, 3, 7, 0, 0, 5, 0},
          {2, 0, 3, 1, 8, 6, 0, 7, 4},
          {6, 8, 4, 2, 0, 7, 5, 0, 0},
          {7, 9, 1, 0, 5, 0, 6, 0, 8} 
		 */ 
		
	    assertEquals("Fail in checkColonn(method) in solvable array", solution_solvable.checkColonn(1,  1, 9),true);
		assertEquals("Fail in checkColonn(method) in solvable array", solution_solvable.checkColonn(2,  1, 4),false);		
		assertEquals("Fail in checkColonn(method) in solvable array", solution_solvable.checkColonn(3,  3, 4),false);		
		
	  /*  
	       {9, 1, 1, 1, 0, 0, 0, 0, 5},
           {0, 0, 5, 0, 9, 0, 2, 0, 1},
           {8, 0, 0, 0, 4, 0, 0, 0, 0},
           {0, 0, 0, 0, 8, 0, 0, 0, 0},
           {0, 0, 0, 7, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 2, 6, 0, 0, 9},
           {2, 0, 0, 3, 0, 0, 0, 0, 6},
           {0, 0, 0, 2, 0, 0, 9, 0, 0},
           {0, 0, 1, 9, 0, 4, 5, 7, 0}
            */
		assertEquals("Fail in checkColonn(method) in solution_unsolvable array", solution_unsolvable.checkColonn(1,  1, 6),false);
		assertEquals("Fail in checkColonn(method) in solution_unsolvable array", solution_unsolvable.checkColonn(2,  2, 9),false);
		assertEquals("Fail in checkColonn(method) in solution_unsolvable array", solution_unsolvable.checkColonn(4,  2, 6),false);
		
		
		
		
		/* {0, 0, 8, 0, 0, 9, 0, 6, 2},
		   {0, 0, 0, 0, 0, 0, 0, 0, 5},   
		   {1, 0, 2, 5, 0, 0, 0, 0, 0},
		   {0, 0, 0, 2, 1, 0, 0, 9, 0},
		   {0, 5, 0, 0, 0, 0, 6, 0, 0},
		   {6, 0, 0, 0, 0, 0, 0, 2, 8},
		   {4, 1, 0, 6, 0, 8, 0, 0, 0},
		   {8, 6, 0, 0, 3, 0, 1, 0, 0},
		   {0, 0, 0, 0, 0, 0, 4, 0, 0},
		*/
		assertEquals("Fail in checkColonn(method) in figur1 array", solution_figur1.checkColonn(1, 1, 3),false);
		
		assertEquals("Fail in checkColonn(method) in Empty", solution_empty.checkColonn(2,  2, 9),false);

		
	}
	
	public final void check_Box() {
		/*  
		 *{5, 1, 6, 8, 4, 9, 7, 3, 2},
          {3, 0, 7, 6, 0, 5, 0, 0, 0},
          {8, 0, 9, 7, 0, 0, 0, 6, 5},
          {1, 3, 5, 0, 6, 0, 9, 0, 7},
          {4, 7, 2, 5, 9, 1, 0, 0, 6},
          {9, 5, 8, 3, 7, 0, 0, 5, 0},
          {2, 0, 3, 1, 8, 6, 0, 7, 4},
          {6, 8, 4, 2, 0, 7, 5, 0, 0},
          {7, 9, 1, 0, 5, 0, 6, 0, 8} 
		 */ 
		
		assertEquals("Fail in checkBox(method) in solvable array", solution_solvable.checkBox(3,  3, 4),false);
		assertEquals("Fail in checkBox(method) in solvable array", solution_solvable.checkBox(6,  1, 4),true);
		assertEquals("Fail in checkBox(method) in solvable array", solution_solvable.checkBox(1,  1, 4),false);		
		assertEquals("Fail in checkBox(method) in solvable array", solution_solvable.checkBox(2,  1, 1),true);		

		
	  /*  
	       {9, 1, 1, 1, 0, 0, 0, 0, 5},
           {0, 0, 5, 0, 9, 0, 2, 0, 1},
           {8, 0, 0, 0, 4, 0, 0, 0, 0},
           {0, 0, 0, 0, 8, 0, 0, 0, 0},
           {0, 0, 0, 7, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 2, 6, 0, 0, 9},
           {2, 0, 0, 3, 0, 0, 0, 0, 6},
           {0, 0, 0, 2, 0, 0, 9, 0, 0},
           {0, 0, 1, 9, 0, 4, 5, 7, 0}
            */
		assertEquals("Fail in checkBox(method) in unsolvable array", solution_unsolvable.checkBox(1,  1, 3),false);
		assertEquals("Fail in checkBox(method) in unsolvable array", solution_unsolvable.checkBox(2,  2, 6),false);	

		
		/* {0, 0, 8, 0, 0, 9, 0, 6, 2},
		   {0, 0, 0, 0, 0, 0, 0, 0, 5},   
		   {1, 0, 2, 5, 0, 0, 0, 0, 0},
		   {0, 0, 0, 2, 1, 0, 0, 9, 0},
		   {0, 5, 0, 0, 0, 0, 6, 0, 0},
		   {6, 0, 0, 0, 0, 0, 0, 2, 8},
		   {4, 1, 0, 6, 0, 8, 0, 0, 0},
		   {8, 6, 0, 0, 3, 0, 1, 0, 0},
		   {0, 0, 0, 0, 0, 0, 4, 0, 0},
		*/
		
		
		assertEquals("Fail in checkBox(method) in Empty array", solution_figur1.checkBox(2, 1, 3),false);

	
		assertEquals("Fail in checkBox(method) in Empty array", solution_empty.checkBox(2,  2, 9),false);

	}
	
	
	
	public final void check_Solve() {
		
	
         // assertEquals("Solve() method does NOT work in Unsolvable array case!!", solution_unsolvable.Solve(),false);
         // assertEquals("Solve() method does NOT work in Figure 1 array case!!", solution_figur1.Solve(),true);	
         // assertEquals("Solve() method does NOT work in Empty array case!!", solution_empty.Solve(),true);	

	}
	

}