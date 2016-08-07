(ns dev
    (:refer-clojure :exclude [test])
    (:require [clojure.repl :refer :all]
      [clojure.pprint :refer [pprint]]
      [clojure.tools.namespace.repl :refer [refresh]]
      [clojure.java.io :as io]
      [eftest.runner :as eftest]))

(defn test []
  (eval '(eftest/run-tests (eftest/find-tests "test") {:multithread? false})))

(defn refresh-and-test []
  (do
    (refresh)
    (test)))
