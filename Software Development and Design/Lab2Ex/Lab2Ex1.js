function test(message, assertion) {
    try {
    const result = assertion();
    console.log(result ? `Pass: ${message}` : `Fail: ${message}`);
    }
    catch (error) {
    console.error(`Error: ${message}
    - ${error.message}`);
    }
    }

function getAverage(marks){
    if(marks.length === 0){
        throw new Error('No marks provided');
    }
    if(marks.length > 100){
        throw new Error('Too many marks provided');
    }
    const average = marks.reduce((total, mark) => total + mark, 0) / marks.length;
}

function calculateFinalGrade(marks) {
    const average = marks.reduce((total, mark) => total + mark, 0) / marks.length;
    if (average >= 70) {return "First Class";
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


test('calculates final grade for all marks above 70', () => {
    const marks = [75, 80, 72];
    const grade = calculateFinalGrade(marks);
    // This will throw an error initially
    return grade === 'First Class';
    }
    );

test('calculates final grade for marks between 60 and 69', () => {
    const marks = [62, 68, 65];
    const grade = calculateFinalGrade(marks);
    return grade === '2:1';
    }
    );

test('calculates final grade for marks between 60 and 69', () => {
    const marks = [62, 68, 65];
    const grade = calculateFinalGrade(marks);
    return grade === '2:1';
    }
    );
        