/**
 * Created by ZhangJian on 2016/1/16.
 */
var gulp = require("gulp"),
    uglify = require("gulp-uglify"),
    concat=require("gulp-concat");


gulp.task('test', function () {
    gulp.src("js/*.js")
        .pipe(uglify())
        .pipe(gulp.dest("dest/"));
    gulp.src("dest/*.js")
        .pipe(concat("all.js"))
        .pipe(gulp.dest("dest/all/"));
});

