const mongoose = require('mongoose');
const { Schema } = mongoose;

const MusicSchema = new Schema({
    name: {
        type: String,
        required: true,
        trim: true
    },
    artist: {
        type: String,
        required: true,
        trim: true
    },
    album: {
        type: String,
        trim: true
    },
    genre: {
        type: String,
        trim: true
    },
    duration: {
        type: Number,
        required: true
    },
    filePath: {
        type: String,
        required: true,
        trim: true
    },
    releaseDate: {
        type: Date
    },
    coverImage: {
        type: String,
        trim: true
    }
});

const Music = mongoose.model('musics', MusicSchema);
module.exports = Music;
