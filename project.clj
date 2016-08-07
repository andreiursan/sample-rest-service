(defproject sample "0.1.0-SNAPSHOT"
  :description "Sample REST Service"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0-alpha10"]
                 [compojure "1.5.1"]
                 [environ "1.1.0"]
                 [ring "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.2.1"]]

  :main sample.core

  :profiles
  {:dev  [:project/dev  :profiles/dev]
   :test [:project/test :profiles/test]
   :uberjar {:aot :all}
   :profiles/dev  {}
   :profiles/test {}
   :project/dev   {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [ring/ring-mock "0.3.0"]
                                  [eftest "0.1.1"]]
                   :source-paths   ["dev/src"]
                   :resource-paths ["dev/resources"]
                   :repl-options {:init-ns dev}
                   :env {}}
   :project/test {}})