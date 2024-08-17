# HW 18 solution
## RangeIterator with a predicate based on Iterator pattern
### 1. All current values match the predicate beginning from first value
### 2. hasNext only one statement return current <= max
### 3. next method
3.1 hasNext call with throwing NoSuchElementException if hasNext return false<br>
3.2 returns current<br>
3.3 sets new current


