(ns testing.input
  (:require [play-clj.core :refer :all]))

(def speed 5)

(defn inc-speed
  [x]
  (+ x speed))

(defn dec-speed
  [x]
  (- x speed))

(defn move
  [entity direction]
  (case direction
    :down (update entity :y dec-speed)
    :up (update entity :y inc-speed)
    :left (update entity :x dec-speed)
    :right (update entity :x inc-speed)
    nil))
