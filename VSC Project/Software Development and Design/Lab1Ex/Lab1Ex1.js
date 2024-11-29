/* function getAreaOfSquare(side) {
    return side * side;
}

function getAreaOfCircle(radius) {
    return 3.1416 * radius * radius;
}

function getAreaOfTriangle(base, height) {
    return 0.5 * base * height;
}

function getAreaOfRectangle(length, width) {
    return length * width;
}

*/

function getArea(shape, dimensions) {
    switch (shape) {
        case 'square':
            return dimensions.side * dimensions.side;
        case 'circle':
            return 3.1416 * dimensions.radius * dimensions.radius;
        case 'triangle':
            return 0.5 * dimensions.base * dimensions.height;
        case 'rectangle':
            return dimensions.length * dimensions.width;
        default:
            return null;
    }
}
