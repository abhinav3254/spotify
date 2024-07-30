const express = require('express');
const app = express();
const { port } = require('./config/config');

// multer file upload import
const upload = require('./middlewares/upload');

// music object
const Music = require('./models/Music');

// db connect
require('./config/db_config');

app.get('', (req, res) => {
    return res.status(200).json({ message: 'Hola!' });
});

app.post('/upload', upload.single('file'), async (req, res) => {
    try {

        const { name, artist, album, genre, duration, releaseDate } = req.body;

        if (!name && !artist && !duration) {
            return res.status(400).json({ message: 'Name, Artist and Duration are required fields' });
        }

        if (!req.file) {
            return res.status(400).json({ message: 'File not found' });
        }

        const newMusic = new Music({
            name,
            artist,
            album,
            genre,
            duration,
            releaseDate,
            filePath: req.file.path
        });

        const musicSaved = await newMusic.save();

        return res.status(200).json({ message: 'Saved!', id: musicSaved._id });
    } catch (err) {
        return res.status(500).json({ message: 'Unable to process your request at the moment,please try again after sometime', error: err.message });
    }


});

app.listen(port, () => {
    console.log(`server up and listening on port ${port}`);
});