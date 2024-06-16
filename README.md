# SudokuSolver
Sudoku solver and generator

# How to use
* Compile and execute the code with `javac SudokuSolver.java` and `java SudokuSolver`
* Choose the size of the sudoku:
`GRID_SIZE`: the amount of subgrids in a row/column
`SUBGRID_SIZE`: the amount of cells in a subgrid's row/column
* Choose to manually fill the grid or not

# Example
## Manually fill a 3x3 grid and solve it
```
GRID_SIZE: 3
SUBGRID_SIZE: 3
Fill the grid? (Y/N): y
1 0 6 0 0 0 0 5 2
4 0 0 0 0 2 0 9 0
8 9 0 7 0 0 0 0 0
0 0 3 0 0 9 2 0 5
0 7 0 2 0 6 0 4 0
9 0 4 3 0 0 8 0 0
0 0 0 0 0 3 0 7 6
0 6 0 9 0 0 0 0 3
0 4 0 0 0 0 5 0 1

01 03 06  08 09 04  07 05 02  
04 05 07  01 03 02  06 09 08  
08 09 02  07 06 05  01 03 04  

06 08 03  04 07 09  02 01 05  
05 07 01  02 08 06  03 04 09  
09 02 04  03 05 01  08 06 07  

02 01 08  05 04 03  09 07 06  
07 06 05  09 01 08  04 02 03  
03 04 09  06 02 07  05 08 01  

Continue? (Y/N): n
```

## Generate a random 4x4 sudoku
```
GRID_SIZE: 4
SUBGRID_SIZE: 4
Fill the grid? (Y/N): n
01 05 12 11  13 03 07 14  15 08 06 04  16 02 09 10  
03 06 08 10  15 05 16 12  01 02 09 07  04 11 14 13  
13 02 14 04  06 09 10 01  03 12 16 11  05 08 07 15  
16 09 07 15  11 08 04 02  14 05 13 10  06 12 01 03  

12 03 04 08  02 07 14 13  05 06 10 15  01 09 11 16  
14 15 02 01  16 11 06 05  04 03 07 09  08 10 13 12  
11 13 16 09  08 15 03 10  12 14 02 01  07 05 04 06  
10 07 05 06  09 12 01 04  13 16 11 08  03 15 02 14  

08 11 06 03  01 10 09 07  02 13 04 14  12 16 15 05  
05 10 13 02  03 16 12 11  09 15 01 06  14 04 08 07  
04 01 15 12  05 14 02 06  16 07 08 03  09 13 10 11  
07 14 09 16  04 13 15 08  10 11 05 12  02 06 03 01  

09 04 11 14  10 02 05 03  06 01 15 16  13 07 12 08  
15 12 01 13  07 06 11 16  08 09 14 02  10 03 05 04  
02 16 03 05  14 04 08 15  07 10 12 13  11 01 06 09  
06 08 10 07  12 01 13 09  11 04 03 05  15 14 16 02  

Continue? (Y/N): n
```