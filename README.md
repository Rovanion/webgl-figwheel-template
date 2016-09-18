# ClojureScript WebGL Figwheel Template

A ClojureScript WebGL Demo using Figwheel and Geom in order to interactively program WebGL!


# Setup

## Leiningen

First install [leiningen](http://leiningen.org/), the popular clojure
build system. On Ubuntu/Debian, run:

    sudo apt install leiningen

On macOS with [homebrew](http://brew.sh/):

    brew install leiningen

On Windows there's apparently an [installer](http://leiningen-win-installer.djpowell.net/).

Lein should take care of the rest.


# Coding

With that installed, in order to get an interactive development
environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.



## Emacs

If you're running Emacs and CIDER, in order to get CLJS REPL-programming going you should first add the following line to your emacs init.el:

    (setq cider-cljs-lein-repl
			"(do (use 'figwheel-sidecar.repl-api) (start-figwheel!) (cljs-repl))")

With that done you can now start figwheel from emacs with:

    M-x cider-jack-in-clojurescript

And off you go!


# Deploying

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get code injection, nor a REPL.

# License

Copyright © 2016 Rovanion Luckey, Karsten Schmidt, Licensed under Apache 2.0.
