var easterEggCode = [38, 38, 40, 40, 37, 39, 37, 39, 66, 65];
var easterEggIndex = 0;

document.addEventListener('keydown', function(e) {
    if (e.keyCode === easterEggCode[easterEggIndex]) {
        easterEggIndex++;
        if (easterEggIndex === easterEggCode.length) {
            easterEggIndex = 0;
            var iframe = document.createElement('iframe');
            iframe.src="https://www.youtube.com/embed/dQw4w9WgXcQ?autoplay=1&loop=1&playlist=dQw4w9WgXcQ";
            iframe.width = '560';
            iframe.height = '315';
            iframe.allow = 'autoplay';
            document.body.appendChild(iframe);
        }
    } else {
        easterEggIndex = 0;
    }
});