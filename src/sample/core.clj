(ns sample.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :as json]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :refer [response]]
            [environ.core :refer [env]]))

(defroutes app-routes
  (GET "/api/health" [] (response {:up true}))
  (route/not-found (response {:message "Not Found"})))

(def app
  (-> app-routes
      json/wrap-json-response
      json/wrap-json-body
      json/wrap-json-params
      (wrap-defaults api-defaults)))

(defn run-server
  [routes]
    (let  [port             (Integer. (:port env 8000))
           max-threads      (Integer. (:max-threads env 100))
           min-threads      (Integer. (:min-threads env 50))]
      (jetty/run-jetty routes {:port port
                               :join? false
                               :max-threads max-threads
                               :min-threads min-threads})))

(defn -main [& args]
  (run-server app))