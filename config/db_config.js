const mongoose = require('mongoose');
const { dbUrl } = require('./config');

const connection = mongoose.connect(dbUrl).then(() => {
    console.log(`connected to db`)
}).catch((err) => {
    console.log(err);
});