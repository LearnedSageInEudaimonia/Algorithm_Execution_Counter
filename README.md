# Algorithm Execution Counter
API to execute classic sorting algorithms on an integer array and return both the sorted result and detailed execution statistics (comparisons, swaps, stability, etc.).

## Features
- Exposes a REST API to run sorting algorithms on a provided integer array.​

- Supports Bubble Sort, Insertion Sort, and Selection Sort via a single endpoint.​

- Returns rich metadata: original array, sorted array, comparison count, swap count, time complexity, stability, and in‑place information.​

- Built with Spring Boot and uses a clean DTO-based contract for requests and responses.​

## API Overview
- Base URL: http://localhost:8080​

## Sort Algorithms Endpoint
- POST /algorithms/sort-algorithms​
- Executes the specified sorting algorithm on the input array and returns statistics about the execution.

## Search Algorithm Endpoint
- POST /algorithms/search-algorithms
- Executes the specified searching algorithm on the given array, finds the target elements and returns statics about the execution.​

## Request
- Content-Type: application/json​

- Body schema: AlgorithmsRequestDTO​

```json
{
  "algorithms": "BUBBLE_SORT",
  "array": [5, 3, 8, 4, 2]
}
```
- Body schema: SearchAlgorithmsRequestDTO
```json
{
  "searchType": "BINARY_SEARCH",
  "array": [1,2,3,4,5,6,7,8,9],
  "target": 3
}
```
## sorting algorithms enum values:​

- BUBBLE_SORT

- INSERTION_SORT

- SELECTION_SORT

## Searching algorithms enum values:
- LINEAR_SEARCH
- BINARY_SEARCH

## array:

- Type: array of integers (int32)​

  - Represents the unsorted input array.

- Response
  - Status: 200 OK​

- Body schema: AlgorithmsResponseDTO​

- Example:

```json
{
  "algorithms": "BUBBLE_SORT",
  "originalArray": [5, 3, 8, 4, 2],
  "sortedArray": [2, 3, 4, 5, 8],
  "comparisons": 10,
  "swaps": 5,
  "timeComplexity": "O(n^2)",
  "stable": true,
  "inPlace": true
}
```

## Field descriptions:​

- algorithms: Algorithm used (BUBBLE_SORT, INSERTION_SORT, SELECTION_SORT).

- originalArray: The input array as received.

- sortedArray: The result after applying the selected algorithm.

- comparisons: Total number of element comparisons performed.

- swaps: Total number of element swaps performed.

- timeComplexity: Asymptotic time complexity of the algorithm (e.g., O(n^2)).

- stable: Whether the algorithm is stable for this implementation.

- inPlace: Whether the algorithm sorts in place without extra significant memory.

- ### Body schema: SearchAlgortihmsResponseDTO
- Example:
  ```json
  {
    "searchType": "BINARY_SEARCH",
    "target": 3,
    "comparisons": 4,
    "index": 2,
    "executionTimeNs": 6400,
    "sortedRequired": true,
    "arraySize": 9,
    "bigONotation": "O(log n)"
  }
  ```
 ## Field descriptions:

- **searchType**: Search algorithm used to find the target value (e.g., `LINEAR_SEARCH`, `BINARY_SEARCH`).

- **target**: The value that is being searched for in the input array.

- **comparisons**: Total number of element comparisons performed during the search execution.

- **index**: Index position where the target value was found. Returns `-1` if the target is not present.

- **executionTimeNs**: Time taken to execute the search algorithm, measured in nanoseconds.

- **sortedRequired**: Indicates whether the input array must be sorted before applying the selected search algorithm.

- **arraySize**: Total number of elements present in the input array.

- **bigONotation**: Time complexity of the search algorithm expressed in Big-O notation (e.g., `O(n)`, `O(log n)`).

## Running the Application
- Clone the repository:
  ``` bash
  git clone https://github.com/LearnedSageInEudaimonia/Algorithm_Execution_Counter.git​
  ```
- Build and run (typical Spring Boot flow):

- Using Maven:
  ``` bash
  mvn spring-boot:run
  ```

- The API will be available at http://localhost:8080.​
