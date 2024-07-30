const express = require('express');
const app = express();
const { port } = require('./config/config');

app.get('', (req, res) => {
    return res.status(200).json({ message: 'Hola!' });
});

app.listen(port, () => {
    console.log(`server up and listening on port ${port}`);
});