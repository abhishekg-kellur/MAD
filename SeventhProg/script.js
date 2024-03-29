// start.js
if('serviceWorker' in navigator) {
    window.addEventListener('load', function() {
      navigator.serviceWorker.register('./sw.js').then(function() {
        console.log("serviceWorker register....");
      },
      function(err) {
        console.log("serviceWorker register....", err);
      })
    })
  }
  else {
    console.log("No serviceWorker in browser");
  }


//sw.js

self.addEventListener('install', (event) => {
    console.log("Service worker installing");
});

self.addEventListener('activate', (event) => {
    console.log("Service worker activating");
});

self.addEventListener('fetch', (event) => {
    console.log("Fetching:", event.request.url);
});
