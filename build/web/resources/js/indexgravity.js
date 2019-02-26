var _createClass = function () {
    function defineProperties(target, props) {
        for (var i = 0; i < props.length; i++) {
            var descriptor = props[i];
            descriptor.enumerable = descriptor.enumerable || false;
            descriptor.configurable = true;
            if ("value" in descriptor)
                descriptor.writable = true;
            Object.defineProperty(target, descriptor.key, descriptor);
        }
    }
    return function (Constructor, protoProps, staticProps) {
        if (protoProps)
            defineProperties(Constructor.prototype, protoProps);
        if (staticProps)
            defineProperties(Constructor, staticProps);
        return Constructor;
    };
}();

function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
        throw new TypeError("Cannot call a class as a function");
    }
}

var Particle = function () {
    function Particle(svg, coordinates, friction) {
        _classCallCheck(this, Particle);

        this.svg = svg;
        this.steps = $(window).height() / 2;
        this.item = null;
        this.friction = friction;
        this.coordinates = coordinates;
        this.position = this.coordinates.y;
        this.dimensions = this.render();
        this.rotation = Math.random() > 0.5 ? "-" : "+";
        this.scale = 0.5 + Math.random();
        this.siner = 200 * Math.random();
    }

    _createClass(Particle, [{
            key: "destroy",
            value: function destroy() {
                this.item.remove();
            }
        }, {
            key: "move",
            value: function move() {
                this.position = this.position - this.friction;
                var top = this.position;
                var left = this.coordinates.x + Math.sin(this.position * Math.PI / this.steps) * this.siner;
                this.item.css({
                    transform: "translateX(" + left + "px) translateY(" + top + "px) scale(" + this.scale + ") rotate(" + this.rotation + (this.position + this.dimensions.height) + "deg)"
                });

                if (this.position < -this.dimensions.height) {
                    this.destroy();
                    return false;
                } else {
                    return true;
                }
            }
        }, {
            key: "render",
            value: function render() {
                this.item = $(this.svg, {
                    css: {
                        transform: "translateX(" + this.coordinates.x + "px) translateY(" + this.coordinates.y + "px)"
                    }
                });
                $("body").append(this.item);
                return {
                    width: this.item.width(),
                    height: this.item.height()
                };
            }
        }]);

    return Particle;
}();
var calendar = '<svg width="480px" height="480px"><g id="surface1"><path style=" fill:#CFD8DC;" d="M 5 38 L 5 14 L 43 14 L 43 38 C 43 40.199219 41.199219 42 39 42 L 9 42 C 6.800781 42 5 40.199219 5 38 Z "/><path style=" fill:#F44336;" d="M 43 10 L 43 16 L 5 16 L 5 10 C 5 7.800781 6.800781 6 9 6 L 39 6 C 41.199219 6 43 7.800781 43 10 Z "/><path style=" fill:#B71C1C;" d="M 36 10 C 36 11.65625 34.65625 13 33 13 C 31.34375 13 30 11.65625 30 10 C 30 8.34375 31.34375 7 33 7 C 34.65625 7 36 8.34375 36 10 Z "/><path style=" fill:#B71C1C;" d="M 18 10 C 18 11.65625 16.65625 13 15 13 C 13.34375 13 12 11.65625 12 10 C 12 8.34375 13.34375 7 15 7 C 16.65625 7 18 8.34375 18 10 Z "/><path style=" fill:#B0BEC5;" d="M 33 3 C 31.898438 3 31 3.898438 31 5 L 31 10 C 31 11.101563 31.898438 12 33 12 C 34.101563 12 35 11.101563 35 10 L 35 5 C 35 3.898438 34.101563 3 33 3 Z "/><path style=" fill:#B0BEC5;" d="M 15 3 C 13.898438 3 13 3.898438 13 5 L 13 10 C 13 11.101563 13.898438 12 15 12 C 16.101563 12 17 11.101563 17 10 L 17 5 C 17 3.898438 16.101563 3 15 3 Z "/><path style=" fill:#90A4AE;" d="M 13 20 L 17 20 L 17 24 L 13 24 Z "/><path style=" fill:#90A4AE;" d="M 19 20 L 23 20 L 23 24 L 19 24 Z "/><path style=" fill:#90A4AE;" d="M 25 20 L 29 20 L 29 24 L 25 24 Z "/><path style=" fill:#90A4AE;" d="M 31 20 L 35 20 L 35 24 L 31 24 Z "/><path style=" fill:#90A4AE;" d="M 13 26 L 17 26 L 17 30 L 13 30 Z "/><path style=" fill:#90A4AE;" d="M 19 26 L 23 26 L 23 30 L 19 30 Z "/><path style=" fill:#90A4AE;" d="M 25 26 L 29 26 L 29 30 L 25 30 Z "/><path style=" fill:#90A4AE;" d="M 31 26 L 35 26 L 35 30 L 31 30 Z "/><path style=" fill:#90A4AE;" d="M 13 32 L 17 32 L 17 36 L 13 36 Z "/><path style=" fill:#90A4AE;" d="M 19 32 L 23 32 L 23 36 L 19 36 Z "/><path style=" fill:#90A4AE;" d="M 25 32 L 29 32 L 29 36 L 25 36 Z "/><path style=" fill:#90A4AE;" d="M 31 32 L 35 32 L 35 36 L 31 36 Z "/></g></svg>';
//var develop = '<svg><g id="#00bcd4ff"><path fill="#00bcd4" opacity="1.00" d=" M 395.33 50.39 C 409.95 47.78 425.43 57.76 428.92 72.22 C 433.16 86.67 424.54 103.47 410.17 108.12 C 407.38 109.25 403.57 108.96 401.91 111.93 C 385.75 136.39 369.83 161.02 353.28 185.23 C 351.45 188.11 348.39 190.96 349.45 194.71 C 351.23 204.44 347.96 214.94 340.67 221.68 C 331.99 230.24 317.90 232.41 306.99 227.01 C 300.51 223.86 295.06 218.35 292.46 211.58 C 291.53 209.32 290.77 206.74 288.43 205.54 C 275.34 197.28 262.16 189.15 249.02 180.97 C 246.04 178.96 242.30 179.80 238.95 179.93 C 235.48 179.82 233.29 182.83 230.85 184.81 C 219.84 194.49 208.73 204.07 197.68 213.70 C 195.23 215.92 192.39 217.79 190.41 220.47 C 189.38 223.90 189.23 227.56 187.91 230.92 C 184.38 240.16 175.95 247.34 166.24 249.31 C 155.36 251.75 143.23 247.47 136.53 238.50 C 134.95 236.17 132.59 234.61 129.81 234.20 C 119.37 231.70 109.02 228.88 98.61 226.30 C 95.62 225.31 92.86 227.18 90.14 228.10 C 78.41 232.76 64.09 228.49 56.45 218.54 C 47.30 207.38 48.10 189.56 58.31 179.33 C 67.40 169.37 83.42 167.18 94.97 174.02 C 99.63 176.55 103.09 180.66 106.03 184.97 C 107.32 187.11 110.00 187.30 112.17 187.93 C 121.34 189.99 130.43 192.34 139.56 194.53 C 144.18 195.99 147.87 191.83 152.22 191.07 C 156.63 189.50 162.18 191.36 165.75 187.75 C 179.67 175.35 193.71 163.05 207.75 150.78 C 210.52 148.81 210.32 145.18 211.16 142.24 C 214.20 129.02 227.53 119.35 241.00 120.05 C 252.67 120.32 263.89 128.08 267.84 139.12 C 268.94 141.83 269.25 145.32 272.20 146.75 C 284.11 154.15 295.89 161.77 307.74 169.26 C 309.96 170.78 312.85 171.63 315.40 170.35 C 317.79 168.00 319.26 164.91 321.17 162.19 C 337.34 137.98 353.44 113.73 369.48 89.45 C 371.51 86.67 369.93 83.12 370.11 79.99 C 369.64 65.65 381.18 52.34 395.33 50.39 Z" /></g><g id="#3f51b5ff"><path fill="#3f51b5" opacity="1.00" d=" M 396.31 280.28 C 406.28 278.98 416.76 283.08 423.10 290.91 C 431.20 300.41 432.16 315.03 425.60 325.60 C 419.43 335.94 406.57 341.88 394.73 339.36 C 391.94 338.90 388.92 337.54 386.27 339.21 C 377.10 343.78 367.93 348.34 358.73 352.83 C 355.68 354.41 352.39 355.57 349.60 357.60 C 347.99 359.84 347.28 362.56 345.93 364.95 C 341.29 373.29 332.34 378.97 322.85 379.81 C 312.94 380.78 302.51 376.57 296.54 368.49 C 294.89 366.52 293.66 363.72 290.84 363.28 C 280.61 360.81 270.39 358.32 260.21 355.70 C 255.41 354.06 251.53 358.53 246.94 359.13 C 242.44 360.55 236.83 358.52 233.22 362.22 C 221.21 372.88 209.08 383.41 196.99 393.99 C 194.75 396.06 191.98 397.74 190.37 400.40 C 189.38 403.86 189.22 407.54 187.90 410.92 C 184.56 419.65 176.85 426.60 167.78 428.91 C 158.13 431.57 147.19 428.99 139.84 422.18 C 136.62 419.74 135.34 415.17 131.59 413.49 C 121.25 410.68 110.81 408.19 100.43 405.48 C 97.26 404.24 94.40 406.32 91.60 407.52 C 80.31 412.62 66.01 409.42 57.83 400.15 C 47.71 389.49 47.47 371.28 57.35 360.38 C 65.97 350.05 81.81 347.08 93.68 353.32 C 98.67 355.74 102.54 359.86 105.62 364.39 C 107.01 366.78 109.96 367.05 112.37 367.72 C 121.53 369.81 130.62 372.14 139.75 374.35 C 144.57 375.91 148.45 371.47 153.06 370.86 C 157.56 369.45 163.17 371.47 166.78 367.78 C 180.39 355.72 194.11 343.78 207.82 331.84 C 210.17 330.15 210.12 327.12 210.65 324.57 C 212.09 314.99 218.90 306.61 227.66 302.68 C 237.84 298.05 250.54 299.67 259.10 306.89 C 263.51 309.89 265.00 316.56 270.95 317.13 C 280.79 319.51 290.57 322.17 300.42 324.54 C 303.30 325.51 305.84 323.45 308.40 322.47 C 314.71 319.54 321.98 319.49 328.60 321.33 C 330.64 322.02 332.79 321.70 334.64 320.62 C 345.89 314.88 357.14 309.12 368.42 303.45 C 370.89 302.49 371.80 299.94 372.78 297.72 C 376.72 288.22 386.15 281.45 396.31 280.28 Z" /></g></svg>';
var rhombus = calendar;

var pentahedron = calendar;
var x = '<svg viewBox="0 0 12 12"> <path class="x" d="M10.3,4.3H7.7V1.7C7.7,0.8,7,0,6,0S4.3,0.8,4.3,1.7v2.5H1.7C0.8,4.3,0,5,0,6s0.8,1.7,1.7,1.7h2.5v2.5 C4.3,11.2,5,12,6,12s1.7-0.8,1.7-1.7V7.7h2.5C11.2,7.7,12,7,12,6S11.2,4.3,10.3,4.3z"/></svg>';

var circle = '<svg viewBox="0 0 12 12"> <path class="x" d="M10.3,4.3H7.7V1.7C7.7,0.8,7,0,6,0S4.3,0.8,4.3,1.7v2.5H1.7C0.8,4.3,0,5,0,6s0.8,1.7,1.7,1.7h2.5v2.5 C4.3,11.2,5,12,6,12s1.7-0.8,1.7-1.7V7.7h2.5C11.2,7.7,12,7,12,6S11.2,4.3,10.3,4.3z"/></svg>';

var point = calendar;



function randomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

var data = [point, rhombus, pentahedron, circle, x];

var isPaused = false;
window.onblur = function () {
    isPaused = true;
}.bind(this);
window.onfocus = function () {
    isPaused = false;
}.bind(this);

var particles = [];

setInterval(function () {
    if (!isPaused) {
        particles.push(new Particle(data[randomInt(0, data.length - 1)], {
            "x": Math.random() * $(window).width(),
            "y": $(window).height()
        }, 1 + Math.random() * 3));
    }
}, 200);

function update() {
    particles = particles.filter(function (p) {
        return p.move();
    });
    requestAnimationFrame(update.bind(this));
}
update();