(ns testing.input-test
  (:require [expectations :refer :all]
            [expectations.clojure.test :refer [defexpect]]
            [testing.input :as input]))

(defexpect increments-by-speed
  (expect 5 (input/inc-speed 0)))

(defexpect decrements-by-speed
  (expect -5 (input/dec-speed 0)))
