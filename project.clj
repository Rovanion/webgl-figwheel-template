(defproject webgl-figwheel-template "0.1.0"
  :description "A ClojureScript WebGL Demo using Figwheel and Geom in order to interactively program WebGL!"
  :url "https://github.com/Rovanion/webgl-figwheel-template"

  :min-lein-version "2.6.1"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.89"]
                 [org.clojure/core.async "0.2.385" :exclusions [org.clojure/tools.reader]]
                 [thi.ng/geom "0.0.1178-SNAPSHOT"]
                 [thi.ng/math "0.2.1"]
                 [thi.ng/color "1.2.0"]
                 [thi.ng/typedarrays "0.1.6"]]

  :plugins [[lein-figwheel "0.5.4-7"]
            [lein-cljsbuild "1.1.3" :exclusions [[org.clojure/clojure]]]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "webgl-figwheel-template.core/on-js-reload"
                           :open-urls ["http://localhost:3449/index.html"]}
                :compiler {:main webgl-figwheel-template.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/weather_magic.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/weather_magic.js"
                           :main webgl-figwheel-template.core
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {:css-dirs ["resources/public/css"]
             :nrepl-port 7888
             :nrepl-middleware ["cider.nrepl/cider-middleware"
                                "cemerick.piggieback/wrap-cljs-repl"]
             :open-file-command "emacsclient"}

  :profiles {:dev {:dependencies [[cider/cider-nrepl "0.13.0"]
                                  [binaryage/devtools "0.7.2"]
                                  [figwheel-sidecar "0.5.4-7"]
                                  [com.cemerick/piggieback "0.2.1"]]
                   :source-paths ["src" "dev"]
                   :plugins [[cider/cider-nrepl "0.13.0"]]}}

  :repl-options{:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

)
