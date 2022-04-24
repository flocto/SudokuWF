## Basic Sudoku Solver
This is very basic sudoku solver based on a very simple wave function collapse, it does not include any advanced algorithms or techniques.

## Wave Function Collapse
Wave function collapse is a way to reduce a set of superpositions defined by a wave function to a singular outcome based on observation.
In this case, the set of superpositions is the possible valid numbers for a given position.
Based on the other numbers in the same row, column, or cell, this superposition is narrowed down until it collapses to a single choice, which is the correct number in that spot.

## Input
Serve input as a 9 lines of 9 digits each, with an 0 for empty spaces.
Ex: 
```
800930002
009000040
702100960
200000090
060000070
070006005
027008406
030000500
500062008
```

## Output
The program will either output a solved board in the same shape as the input,
or it will print a message saying that the board is not collapsable given the current state.
**The program only runs determistic checks and will not guess any numbers to fill in possible states.**
**It is also not a guaranteed solver and fails many basic checks that combine rows/columns/boxes.**

This is just a small experimental program I wrote after watching this [video.](https://www.youtube.com/watch?v=2SuvO4Gi7uY)

## Possible Improvements
Might add these if I have time or feel motivated to.
- Change input method
- Add more complicated solving algorithms
- Possibly a GUI
- Caching/storing results