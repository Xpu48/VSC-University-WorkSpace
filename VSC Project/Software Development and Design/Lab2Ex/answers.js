/*
 * This function calculates the final grade based on an array of module marks,
 * using UK grading boundaries.
 *
 * @param {Array<number>} marks An array of numerical marks, each between 0 and 100.
 * @returns {string} The calculated grade.
 * @throws {Error} If the input is invalid.
 */
function calculateFinalGrade(marks) {
  // Input validation: Check if marks is a non-empty array
  // Array.isArray() reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/isArray
  /*
   * We first check if the `marks` parameter is an array and that it's not empty.
   * The `Array.isArray()` function is used to ensure the input is an array.
   * If not, we throw an error using `throw new Error()`.
   * 
   * `Array.isArray()` is a method that checks if a value is an array.
   * [More info here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/isArray)
   */
  if (!Array.isArray(marks) || marks.length === 0) {
    // throw new Error() reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/throw
    /*
     * The `throw` statement is used to create a custom error message when the
     * input is not valid. This stops the function execution and sends an error 
     * back to the caller.
     *
     * In this case, if `marks` is not an array or is empty, an error is thrown.
     * [Learn more about `throw` here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/throw)
     */
    throw new Error("Invalid input: marks must be a non-empty array");
  }

  // Check for invalid mark values
  /*
   * We loop through the `marks` array to ensure that all values are numbers between
   * 0 and 100. If any value is not a number or falls outside this range, an error is thrown.
   */
  for (let i = 0; i < marks.length; i++) {
    if (typeof marks[i] !== "number" || marks[i] < 0 || marks[i] > 100) {
      throw new Error("Invalid input: marks must be numbers between 0 and 100");
    }
  }

  // Calculate average mark
  /*
   * The average mark is calculated by summing all the marks in the array and 
   * dividing by the number of marks. This is a simple average calculation.
   */
  let sum = 0;
  for (let i = 0; i < marks.length; i++) {
    sum += marks[i];
  }
  const average = sum / marks.length;

  // Determine grade based on UK grading boundaries
  /*
   * UK university grading system is used here:
   * - 70 or above: First Class
   * - 60 to 69: 2:1 (Second Class, Upper Division)
   * - 50 to 59: 2:2 (Second Class, Lower Division)
   * - 40 to 49: Third Class
   * - Below 40: Fail
   * 
   * The average score determines which grade is returned by the function.
   */
  if (average >= 70) {
    return "First Class";
  } else if (average >= 60) {
    return "2:1";
  } else if (average >= 50) {
    return "2:2";
  } else if (average >= 40) {
    return "Third Class";
  } else {
    return "Fail";
  }
}

/*
 * This function is a simple test harness for running unit tests.
 *
 * @param {string} message A descriptive message for the test.
 * @param {Function} assertion A function that performs the test assertion.
 */
function test(message, assertion) {
  /*
   * The `test` function runs unit tests. It takes a message describing the test
   * and a function (assertion) that performs the actual check.
   * 
   * It uses a `try...catch` block to catch any errors thrown during the test execution.
   * If the test passes (no error), it prints "Pass". Otherwise, it prints "Fail" or
   * the error message if an exception is caught.
   */
  try {
    const result = assertion();
    console.log(result ? `Pass: ${message}` : `Fail: ${message}`);
    /* The ternary operator (?) is a shorthand for an if-else statement in JavaScript. It's used for conditional expressions. condition ? expression_if_true : expression_if_false;
    https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Conditional_operator
     The template literal is a way of creating strings in JavaScript. They allow embedding expressions directly inside the string using ${}. This eliminates the need for concatenation with + operators. The expression inside ${} is replaced with the value of the variable message.
Template literals are enclosed in backticks (`), unlike regular strings which use single or double quotes. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals
     */
  } catch (error) {
    console.error(`Error: ${message} ${error.message}`);
  }
}

// Test 1: Marks above 70 should return "First Class"
test("calculates final grade for all marks above 70", () => {
  const marks = [75, 80, 72];
  const grade = calculateFinalGrade(marks);
  return grade === "First Class";
});

// Test 2: Marks between 60 and 69 should return "2:1"
test("calculates final grade for marks between 60 and 69", () => {
  const marks = [62, 68, 65];
  const grade = calculateFinalGrade(marks);
  return grade === "2:1";
});

// Test 3: Marks between 50 and 59 should return "2:2"
test("calculates final grade for marks between 50 and 59", () => {
  const marks = [52, 58, 55];
  const grade = calculateFinalGrade(marks);
  return grade === "2:2";
});

// Test 4: Marks between 40 and 49 should return "Third Class"
test("calculates final grade for marks between 40 and 49", () => {
  const marks = [42, 48, 45];
  const grade = calculateFinalGrade(marks);
  return grade === "Third Class";
});

// Test 5: Marks below 40 should return "Fail"
test("calculates final grade for marks below 40", () => {
  const marks = [32, 38, 35];
  const grade = calculateFinalGrade(marks);
  return grade === "Fail";
});

// Edge case: Empty array should throw an error
test("throws error for empty array input", () => {
  try {
    calculateFinalGrade([]);
    return false; // Should not reach here
  } catch (error) {
    return error.message === "Invalid input: marks must be a non-empty array";
  }
});

// Edge case: Non-array input should throw an error
test("throws error for non-array input", () => {
  try {
    calculateFinalGrade("not an array");
    return false; // Should not reach here
  } catch (error) {
    return error.message === "Invalid input: marks must be a non-empty array";
  }
});

// Edge case: Marks with invalid values (below 0 or above 100) should throw an error
test("throws error for invalid mark values", () => {
  try {
    calculateFinalGrade([75, -5, 80]);
    return false; // Should not reach here
  } catch (error) {
    return error.message === "Invalid input: marks must be numbers between 0 and 100";
  }
});

test("throws error for invalid mark values", () => {
  try {
    calculateFinalGrade([75, 105, 80]);
    return false; // Should not reach here
  } catch (error) {
    return error.message === "Invalid input: marks must be numbers between 0 and 100";
  }
});


