(ns sample.core-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [sample.core :refer :all]))

(deftest test-app
  (testing "/api/health"
    (let [response (app (mock/request :get "/api/health"))]
      (is (= (:status response) 200))
      (is (= (:body response) "{\"up\":true}"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
