/* 
function displayUserProfile(user) {
    console.log(`Name: ${user.name}`);
    console.log(`Email: ${user.email}`);
    if (user.subscription === 'premium') {
        console.log('Premium user');
    } else {
        console.log('Standard user');
    }
}

function sendUserNotification(user) {
    if (user.subscription === 'premium') {
        console.log('Sending premium notification to', user.email);
    } else {
        console.log('Sending standard notification to', user.email);
    }
}
*/

function displayUserProfile(user) {
    console.log(`Name: ${user.name}`);
    console.log(`Email: ${user.email}`);
    displayUserSubscription(user);
}

function sendUserNotification(user) {
    console.log(`Sending ${user.subscription} notification to`, user.email);
}

function displayUserSubscription(user) {
    if (user.subscription === 'premium') {
        console.log('Premium user');
    } else {
        console.log('Standard user');
    }
}
