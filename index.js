const express = require('express');
const app = express();
const { port } = require('./config/config');

// multer file upload import
const upload = require('./middlewares/upload');

// db connect
require('./config/db_config');

app.get('', (req, res) => {
    return res.status(200).json({ message: 'Hola!' });
});

app.post('/upload', upload.single('file'), (req, res) => {

    if (!req.file) {
        return res.status(400).json({ message: 'File not found' });
    }

    return res.status(200).json({ message: 'File uploaded!' });

});

app.listen(port, () => {
    console.log(`server up and listening on port ${port}`);
});