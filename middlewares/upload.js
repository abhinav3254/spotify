const multer = require('multer');

const storageConfig = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, "uploads/")
    },
    filename: (req, file, cb) => {
        cb(null, Date.now() + ".mp3");
    }
});

const upload = multer({
    storage: storageConfig
});

module.exports = upload;