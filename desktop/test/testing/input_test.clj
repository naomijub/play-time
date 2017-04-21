(ns testing.input-test
  (:require [expectations :refer :all]
            [expectations.clojure.test :refer [defexpect]]
            [testing.input :as input]
            [clojure.spec :as spec]
            [clojure.spec.test :as stest]))

(defn run-specs [& specs]
  (-> specs
      (stest/check {:clojure.spec.test.check/opts {:num-tests 50}})
      stest/summarize-results))

(do
  (spec/def ::direction #{:up :down :right :left})
  (spec/def ::position int?)
  (spec/def ::x ::position)
  (spec/def ::y ::position)
  (spec/def ::entity (spec/keys :req-un [::x ::y]))
  (spec/fdef input/move
             :args (spec/cat :entity ::entity :direction ::direction)
             :ret ::entity
             :fn (fn [{:keys [ret args]}]
                   (or (not= (:x ret) (:x args)) (not= (:y ret) (:y args)))))
  (defexpect move-entity
    (expect nil (:check-failed (run-specs `input/move)))))

(do
  (spec/fdef input/inc-speed
             :args (spec/cat :amount int?)
             :ret int?
             :fn #(= 5 (- (:ret %) (-> % :args :amount))))
  (defexpect increment-entity-speed
    (expect nil (:check-failed (run-specs `input/inc-speed)))))

(do
  (spec/fdef input/dec-speed
             :args (spec/cat :amount int?)
             :ret int?
             :fn #(= -5 (- (:ret %) (-> % :args :amount))))
  (defexpect decrement-entity-speed
    (expect nil (:check-failed (run-specs `input/dec-speed)))))
